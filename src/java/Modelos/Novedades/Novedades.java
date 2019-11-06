
package Modelos.Novedades;


public class Novedades {
    
    private int id_novedad;
    private String descripcion;
    private String alias;

    public Novedades() {
    }

    public Novedades(String descripcion) {
        this.descripcion = descripcion;
    }

    public Novedades(int id_novedad, String descripcion, String alias) {
        this.id_novedad = id_novedad;
        this.descripcion = descripcion;
        this.alias = alias;
    }

    public int getId_novedad() {
        return id_novedad;
    }

    public void setId_novedad(int id_novedad) {
        this.id_novedad = id_novedad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

}
