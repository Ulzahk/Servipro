
package Modelos.CentroDeCostos;

public class CentroDeCostos {
    
    private int id_ccostos;
    private String nombre_ccostos;

    public CentroDeCostos() {
    }

    public CentroDeCostos(String nombre_ccostos) {
        this.nombre_ccostos = nombre_ccostos;
    }

    public CentroDeCostos(int id_ccostos, String nombre_ccostos) {
        this.id_ccostos = id_ccostos;
        this.nombre_ccostos = nombre_ccostos;
    }

    public int getId_ccostos() {
        return id_ccostos;
    }

    public void setId_ccostos(int id_ccostos) {
        this.id_ccostos = id_ccostos;
    }

    public String getNombre_ccostos() {
        return nombre_ccostos;
    }

    public void setNombre_ccostos(String nombre_ccostos) {
        this.nombre_ccostos = nombre_ccostos;
    }

}
