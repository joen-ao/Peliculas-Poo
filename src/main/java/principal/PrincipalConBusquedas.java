package principal;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import exceptions.ErrorDuracionException;
import modelos.Titulo;
import modelos.TituloOmdb;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalConBusquedas {

    private static final String API_KEY = "9cf351f8";
    private static final String URL = "https://www.omdbapi.com/?t=";
    private static final String EXIT_COMAND = "exit";
    public static final String JSON_FILE = "titulos.json";


    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner lectura = new Scanner(System.in);
        List<Titulo> titulos = new ArrayList<>();
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().create();

        while (true){
            System.out.println("Ingrese el nombre de la Pelicula que desea buscar: ");
            var busqueda = lectura.nextLine();

            if (busqueda.equalsIgnoreCase(EXIT_COMAND)){
                break;
            }

            try {
                String json = fetchMovieData(busqueda);
                TituloOmdb miTituloOmdb = gson.fromJson(json, TituloOmdb.class);
                Titulo miTitulo = new Titulo(miTituloOmdb);
                titulos.add(miTitulo);

                System.out.println("Mi titulo ya convertido: "+miTitulo);

            }catch (NumberFormatException e){
                System.out.println("Ocurrio un error: " + e.getMessage());
            }
            catch (IllegalArgumentException e){
                System.out.println("Ocurrio un error en la URI, verifique la direccion ");
            }
            catch (ErrorDuracionException e){ //revisar porque no se activa la excepcion
                System.out.println(e.getMessage());
            }
        }

        saveTitlesToFile(titulos, gson);
        System.out.println("Fin del programa");
    }

    private static String fetchMovieData(String busqueda) throws IOException, InterruptedException{
        String direccion = URL +
                busqueda.replace(" ", "+") + "&apikey="+ API_KEY;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    private static void saveTitlesToFile(List<Titulo> titulos, Gson gson){
        try(FileWriter escritura = new FileWriter(JSON_FILE)){
            gson.toJson(titulos, escritura);
        }catch (IOException e){
            System.out.println("Ocurrio un error al guardar el archivo: " + e.getMessage());
        }
    }
}
