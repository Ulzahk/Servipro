/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servipro.service;

import com.servipro.entity.Tipo_nov;
import java.util.List;

/**
 *
 * @author PRACTICANTE
 */
public interface Tipo_novService {
    
    public abstract List<Tipo_nov> listAllTipo_nov();
    public abstract Tipo_nov addTipo_nov(Tipo_nov tipo_nov);
    public abstract Tipo_nov removeTipo_nov(int id_nov);
    public abstract Tipo_nov updateTipo_nov(Tipo_nov tipo_nov);
    
    
}
