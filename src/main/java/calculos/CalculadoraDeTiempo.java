package calculos;

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
        System.out.println("Incluyendo la duracion en minutos de: " + titulo.getNombre());
            this.tiempoTotal += titulo.getDuracion();

        
    }
}
