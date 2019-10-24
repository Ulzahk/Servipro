/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servipro.service.impl;

import com.servipro.service.Tipo_novService;
import com.servipro.entity.Tipo_nov;
import com.servipro.repository.Tipo_novJpaRepository;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author PRACTICANTE
 */
@Service("tipo_novServiceImpl")
public abstract class Tipo_novServiceImpl implements Tipo_novService {
        
//    private static Log LOG = LogFactory.getLog(Tipo_novServiceImpl.class);

    @Autowired
    @Qualifier("tipo_novJpaRepository")
    private Tipo_novJpaRepository tipo_novJpaRepository;

    @Override
    public List<Tipo_nov> listAllTipo_nov() {
//        LOG.info("Call: " + "listAllTipo_nov()");
        return tipo_novJpaRepository.findAll();
    }

    @Override
    public Tipo_nov addTipo_nov(Tipo_nov tipo_nov) {
//        LOG.info("Call: " + "addTipo_nov()");
        return tipo_novJpaRepository.save(tipo_nov);
    }

//    @Override
//    public int removeTipo_nov(int id_nov) {
//        tipo_novJpaRepository.delete(id_nov);
//        //To change body of generated methods, choose Tools | Templates.
//        return 0;
//    }

    @Override
    public Tipo_nov updateTipo_nov(Tipo_nov tipo_nov) {
        return tipo_novJpaRepository.save(tipo_nov);
        
      
    }

  
}
