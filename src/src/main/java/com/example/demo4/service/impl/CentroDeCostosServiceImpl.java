
package com.example.demo4.service.impl;

import com.example.demo4.commons.GenericServiceImpl;
import com.example.demo4.dao.api.CentroDeCostosDaoApi;
import com.example.demo4.entity.CentroDeCostosEntity;
import com.example.demo4.services.api.CentroDeCostosServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class CentroDeCostosServiceImpl extends GenericServiceImpl<CentroDeCostosEntity, Long> implements CentroDeCostosServiceAPI{

    @Autowired
    private CentroDeCostosDaoApi centroDeCostosDaoApi;
    
    @Override
    public CrudRepository<CentroDeCostosEntity, Long> getDao() {
        return centroDeCostosDaoApi;
    }
    
}
