/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo4.model;

/**
 *
 * @author PRACTICANTE
 */
public class EmpleadosModel {
    
    private Integer id_empleado;
    private String tipo_documento;
    private Integer documentoEmpleado;
    private String nombreEmpleado;
    private String telefono;
    private String id_costos;
    private Integer id_cargo;

    public EmpleadosModel(){}

    public Integer getId_empleado() {
        return id_empleado;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public Integer getDocumentoEmpleado() {
        return documentoEmpleado;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public String getTelefono() {
        return telefono;
    }

    public Integer getId_cargo() {
        return id_cargo;
    }

    public void setId_empleado(Integer id_empleado) {
        this.id_empleado = id_empleado;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public void setDocumentoEmpleado(Integer documentoEmpleado) {
        this.documentoEmpleado = documentoEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setId_cargo(Integer id_cargo) {
        this.id_cargo = id_cargo;
    }

    @Override
    public String toString() {
        return "EmpleadosModel{" + "id_empleado=" + id_empleado + ", tipo_documento=" + tipo_documento + ", documentoEmpleado=" + documentoEmpleado + ", nombreEmpleado=" + nombreEmpleado + ", telefono=" + telefono + ", id_cargo=" + id_cargo + '}';
    }

    public EmpleadosModel(Integer id_empleado, String tipo_documento, Integer documentoEmpleado, String nombreEmpleado, String telefono, String id_costos, Integer id_cargo) {
        this.id_empleado = id_empleado;
        this.tipo_documento = tipo_documento;
        this.documentoEmpleado = documentoEmpleado;
        this.nombreEmpleado = nombreEmpleado;
        this.telefono = telefono;
        this.id_costos = id_costos;
        this.id_cargo = id_cargo;
    }

    /**
     * @return the id_costos
     */
    public String getId_costos() {
        return id_costos;
    }

    /**
     * @param id_costos the id_costos to set
     */
    public void setId_costos(String id_costos) {
        this.id_costos = id_costos;
    }

 
    
}
