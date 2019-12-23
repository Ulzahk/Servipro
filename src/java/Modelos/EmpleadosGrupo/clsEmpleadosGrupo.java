
package Modelos.EmpleadosGrupo;


public class clsEmpleadosGrupo {
    
    public int Id_empleados_grupo;
    public clsGrupo obclsGrupo;
    public clsEmpleado obclsEmpleado;

    public int getId_empleados_grupo() {
        return Id_empleados_grupo;
    }

    public void setId_empleados_grupo(int Id_empleados_grupo) {
        this.Id_empleados_grupo = Id_empleados_grupo;
    }

    public clsGrupo getObclsGrupo() {
        return obclsGrupo;
    }

    public void setObclsGrupo(clsGrupo obclsGrupo) {
        this.obclsGrupo = obclsGrupo;
    }

    public clsEmpleado getObclsEmpleado() {
        return obclsEmpleado;
    }

    public void setObclsEmpleado(clsEmpleado obclsEmpleado) {
        this.obclsEmpleado = obclsEmpleado;
    }
    
}
