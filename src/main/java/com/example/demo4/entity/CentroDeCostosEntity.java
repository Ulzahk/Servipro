
package com.example.demo4.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="centro_de_costos")

public class CentroDeCostosEntity {
    
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_costos")
    private Long id;
    
    @Column(name="nombre_costos")
    private String nombre;
    
    @Column(name="estado_costos")
    private boolean estadoa;
    
    @Column(name="estado_costosI")
    private boolean estadoin;
    
    public CentroDeCostosEntity(){}

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean getEstadoa() {
        return estadoa;
    }

    public boolean getEstadoin() {
        return estadoin;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEstadoa(boolean estadoa) {
        this.estadoa = estadoa;
    }

    public void setEstadoin(boolean estadoin) {
        this.estadoin = estadoin;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }
  
}
