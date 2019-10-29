/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.servipro.service.impl;


import main.java.com.servipro.entity.TipoNovedadEntity;
import main.java.com.servipro.commons.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import main.java.com.servipro.dao.api.TipoNovedadDaoApi;
import main.java.com.servipro.service.api.TipoNovedadServiceApi;

/**
 *
 * @author PRACTICANTE
 */
@Service
public class TipoNovedadServiceImpl extends GenericServiceImpl<TipoNovedadEntity, Integer> implements TipoNovedadServiceApi {

    @Autowired
    private TipoNovedadDaoApi tipo_novDaoApi;

    @Override
    public CrudRepository<TipoNovedadEntity, Integer> getDao() {
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
