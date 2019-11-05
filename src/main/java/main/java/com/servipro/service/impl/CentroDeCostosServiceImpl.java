
package main.java.com.servipro.service.impl;

import main.java.com.servipro.commons.GenericServiceImpl;
import main.java.com.servipro.dao.api.CentroDeCostosDaoApi;
import main.java.com.servipro.entity.CentroDeCostosEntity;
import main.java.com.servipro.service.api.CentroDeCostosServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class CentroDeCostosServiceImpl extends GenericServiceImpl<CentroDeCostosEntity, Long> implements CentroDeCostosServiceApi{

    @Autowired
    private CentroDeCostosDaoApi centroDeCostosDaoApi;
    
    @Override
    public CrudRepository<CentroDeCostosEntity, Long> getDao() {
        return centroDeCostosDaoApi;
    }
    
}
