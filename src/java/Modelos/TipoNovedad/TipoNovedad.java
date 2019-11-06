
package Modelos.TipoNovedad;


public class TipoNovedad {
    
    private int id_tipo_novedad;
    private String descripcion;

    public TipoNovedad() {
    }

    public TipoNovedad(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoNovedad(int id_tipo_novedad, String descripcion) {
        this.id_tipo_novedad = id_tipo_novedad;
        this.descripcion = descripcion;
    }

    public int getId_tipo_novedad() {
        return id_tipo_novedad;
    }

    public void setId_tipo_novedad(int id_tipo_novedad) {
        this.id_tipo_novedad = id_tipo_novedad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
