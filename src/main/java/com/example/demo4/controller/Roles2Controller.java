/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author PRACTICANTE
 */
@Controller
@RequestMapping("/roles2")

public class Roles2Controller {
    
    private static final String ROLES2_VIEW = "roles2";
      
    //localhost:80/roles2/request1?nm=JON
    //localhost:80/roles2/request1?nm=MAX
    @GetMapping("/request1")
    public ModelAndView request1(@RequestParam(name="nm", required=false, defaultValue="NULL") String name){
        ModelAndView mav = new ModelAndView(ROLES2_VIEW);
        mav.addObject("nm_in_model", name);
        return mav;
    }
    
    //localhost:80/roles2/request2/JON
    //localhost:80/roles2/request2/MAX
    
    @GetMapping("/request2/{nm}")
    public ModelAndView request2(@PathVariable("nm") String name){
        ModelAndView mav = new ModelAndView(ROLES2_VIEW);
        mav.addObject("nm_in_model", name);
        return mav;
    }
    
}
