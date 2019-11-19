
package Modelos.Grupos;


public class Grupos {
    
    private int id_grupo;
    private String nombre_grupo;

    public Grupos() {
    }

    public Grupos(String nombre_grupo) {
        this.nombre_grupo = nombre_grupo;
    }

    public Grupos(int id_grupo, String nombre_grupo) {
        this.id_grupo = id_grupo;
        this.nombre_grupo = nombre_grupo;
    }

    public int getId_grupo() {
        return id_grupo;
    }

    public void setId_grupo(int id_grupo) {
        this.id_grupo = id_grupo;
    }

    public String getNombre_grupo() {
        return nombre_grupo;
    }

    public void setNombre_grupo(String nombre_grupo) {
        this.nombre_grupo = nombre_grupo;
    }

}
