/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servipro.converters;

import com.servipro.entity.UsuarioEntity;
import com.servipro.model.UsuarioModel;
import org.springframework.stereotype.Component;

/**
 *
 * @author PRACTICANTE
 */

@Component("UsuarioConverter")
public class UsuarioConverter {
    public UsuarioEntity UsuarioModelToUsuarioEntity(UsuarioModel usuariomodel)
    {
        UsuarioEntity usuarioentity = new UsuarioEntity();
        usuarioentity.setIdperfil(Long.MIN_VALUE);
        
        return usuarioentity;
    }
}
