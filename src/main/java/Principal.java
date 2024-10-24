import calculos.CalculadoraDeTiempo;
import calculos.FiltroRecomendacion;
import modelos.Episodios;
import modelos.Pelicula;
import modelos.Serie;

public class Principal {
    public static void main(String[] args) {
        Pelicula miPelicula = new Pelicula();

        miPelicula.setNombre("Titanic");
        miPelicula.setFechaDeLanzamiento(1997);
        miPelicula.setDuracion(195);
        miPelicula.setIncluido(true);

        miPelicula.muestraFichaTecnica();
        miPelicula.evalua(10);
        miPelicula.evalua(10);
        miPelicula.evalua(7.8);

        System.out.println(miPelicula.getTotalEvaluaciones());
        System.out.println(miPelicula.calculaMedia());

        System.out.println("----------------------------------");

        Serie casaDePapel = new Serie();
        casaDePapel.setNombre("La Casa de Papel");
        casaDePapel.setFechaDeLanzamiento(2017);
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

    }
}
