/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.servipro.repository;

import main.java.com.servipro.entity.Tipo_nov;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author PRACTICANTE
 */

@Repository ("Tipo_novJpaRepository")
public interface Tipo_novJpaRepository extends JpaRepository<Tipo_nov, Serializable> {
    
//    public abstract Tipo_nov findByNombre_nov(String nombre_nov);
    
//    public abstract Tipo_nov findByEstado_nov(boolean estado_nov);
    
//    public abstract Tipo_nov findByNombre_novAndEstado_nov(String nombre_nov, boolean estado_nov);

//    public abstract List<Tipo_nov> findByNombre_novOrderByEstado_nov(String nombre_nov);

//    public void delete(int id_nov);
    
}
