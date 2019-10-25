/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servipro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.servipro.service.usuariosservice;


/**
 *
 * @author PRACTICANTE
 */
@Controller
@RequestMapping("/inicio")
public class inicioController {
//    int x=1;
//    String user1= "admin";
//    String password1="admin";
    
//        @GetMapping("/string")
//    public String showSignUp() {
//        return "inicio";
//    }
    
    
//    @Autowired 
//        @Qualifier ("usuariosServiceImp")
//    private usuariosservice usuariosservice;
    
    
    
    @GetMapping("/model")
    public ModelAndView inicio(){
        ModelAndView mod= new ModelAndView("inicio");
//        mod.addObject("nombre", usuariosservice);
        return  mod;
        
    }
  
}
