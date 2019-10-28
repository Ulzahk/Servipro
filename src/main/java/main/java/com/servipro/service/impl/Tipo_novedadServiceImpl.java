/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.servipro.service.impl;


import main.java.com.servipro.entity.Tipo_novedad;
import main.java.com.servipro.commons.GenericServiceImpl;
import main.java.com.servipro.dao.api.Tipo_novedadDaoApi;
import main.java.com.servipro.service.api.Tipo_novedadServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author PRACTICANTE
 */
@Service
public class Tipo_novedadServiceImpl extends GenericServiceImpl<Tipo_novedad, Integer> implements Tipo_novedadServiceApi {

    @Autowired
    private Tipo_novedadDaoApi tipo_novDaoApi;

    @Override
    public CrudRepository<Tipo_novedad, Integer> getDao() {
        return tipo_novDaoApi;

    }
}

//@Service("tipo_novServiceImpl")
//public abstract class Tipo_novServiceImpl implements Tipo_novService {
//        
////    private static Log LOG = LogFactory.getLog(Tipo_novServiceImpl.class);
//
//    @Autowired
//    @Qualifier("tipo_novJpaRepository")
//    private Tipo_novJpaRepository tipo_novJpaRepository;
//
//    @Override
//    public List<Tipo_nov> listAllTipo_nov() {
////        LOG.info("Call: " + "listAllTipo_nov()");
//        return tipo_novJpaRepository.findAll();
//    }
//
//    @Override
//    public Tipo_nov addTipo_nov(Tipo_nov tipo_nov) {
////        LOG.info("Call: " + "addTipo_nov()");
//        return tipo_novJpaRepository.save(tipo_nov);
//    }
//
////    @Override
////    public int removeTipo_nov(int id_nov) {
////        tipo_novJpaRepository.delete(id_nov);
////        //To change body of generated methods, choose Tools | Templates.
////        return 0;
////    }
//
//    @Override
//    public Tipo_nov updateTipo_nov(Tipo_nov tipo_nov) {
//        return tipo_novJpaRepository.save(tipo_nov);
//        
//      
//    }
//
//  
//}
