/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo4.dao.api;

import com.example.demo4.entity.EmpleadosEntity;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author PRACTICANTE
 */
public interface EmpleadosDaoApi extends CrudRepository<EmpleadosEntity, Integer>{
    
}
