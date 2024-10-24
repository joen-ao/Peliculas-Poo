package calculos;

import modelos.Pelicula;
import modelos.Titulo;

public class CalculadoraDeTiempo {

    private int tiempoTotal;

    public int getTiempoTotal() {
        return tiempoTotal;
    }

    public void setTiempoTotal(int tiempoTotal) {
        this.tiempoTotal = tiempoTotal;
    }

    public void incluye(Titulo titulo) {

            this.tiempoTotal += titulo.getDuracion();

        
    }
}
