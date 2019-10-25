/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servipro.DaoAPI;

import com.servipro.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author PRACTICANTE
 */
public interface UsuarioDaoAPI extends CrudRepository<Usuario, Long> {
    
}
