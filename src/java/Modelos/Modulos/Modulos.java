
package Modelos.Modulos;


public class Modulos{

    private int id_modulo;
    private String nombre_modulo;

    public Modulos() {
    }

    public Modulos(String nombre_modulo) {
        this.nombre_modulo = nombre_modulo;
    }

    public Modulos(int id_modulo, String nombre_modulo) {
        this.id_modulo = id_modulo;
        this.nombre_modulo = nombre_modulo;
    }

    public int getId_modulo() {
        return id_modulo;
    }

    public void setId_modulo(int id_modulo) {
        this.id_modulo = id_modulo;
    }

    public String getNombre_modulo() {
        return nombre_modulo;
    }

    public void setNombre_modulo(String nombre_modulo) {
        this.nombre_modulo = nombre_modulo;
    }
}
