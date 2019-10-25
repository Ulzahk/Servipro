/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servipro.repository;
import com.servipro.entity.UsuarioEntity;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author PRACTICANTE
 */
@Repository ("usuarioJpaRepository")
public interface UsuarioJpaRepository extends JpaRepository <UsuarioEntity,Serializable>{
    
}
