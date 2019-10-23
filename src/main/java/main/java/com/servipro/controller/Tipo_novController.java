/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.servipro.controller;

import main.java.com.servipro.entity.Tipo_nov;
import main.java.com.servipro.repository.Tipo_novJpaRepository;
import main.java.com.servipro.service.Tipo_novService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author PRACTICANTE
 */
@Controller
@RequestMapping("/tipo_nov")
public class Tipo_novController {

    private static final String TIPO_NOV_VIEW = "tipo_nov";

//    private final Tipo_novJpaRepository tipo_novJpaRepository;

//    private static Log LOG = LogFactory.getLog(Tipo_novController.class);
    
//    public Tipo_novController(Tipo_novJpaRepository tipo_novJpaRepository) {
//        this.tipo_novJpaRepository = tipo_novJpaRepository;
//    }
    @Autowired
    @Qualifier("tipo_novServiceImpl")
    private Tipo_novService tipo_novService;
    
    
    
    @GetMapping("/listtipo_nov")
    public ModelAndView listAllTipo_nov() {
//        LOG.info("Call: " + "listAllTipo_nov()");
        ModelAndView mav = new ModelAndView(TIPO_NOV_VIEW);
        mav.addObject("tipo_nov", tipo_novService.listAllTipo_nov());
        return mav;
    }

    @PostMapping("/addtipo_nov")
    public String addTipo_nov(@ModelAttribute("tipo_nov") Tipo_nov tipo_nov) {
//        LOG.info("Call: " + "addTipo_nov()" + "-- PARAM: " + tipo_nov.toString());
        tipo_novService.addTipo_nov(tipo_nov);
        return "redirect:/tipo_nov/listtipo_nov";

    }

}

