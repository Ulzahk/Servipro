/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos.Usuarios;

/**
 *
 * @author PRACTICANTE
 */
public class clsEmpleados {
    
    public int Id_empleado;
    public String stPrimerNombre;
    public String stSegundoNombre;
    public String stPrimerApellido;
    public String stSegundoApellido;

    public int getId_empleado() {
        return Id_empleado;
    }

    public void setId_empleado(int Id_empleado) {
        this.Id_empleado = Id_empleado;
    }

    public String getStPrimerNombre() {
        return stPrimerNombre;
    }

    public void setStPrimerNombre(String stPrimerNombre) {
        this.stPrimerNombre = stPrimerNombre;
    }

    public String getStSegundoNombre() {
        return stSegundoNombre;
    }

    public void setStSegundoNombre(String stSegundoNombre) {
        this.stSegundoNombre = stSegundoNombre;
    }

    public String getStPrimerApellido() {
        return stPrimerApellido;
    }

    public void setStPrimerApellido(String stPrimerApellido) {
        this.stPrimerApellido = stPrimerApellido;
    }

    public String getStSegundoApellido() {
        return stSegundoApellido;
    }

    public void setStSegundoApellido(String stSegundoApellido) {
        this.stSegundoApellido = stSegundoApellido;
    }
}
