package modelos;

import com.google.gson.annotations.SerializedName;
import exceptions.ErrorDuracionException;

public class Titulo implements Comparable<Titulo> {

    private String nombre;
    private int fechaDeLanzamiento;
    private int duracion;
    private boolean incluido;
    private double sumaDeLasEvaluaciones;
    private int totalEvaluaciones;

    public Titulo(TituloOmdb miTituloOmdb) {
        this.nombre = miTituloOmdb.title();
        this.fechaDeLanzamiento = Integer.valueOf(miTituloOmdb.year());
        if (miTituloOmdb.runtime().contains("N/A")){
            throw new ErrorDuracionException("La duración contiene un N/A");
        }
        this.duracion = Integer.valueOf(miTituloOmdb.runtime().substring(0,3).replace(" ",""));


    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaDeLanzamiento(int fechaDeLanzamiento) {
        this.fechaDeLanzamiento = fechaDeLanzamiento;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void setIncluido(boolean incluido) {
        this.incluido = incluido;
    }

    public String getNombre() {
        return nombre;
    }

    public int getFechaDeLanzamiento() {
        return fechaDeLanzamiento;
    }

    public int getDuracion() {
        return duracion;
    }

    public boolean isIncluido() {
        return incluido;
    }

    public int getTotalEvaluaciones() {
        return totalEvaluaciones;
    }

    public Titulo(String nombre, int fechaDeLanzamiento) {
        this.nombre = nombre;
        this.fechaDeLanzamiento = fechaDeLanzamiento;
    }

    public void muestraFichaTecnica() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Fecha de lanzamiento: " + fechaDeLanzamiento);
        System.out.println("Duración: " + getDuracion());
    }

    public void evalua(double nota){
        sumaDeLasEvaluaciones += nota;
        totalEvaluaciones++;
    }

    public double calculaMedia(){
        return (sumaDeLasEvaluaciones/totalEvaluaciones);
    }

    @Override
    public int compareTo(Titulo otroTitulo) {
        return this.getNombre().compareTo(otroTitulo.getNombre());
    }

    @Override
    public String toString() {
        return "(nombre='" + nombre  +
                ", fechaDeLanzamiento=" + fechaDeLanzamiento+
                ", duracion=" + duracion+")";
    }
}
