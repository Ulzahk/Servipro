
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_costos")
    private Long id;
    
    @Column(name="nombre_costos")
    private String nombre;
    
    @Column(name="documento_costos", unique = true)
    private Integer documento;
    
    @Column(name="estado_costos")
    private boolean estadoa;
    
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
