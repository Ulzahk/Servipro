/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servipro.service.impl;

import com.servipro.entity.UsuarioEntity;
import com.servipro.repository.UsuarioJpaRepository;
import com.servipro.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author PRACTICANTE
 */
@Service("UsuarioServiceImpl")
public class UsuarioServiceImpl implements UsuarioService{
    
    @Autowired//se le indica a springboot que busque en sus "Beans" lo que sigue debajo (son todo aquelllo que comienza con @ como unos repositorios raros)
    @Qualifier("usuarioJpaRepository")//este inyecta la dependecnia (bean) (repositorio) "usuarioJpaRepository" que fue especificado en los parentesis para que se pueda usar en este archvio
    private UsuarioJpaRepository userJPARepository;//aca es como una especie de instanciamiento???, esta instruccion es necesaria


    @Override
    public UsuarioEntity addUsuario(UsuarioEntity usuario) {
        return userJPARepository.save(usuario); //To change body of generated methods, choose Tools | Templates.
    }
    
}
