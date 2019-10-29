/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servipro.service;

import java.io.Serializable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import com.servipro.entity.UsuarioEntity;

/**
 *
 * @author PRACTICANTE
 */
@Service("UsuarioServiceImplAbstract")
public abstract class UsuarioServiceImplAbstract<UsuarioEntity,ID extends Serializable> {
    public abstract CrudRepository<UsuarioEntity,ID> getDao();
    
    public UsuarioEntity save(UsuarioEntity usuario){
        return getDao().save(usuario);
    }
    
}
