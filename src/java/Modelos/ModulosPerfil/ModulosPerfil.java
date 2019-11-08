
package Modelos.ModulosPerfil;


public class ModulosPerfil {
    
    private int id_modulo_perfil;
    private int id_modulo;
    private int id_perfil;

    public ModulosPerfil() {
    }

    public ModulosPerfil(int id_modulo, int id_perfil) {
        this.id_modulo = id_modulo;
        this.id_perfil = id_perfil;
    }

    public ModulosPerfil(int id_modulo_perfil, int id_modulo, int id_perfil) {
        this.id_modulo_perfil = id_modulo_perfil;
        this.id_modulo = id_modulo;
        this.id_perfil = id_perfil;
    }

    public int getId_modulo_perfil() {
        return id_modulo_perfil;
    }

    public void setId_modulo_perfil(int id_modulo_perfil) {
        this.id_modulo_perfil = id_modulo_perfil;
    }

    public int getId_modulo() {
        return id_modulo;
    }

    public void setId_modulo(int id_modulo) {
        this.id_modulo = id_modulo;
    }

    public int getId_perfil() {
        return id_perfil;
    }

    public void setId_perfil(int id_perfil) {
        this.id_perfil = id_perfil;
    }
    
}
