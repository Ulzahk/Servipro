
package Modelos.CargoEmpleado;


public class CargoEmpleado {
    
    private int id_cargo;
    private String descripcion_cargo;

    public CargoEmpleado() {
    }

    public CargoEmpleado(String descripcion_cargo) {
        this.descripcion_cargo = descripcion_cargo;
    }
    
    public CargoEmpleado(int id_cargo, String descripcion_cargo) {
        this.id_cargo = id_cargo;
        this.descripcion_cargo = descripcion_cargo;
    }

    public int getId_cargo() {
        return id_cargo;
    }

    public void setId_cargo(int id_cargo) {
        this.id_cargo = id_cargo;
    }

    public String getDescripcion_cargo() {
        return descripcion_cargo;
    }

    public void setDescripcion_cargo(String descripcion_cargo) {
        this.descripcion_cargo = descripcion_cargo;
    }

}
