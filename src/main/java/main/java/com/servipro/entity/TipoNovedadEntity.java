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
@Table(name="Tipo_novedad")
public class TipoNovedadEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_tipo_novedad")
    private Integer id;
    
    @NotBlank(message = "El campo de descripcion es obligatorio")
    @Column(name="descripcion")
    private String descripcion;
    
    @Column(name="estado_tipo_novedad")
    private boolean estado;
    
    public TipoNovedadEntity(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public TipoNovedadEntity(Integer id, String descripcion, boolean estado) {
        this.id = id;
        this.descripcion = descripcion;
        this.estado = estado;
    }


    @Override
    public String toString() {
        return "TipoNovedadEntity{" + "id=" + id + ", descripcion=" + descripcion + ", estado=" + estado + '}';
    }

    
    
      
   
}
