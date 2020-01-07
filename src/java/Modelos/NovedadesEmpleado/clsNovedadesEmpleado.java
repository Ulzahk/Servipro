
package Modelos.NovedadesEmpleado;


public class clsNovedadesEmpleado {
    
    public int Id_novedad_empleado;
    public clsEmpleado obclsEmpleado;
    public clsTipoNovedad obclsTipoNovedad;
    public String detalle;
    public String fecha;
    public int dia;
    public clsGrupoEmpl obclsGrupoEmpl;

    public int getId_novedad_empleado() {
        return Id_novedad_empleado;
    }

    public void setId_novedad_empleado(int Id_novedad_empleado) {
        this.Id_novedad_empleado = Id_novedad_empleado;
    }

    public clsEmpleado getObclsEmpleado() {
        return obclsEmpleado;
    }

    public void setObclsEmpleado(clsEmpleado obclsEmpleado) {
        this.obclsEmpleado = obclsEmpleado;
    }

    public clsTipoNovedad getObclsTipoNovedad() {
        return obclsTipoNovedad;
    }

    public void setObclsTipoNovedad(clsTipoNovedad obclsTipoNovedad) {
        this.obclsTipoNovedad = obclsTipoNovedad;
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

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public clsGrupoEmpl getObclsGrupoEmpl() {
        return obclsGrupoEmpl;
    }

    public void setObclsGrupoEmpl(clsGrupoEmpl obclsGrupoEmpl) {
        this.obclsGrupoEmpl = obclsGrupoEmpl;
    }
     
}
