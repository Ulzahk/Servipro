/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.servipro.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 *
 * @author PRACTICANTE
 */

@Entity
@Table(name="Tipo_nov")
public class Tipo_nov {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_nov")
    private int id_nov;
    
    @NotBlank(message = "El campo de nombre es obligatorio")
    @Column(name="nombre_nov")
    private String nombre_nov;
    
    @Column(name="estado_nov")
    private boolean estado_nov;
    
    public Tipo_nov(){}

    public int getId_nov() {
        return id_nov;
    }

    public void setId_nov(int id_nov) {
        this.id_nov = id_nov;
    }

    public String getNombre_nov() {
        return nombre_nov;
    }

    public void setNombre_nov(String nombre_nov) {
        this.nombre_nov = nombre_nov;
    }

    public boolean isEstado_nov() {
        return estado_nov;
    }

    public void setEstado_nov(boolean estado_nov) {
        this.estado_nov = estado_nov;
    }

    public Tipo_nov(int id_nov, String nombre_nov, boolean estado_nov) {
        this.id_nov = id_nov;
        this.nombre_nov = nombre_nov;
        this.estado_nov = estado_nov;
    }

    @Override
    public String toString() {
        return "Tipo_nov{" + "id_nov=" + id_nov + ", nombre_nov=" + nombre_nov + ", estado_nov=" + estado_nov + '}';
    }
    
    
    
    
    
}
