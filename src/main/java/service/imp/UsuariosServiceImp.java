/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.imp;

import com.example.demo4.entity.Usuarios;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import service.usuariosservice;
import com.example.demo4.repository.UsuariosJpaRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author PRACTICANTE
 */
@Service("usuariosServiceImp")
public class UsuariosServiceImp implements usuariosservice{
    
    @Autowired
    @Qualifier ("usuariosJpaRepository")
    private UsuariosJpaRepository usuariosJpaRepository;

    @Override
    public List<Usuarios> listAllUsuarios() {
        return usuariosJpaRepository.findAll();
    }

    @Override
    public Usuarios addUsuarios(Usuarios usuarios) {
        return usuariosJpaRepository.save(usuarios);
    }

    @Override
    public Usuarios updateUsuarios(Usuarios usuarios) {  
        return usuariosJpaRepository.save(usuarios);
    }

    @Override
    public int deleteUsuarios(int id) {
        usuariosJpaRepository.deleteById(id);
        return 0;
    }
    
}
