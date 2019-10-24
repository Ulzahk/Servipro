/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servipro.repository;
import java.util.List;
import com.servipro.entity.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author practicante
 */

@Repository
public interface UserRepository extends CrudRepository<Usuario, Long> {
    
    List<Usuario> findByName(String name);
    
}