/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo4.service.impl;

import com.example.demo4.commons.GenericServiceImpl;
import com.example.demo4.dao.api.EmpleadosDaoApi;
import com.example.demo4.entity.EmpleadosEntity;
import com.example.demo4.services.api.EmpleadosServiceAPI;
import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class EmpleadosServiceImpl extends GenericServiceImpl<EmpleadosEntity, Integer>implements EmpleadosServiceAPI{

    @Autowired
    private EmpleadosDaoApi empleadosDaoApi;
    
    
    @Override
    public CrudRepository<EmpleadosEntity, Integer> getDao() {
        return empleadosDaoApi;
    }
    
}
