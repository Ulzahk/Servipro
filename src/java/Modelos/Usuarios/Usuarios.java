
package Modelos.Usuarios;


public class Usuarios {
    
    private String id_usuario;
    private int id_empleado;
    private String contraseña;
    private int id_perfil;

    public Usuarios() {
    }

    public Usuarios(int id_empleado, String contraseña, int id_perfil) {
        this.id_empleado = id_empleado;
        this.contraseña = contraseña;
        this.id_perfil = id_perfil;
    }

    public Usuarios(String id_usuario, int id_empleado, String contraseña, int id_perfil) {
        this.id_usuario = id_usuario;
        this.id_empleado = id_empleado;
        this.contraseña = contraseña;
        this.id_perfil = id_perfil;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getId_perfil() {
        return id_perfil;
    }

    public void setId_perfil(int id_perfil) {
        this.id_perfil = id_perfil;
    }
    
    
    
}
