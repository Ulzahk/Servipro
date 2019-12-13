
package Modelos.NovedadesEmpleado;


public class NovedadesEmpleado {
    
    private int id_novedad_empleado;
    private int id_empleado;
    private int id_novedad;
    private String detalle;
    private String fecha;
    private int día;

    public NovedadesEmpleado() {
    }

    public NovedadesEmpleado(int id_empleado, int id_novedad, String detalle, String fecha, int día) {
        this.id_empleado = id_empleado;
        this.id_novedad = id_novedad;
        this.detalle = detalle;
        this.fecha = fecha;
        this.día = día;
    }

    public NovedadesEmpleado(int id_novedad_empleado, int id_empleado, int id_novedad, String detalle, String fecha, int día) {
        this.id_novedad_empleado = id_novedad_empleado;
        this.id_empleado = id_empleado;
        this.id_novedad = id_novedad;
        this.detalle = detalle;
        this.fecha = fecha;
        this.día = día;
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

    public int getId_novedad() {
        return id_novedad;
    }

    public void setId_novedad(int id_novedad) {
        this.id_novedad = id_novedad;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getDía() {
        return día;
    }

    public void setDía(int día) {
        this.día = día;
    }

   
    

    

    
    
    
}
