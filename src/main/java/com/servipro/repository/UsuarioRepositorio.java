/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servipro.repository;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.servipro.entity.UsuarioEntity;

/**
 *
 * @author PRACTICANTE
 */
@Repository("UsuarioRepositorio")
public interface UsuarioRepositorio extends CrudRepository<UsuarioEntity, Long>{
    public Optional<UsuarioEntity> findByUsername(String username);
    
}
