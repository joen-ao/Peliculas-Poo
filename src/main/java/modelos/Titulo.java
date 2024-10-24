package modelos;

public class Titulo {
    private String nombre;
    private int fechaDeLanzamiento;
    private int duracion;
    private boolean incluido;
    private double sumaDeLasEvaluaciones;
    private int totalEvaluaciones;

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
}
