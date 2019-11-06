
package Modelos.Perfil;


public class Perfil {
    
    private int id_perfil;
    private String descripcion_perfil;

    public Perfil() {
    }

    public Perfil(String descripcion_perfil) {
        this.descripcion_perfil = descripcion_perfil;
    }

    public Perfil(int id_perfil, String descripcion_perfil) {
        this.id_perfil = id_perfil;
        this.descripcion_perfil = descripcion_perfil;
    }

    public int getId_perfil() {
        return id_perfil;
    }

    public void setId_perfil(int id_perfil) {
        this.id_perfil = id_perfil;
    }
    
    public String getDescripcion_perfil() {
        return descripcion_perfil;
    }

    public void setDescripcion_perfil(String descripcion_perfil) {
        this.descripcion_perfil = descripcion_perfil;
    } 
}
