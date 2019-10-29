/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servipro.DaoAPIVIEJO;

import com.servipro.entity.UsuarioEntity;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author PRACTICANTE
 */
public interface UsuarioDaoAPI extends CrudRepository<UsuarioEntity, Long> {
    
}
