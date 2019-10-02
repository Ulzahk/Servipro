/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.example.demo4.entity.Usuarios;
import java.util.List;

/**
 *
 * @author PRACTICANTE
 */
public interface usuariosservice {
    public abstract List <Usuarios> listAllUsuarios();
    public abstract Usuarios addUsuarios(Usuarios usuarios);
    public abstract int deleteUsuarios(int id);
    public abstract Usuarios updateUsuarios(Usuarios usuarios);
    
}
