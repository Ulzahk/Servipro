/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.servipro.commons;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
/**
 *
 * @author PRACTICANTE
 */
public abstract class GenericServiceImpl<T,ID extends Serializable> implements GenericServiceApi<T, ID>{

    @Override
    public T save(T entity) {
    return getDao().save(entity);    
    }

    @Override
    public void delete(ID id) {
    getDao().deleteById(id);
    }

    @Override
    public T get(ID id) {
        Optional<T> obj = getDao().findById(id);
        if(obj.isPresent()){
        return obj.get();
        }
        return null;
    }

    @Override
    public List<T> getAll() {
    List<T> returnList = new ArrayList<>(); 
    getDao().findAll().forEach(obj -> returnList.add(obj));
    return returnList;
    }
    
    public abstract CrudRepository<T, ID> getDao();
    
}
