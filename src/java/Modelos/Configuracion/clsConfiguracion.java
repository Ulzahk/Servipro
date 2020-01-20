
package Modelos.Configuracion;


public class clsConfiguracion {
    
    public int Id_configuracion;
    public String Nombre_configuracion;
    public String Descripcion_configuracion;
    public String Nombre_variable;
    public int Valor;
    public clsModulo obclsModulo;

    public int getId_configuracion() {
        return Id_configuracion;
    }

    public void setId_configuracion(int Id_configuracion) {
        this.Id_configuracion = Id_configuracion;
    }

    public String getNombre_configuracion() {
        return Nombre_configuracion;
    }

    public void setNombre_configuracion(String Nombre_configuracion) {
        this.Nombre_configuracion = Nombre_configuracion;
    }

    public String getDescripcion_configuracion() {
        return Descripcion_configuracion;
    }

    public void setDescripcion_configuracion(String Descripcion_configuracion) {
        this.Descripcion_configuracion = Descripcion_configuracion;
    }

    public String getNombre_variable() {
        return Nombre_variable;
    }

    public void setNombre_variable(String Nombre_variable) {
        this.Nombre_variable = Nombre_variable;
    }

    public int getValor() {
        return Valor;
    }

    public void setValor(int Valor) {
        this.Valor = Valor;
    }

    public clsModulo getObclsModulo() {
        return obclsModulo;
    }

    public void setObclsModulo(clsModulo obclsModulo) {
        this.obclsModulo = obclsModulo;
    }
    
}
