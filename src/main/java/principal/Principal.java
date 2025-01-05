package principal;

import calculos.CalculadoraDeTiempo;
import calculos.FiltroRecomendacion;
import modelos.Episodios;
import modelos.Pelicula;
import modelos.Serie;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        Pelicula miPelicula = new Pelicula("Titanic",1997);

        miPelicula.setDuracion(195);
        miPelicula.setIncluido(true);

        miPelicula.muestraFichaTecnica();
        miPelicula.evalua(10);
        miPelicula.evalua(10);
        miPelicula.evalua(7.8);

        System.out.println(miPelicula.getTotalEvaluaciones());
        System.out.println(miPelicula.calculaMedia());

        System.out.println("----------------------------------");

        Serie casaDePapel = new Serie("La Casa de Papel",2017);
        casaDePapel.setTemporadas(5);
        casaDePapel.setEpisodios(10);
        casaDePapel.setMinutosPorEpisodio(50);
        System.out.println(casaDePapel.getDuracion());
        casaDePapel.muestraFichaTecnica();

        CalculadoraDeTiempo calculadora = new CalculadoraDeTiempo();
        calculadora.incluye(casaDePapel);
        calculadora.incluye(miPelicula);
        System.out.println("Tiempo necesario para ver todos tus titulos: " + calculadora.getTiempoTotal()+" minutos");

        FiltroRecomendacion filtro = new FiltroRecomendacion();
        filtro.filtra(miPelicula);

        Episodios episodio = new Episodios();
        episodio.setNombre("El atraco");
        episodio.setNumero("1");
        episodio.setTotalVisualizaciones(90);
        episodio.setSerie(casaDePapel);

        filtro.filtra(episodio);

        var peliculaDeJoen = new Pelicula("El señor de los anillos",2001);
        peliculaDeJoen.setDuracion(178);

        ArrayList<Pelicula> listaDePeliculas = new ArrayList<>();
        listaDePeliculas.add(miPelicula);
        listaDePeliculas.add(peliculaDeJoen);

        System.out.println("Total de peliculas: " + listaDePeliculas.size());
        System.out.println("toString de la pelicula: " + listaDePeliculas.get(1).toString());
        System.out.println(listaDePeliculas.toString());

    }
}
