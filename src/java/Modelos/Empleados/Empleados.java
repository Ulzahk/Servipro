
package Modelos.Empleados;



public class Empleados {
    
    private int id_empleado;
    private String  tipo_documento;
    private String documento;
    private String nombre;
    private String telefono;
    private int id_ccostos;
    private int id_cargo;

    public Empleados() {
    }

    public Empleados(String tipo_documento, String documento, String Nombre, String telefono) {
        this.tipo_documento = tipo_documento;
        this.documento = documento;
        this.nombre = Nombre;
        this.telefono = telefono;
    }

    public Empleados(int id_empleado, String tipo_documento, String documento, String Nombre, String telefono, int id_ccostos, int id_cargo) {
        this.id_empleado = id_empleado;
        this.tipo_documento = tipo_documento;
        this.documento = documento;
        this.nombre = Nombre;
        this.telefono = telefono;
        this.id_ccostos = id_ccostos;
        this.id_cargo = id_cargo;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String Nombre) {
        this.nombre = Nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getId_ccostos() {
        return id_ccostos;
    }

    public void setId_ccostos(int id_ccostos) {
        this.id_ccostos = id_ccostos;
    }

    public int getId_cargo() {
        return id_cargo;
    }

    public void setId_cargo(int id_cargo) {
        this.id_cargo = id_cargo;
    }
    
    
    
}
