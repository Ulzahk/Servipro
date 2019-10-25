
package com.example.demo4.model;

import com.example.demo4.entity.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


public class CentroDeCostosModel {
    
    
    private Long id;
    private String nombre;
    private String estadoa;
    private String estadoin;
    
    public CentroDeCostosModel(){}

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEstadoa() {
        return estadoa;
    }

    public String getEstadoin() {
        return estadoin;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEstadoa(String estadoa) {
        this.estadoa = estadoa;
    }

    public void setEstadoin(String estadoin) {
        this.estadoin = estadoin;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

     @Override
     public String toString()
     {
         return this.id.toString();
     }
  
}
