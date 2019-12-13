/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos.NovedadesEmpleado2;

/**
 *
 * @author PRACTICANTE
 */
public class ModeloNovedadesEmpleado {
    
    private int Id_nov_emp2;
    private int Id_empleado;
    private int Id_novedad;
    private String Detalle;
    private int Id_tipo_novedad;
    private int Dia;
    
    public ModeloNovedadesEmpleado(){}

    public int getId_nov_emp2() {
        return Id_nov_emp2;
    }

    public void setId_nov_emp2(int Id_nov_emp2) {
        this.Id_nov_emp2 = Id_nov_emp2;
    }

    public int getId_empleado() {
        return Id_empleado;
    }

    public void setId_empleado(int Id_empleado) {
        this.Id_empleado = Id_empleado;
    }

    public int getId_novedad() {
        return Id_novedad;
    }

    public void setId_novedad(int Id_novedad) {
        this.Id_novedad = Id_novedad;
    }

    public String getDetalle() {
        return Detalle;
    }

    public void setDetalle(String Detalle) {
        this.Detalle = Detalle;
    }

    public int getId_tipo_novedad() {
        return Id_tipo_novedad;
    }

    public void setId_tipo_novedad(int Id_tipo_novedad) {
        this.Id_tipo_novedad = Id_tipo_novedad;
    }

    public int getDia() {
        return Dia;
    }

    public void setDia(int Dia) {
        this.Dia = Dia;
    }
    
    
    
}
