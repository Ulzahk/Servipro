
package Modelos.Usuarios;


public class UsuariosPerEmp {
    
    private String id_usuario;
    private int id_empleado;
    private String nombre;
    private String contraseña;
    private int id_perfil;
    private String descripcion_perfil;

    public UsuariosPerEmp() {
    }

    public UsuariosPerEmp(int id_empleado, String nombre, String contraseña, int id_perfil, String descripcion_perfil) {
        this.id_empleado = id_empleado;
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.id_perfil = id_perfil;
        this.descripcion_perfil = descripcion_perfil;
    }

    public UsuariosPerEmp(String id_usuario, int id_empleado, String nombre, String contraseña, int id_perfil, String descripcion_perfil) {
        this.id_usuario = id_usuario;
        this.id_empleado = id_empleado;
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.id_perfil = id_perfil;
        this.descripcion_perfil = descripcion_perfil;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public String getDescripcion_perfil() {
        return descripcion_perfil;
    }

    public void setDescripcion_perfil(String descripcion_perfil) {
        this.descripcion_perfil = descripcion_perfil;
    }
    
    
    
}
