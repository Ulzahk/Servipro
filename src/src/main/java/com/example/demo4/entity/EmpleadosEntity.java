/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo4.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Empleados")
public class EmpleadosEntity {
    
    public EmpleadosEntity(){}
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_empleado")
    private Integer id_empleado;
    
    @Column(name="tipo_documento")
    private String tipo_documento;
    
    //@PrimaryKeyJoinColumn(name="documentoEmpleado")
    
    @Column(name="documentoEmpleado",unique = true)
    private Integer documentoEmpleado;
    
    @Column(name="nombreEmpleado")
    private String nombreEmpleado;
    
    @Column(name="telefono")
    private String telefono;
    
    @Column(name="id_costos")
    private Integer id_costos;
    
    @Column(name="id_cargo")
    private Integer id_cargo;

    @Override
    public String toString() {
        return "EmpleadosEntity{" + "id_empleado=" + id_empleado + ", tipo_documento=" + tipo_documento + ", documentoEmpleado=" + documentoEmpleado + ", nombreEmpleado=" + nombreEmpleado + ", telefono=" + telefono + ", id_costos=" + id_costos + ", id_cargo=" + id_cargo + '}';
    }

    /**
     * @return the documentoEmpleado
     */
    public Integer getDocumentoEmpleado() {
        return documentoEmpleado;
    }

    /**
     * @return the id_cargo
     */
    public Integer getId_cargo() {
        return id_cargo;
    }

    /**
     * @return the id_empleado
     */
    public Integer getId_empleado() {
        return id_empleado;
    }

    /**
     * @return the nombreEmpleado
     */
    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @return the tipo_documento
     */
    public String getTipo_documento() {
        return tipo_documento;
    }

    /**
     * @param documentoEmpleado the documentoEmpleado to set
     */
    public void setDocumentoEmpleado(Integer documentoEmpleado) {
        this.documentoEmpleado = documentoEmpleado;
    }

    /**
     * @param id_cargo the id_cargo to set
     */
    public void setId_cargo(Integer id_cargo) {
        this.id_cargo = id_cargo;
    }

    /**
     * @param id_empleado the id_empleado to set
     */
    public void setId_empleado(Integer id_empleado) {
        this.id_empleado = id_empleado;
    }

    /**
     * @param nombreEmpleado the nombreEmpleado to set
     */
    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @param tipo_documento the tipo_documento to set
     */
    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    /**
     * @return the id_costos
     */
    public Integer getId_costos() {
        return id_costos;
    }

    /**
     * @param id_costos the id_costos to set
     */
    public void setId_costos(Integer id_costos) {
        this.id_costos = id_costos;
    }
 
}
