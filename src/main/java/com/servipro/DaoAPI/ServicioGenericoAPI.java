/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servipro.DaoAPI;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author PRACTICANTE
 */
public interface ServicioGenericoAPI <T, ID extends Serializable> {
    T guardar(T entidad);
    void borrar(ID id);
    T obtener(ID id);
    List<T> obtenerTodos();
}
