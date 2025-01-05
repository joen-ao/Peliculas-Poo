package principal;

import modelos.Pelicula;
import modelos.Serie;
import modelos.Titulo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PrincipalConListas {
    public static void main(String[] args) {
        Pelicula miPelicula = new Pelicula("Titanic", 1997);
        miPelicula.evalua(9);
        var peliculaDeJoen = new Pelicula("El señor de los anillos", 2001);
        peliculaDeJoen.evalua(6);
        Serie casaDePapel = new Serie("La Casa de Papel", 2017);


        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(miPelicula);
        lista.add(peliculaDeJoen);
        lista.add(casaDePapel);

//        for (Titulo item : lista) {
//            System.out.println(item);
//            if (item instanceof Pelicula pelicula) {
//                System.out.println(pelicula.getClasificacion());
//            }
//
//        }
        ArrayList<String> listaDeArtistas = new ArrayList<>();
        listaDeArtistas.add("Leonardo DiCaprio"); //ctrl + d para duplicar una linea
        listaDeArtistas.add("Jack Gillenhal");
        listaDeArtistas.add("Antony Hopkins");

        Collections.sort(listaDeArtistas);
        System.out.println("Lista de artistas ordenada alfabeticamente "+ listaDeArtistas);

        Collections.sort(lista);
        System.out.println("Lista de titulos ordenados: " + lista);

        lista.sort(Comparator.comparing(Titulo::getFechaDeLanzamiento));
        System.out.println("Lista de titulos ordenados por fecha: " + lista);
      }
}