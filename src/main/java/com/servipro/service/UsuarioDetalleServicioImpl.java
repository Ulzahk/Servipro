/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servipro.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import com.servipro.entity.AuthorityEntity;
import com.servipro.repository.UsuarioRepositorio;
import com.servipro.entity.UsuarioEntity;
/**
 *
 * @author PRACTICANTE
 */

@Service("UsuarioDetalleServicioImpl")
public class UsuarioDetalleServicioImpl implements UserDetailsService {
    
    @Autowired
    @Qualifier("UsuarioRepositorio")
    private UsuarioRepositorio usuarioRepositorio;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        	
     //Buscar el usuario con el repositorio y si no existe lanzar una exepcion
      UsuarioEntity appUser = 
                 usuarioRepositorio.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("No existe usuario"));
		
    //Mapear nuestra lista de Authority con la de spring security 
    List grantList = new ArrayList();
    for (AuthorityEntity authority: appUser.getAuthority()) {
        // ROLE_USER, ROLE_ADMIN,..
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority.getAuthority());
            grantList.add(grantedAuthority);
    }
		
    //Crear El objeto UserDetails que va a ir en sesion y retornarlo.
    UserDetails user = (UserDetails) new User(appUser.getIdusuario(), appUser.getContrasena(), grantList);
         return user;
    }
    
}
