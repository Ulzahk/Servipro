/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servipro.DaoAPI;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author PRACTICANTE
 */
public abstract class ServicioGenericoImpl<T,ID extends Serializable>  implements ServicioGenericoAPI<T, ID>{

    @Override
    public T guardar(T entidad) {
        return getDao().save(entidad); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void borrar(ID id) {
        
    }

    @Override
    public T obtener(ID id) {
        return null;
    }

    @Override
    public List<T> obtenerTodos() {
        return null;
    }
    
    public abstract CrudRepository <T,ID> getDao();
    
}
