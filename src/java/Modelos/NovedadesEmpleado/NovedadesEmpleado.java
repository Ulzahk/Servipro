
package Modelos.NovedadesEmpleado;


public class NovedadesEmpleado {
    
    private int id_novedad_empleado;
    private int id_empleado;
    private String detalle;
    private int tipo;
    private String fecha;

    public NovedadesEmpleado() {
    }

    public NovedadesEmpleado(int id_empleado, String detalle, int tipo, String fecha) {
        this.id_empleado = id_empleado;
        this.detalle = detalle;
        this.tipo = tipo;
        this.fecha = fecha;
    }

    public NovedadesEmpleado(String detalle, int tipo, String fecha) {
        this.detalle = detalle;
        this.tipo = tipo;
        this.fecha = fecha;
    }

    public NovedadesEmpleado(int id_novedad_empleado, int id_empleado, String detalle, int tipo, String fecha) {
        this.id_novedad_empleado = id_novedad_empleado;
        this.id_empleado = id_empleado;
        this.detalle = detalle;
        this.tipo = tipo;
        this.fecha = fecha;
    }

    public int getId_novedad_empleado() {
        return id_novedad_empleado;
    }

    public void setId_novedad_empleado(int id_novedad_empleado) {
        this.id_novedad_empleado = id_novedad_empleado;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
    
}
