/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servipro.service;

import com.servipro.entity.UsuarioEntity;
import java.util.List;


/**
 *
 * @author PRACTICANTE
 */
public interface UsuarioService {
    public abstract UsuarioEntity save(UsuarioEntity usuario);
    public abstract List<UsuarioEntity> getAll();
    public abstract boolean Existe(int id);
    public abstract UsuarioEntity getById(int id);
}
