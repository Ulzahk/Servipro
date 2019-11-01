
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
    private boolean estadoa;
    private Integer documento;
    
    
    public CentroDeCostosModel(){}

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean getEstadoa() {
        return estadoa;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEstadoa(boolean estadoa) {
        this.estadoa = estadoa;
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

    /**
     * @return the documento
     */
    public Integer getDocumento() {
        return documento;
    }

    /**
     * @param documento the documento to set
     */
    public void setDocumento(Integer documento) {
        this.documento = documento;
    }
  
}
