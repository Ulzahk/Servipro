/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo4.repository;

import com.example.demo4.entity.Usuarios;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author PRACTICANTE
 */
@Repository ("usuariosJpaRepository")
public interface UsuariosJpaRepository extends JpaRepository <Usuarios,Serializable>{
    
}
