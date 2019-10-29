/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.servipro.commons;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author PRACTICANTE
 * @param <T>
 * @param <ID>
 */
public interface GenericServiceApi<T, ID extends Serializable>  {

    T save(T entity);
    void delete(ID id);
    T get(ID id);
    List<T> getAll();
    
}
