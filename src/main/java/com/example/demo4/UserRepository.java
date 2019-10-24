/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo4;
import java.util.List;
import com.example.demo4.Usuario;
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