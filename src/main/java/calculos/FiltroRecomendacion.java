package calculos;

public class FiltroRecomendacion {
    public void filtra(Clasificacion clasificacion) {
        if(clasificacion.getClasificacion() >= 4) {
            System.out.println("¡Te recomendamos este título!");
        } else if (clasificacion.getClasificacion() >= 2) {
            System.out.println("Popular en el momento");
        } else {
            System.out.println("Colocalo en tu lista de deseos");
        }
    }
}
