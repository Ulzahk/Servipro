/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servipro.DaoAPIVIEJO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
//import com.servipro.repository.UsuarioCRUDRepository;

@Service
/**
 *
 * @author PRACTICANTE
 * @see
 * Clase Abstracta que implementa el la interfaz de servicio generico
 * esto cnon el fin de que sirva para varios tipos de entidades y que no este vinculado
 * solo a un unico tipo de entidad
 * Adicionalmente se vale de un metodo abstracto que usa la interfaz CrudRepository de Spring Framework
 * para realizar el acceso a la base de datos
 */
public abstract class ServicioGenericoImpl<T,ID extends Serializable>  implements ServicioGenericoAPI<T, ID>{

    @Override
    public T guardar(T entidad) {
        return getDao().save(entidad); 
    }

    @Override
    public void borrar(ID id) {
        getDao().deleteById(id);
    }

    @Override
    public T obtener(ID id) {
        
        try {
            Optional<T> obj = getDao().findById(id);
        if(obj.isPresent()){
            return obj.get();
        }
        System.out.print("Error: el usuario no existe");
        return null;
        } catch (Exception e) {
            throw e;
        } 
    }

    @Override
    public List<T> obtenerTodos() {
        List<T> ListaDeEntidades = new ArrayList<>();
        getDao().findAll().forEach(obj -> ListaDeEntidades.add(obj));
        return ListaDeEntidades;
    }
    
    public abstract CrudRepository <T,ID> getDao();
    
}
