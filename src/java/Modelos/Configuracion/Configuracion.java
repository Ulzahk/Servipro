
package Modelos.Configuracion;

public class Configuracion {
    
    private int id_configuracion;
    private String desconfiguracion;
    private String desconfiguracion_d;
    private String nombre_variable;
    private int valor;
    private int id_modulo;

    public Configuracion() {
    }

    public Configuracion(String desconfiguracion, String desconfiguracion_d, String nombre_variable, int valor, int id_modulo) {
        this.desconfiguracion = desconfiguracion;
        this.desconfiguracion_d = desconfiguracion_d;
        this.nombre_variable = nombre_variable;
        this.valor = valor;
        this.id_modulo = id_modulo;
    }

    public Configuracion(int id_configuracion, String desconfiguracion, String desconfiguracion_d, String nombre_variable, int valor, int id_modulo) {
        this.id_configuracion = id_configuracion;
        this.desconfiguracion = desconfiguracion;
        this.desconfiguracion_d = desconfiguracion_d;
        this.nombre_variable = nombre_variable;
        this.valor = valor;
        this.id_modulo = id_modulo;
    }

    public int getId_configuracion() {
        return id_configuracion;
    }

    public void setId_configuracion(int id_configuracion) {
        this.id_configuracion = id_configuracion;
    }

    public String getDesconfiguracion() {
        return desconfiguracion;
    }

    public void setDesconfiguracion(String desconfiguracion) {
        this.desconfiguracion = desconfiguracion;
    }

    public String getDesconfiguracion_d() {
        return desconfiguracion_d;
    }

    public void setDesconfiguracion_d(String desconfiguracion_d) {
        this.desconfiguracion_d = desconfiguracion_d;
    }

    public String getNombre_variable() {
        return nombre_variable;
    }

    public void setNombre_variable(String nombre_variable) {
        this.nombre_variable = nombre_variable;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getId_modulo() {
        return id_modulo;
    }

    public void setId_modulo(int id_modulo) {
        this.id_modulo = id_modulo;
    }
   
    
}
