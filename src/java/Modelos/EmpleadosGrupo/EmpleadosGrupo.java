
package Modelos.EmpleadosGrupo;


public class EmpleadosGrupo {
    
    private int id_empleados_grupo;
    private int id_grupo;
    private int id_empleado;

    public EmpleadosGrupo() {
    }

    public EmpleadosGrupo(int id_grupo, int id_empleado) {
        this.id_grupo = id_grupo;
        this.id_empleado = id_empleado;
    }

    public EmpleadosGrupo(int id_empleados_grupo, int id_grupo, int id_empleado) {
        this.id_empleados_grupo = id_empleados_grupo;
        this.id_grupo = id_grupo;
        this.id_empleado = id_empleado;
    }

    public int getId_empleados_grupo() {
        return id_empleados_grupo;
    }

    public void setId_empleados_grupo(int id_empleados_grupo) {
        this.id_empleados_grupo = id_empleados_grupo;
    }

    public int getId_grupo() {
        return id_grupo;
    }

    public void setId_grupo(int id_grupo) {
        this.id_grupo = id_grupo;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }
    
    
    
}
