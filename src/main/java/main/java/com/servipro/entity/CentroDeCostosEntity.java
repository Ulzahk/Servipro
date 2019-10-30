
package main.java.com.servipro.entity;

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
    private String estadoa;
    
    @Column(name="estado_costosI")
    private String estadoin;
    
    public CentroDeCostosEntity(){}

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
  
}
