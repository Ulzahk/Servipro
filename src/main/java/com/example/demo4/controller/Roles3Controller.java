/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo4.controller;

import com.mysql.cj.log.Log;
import model.Person;
import org.apache.juli.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author PRACTICANTE
 */
@Controller
@RequestMapping("/roles3")
public class Roles3Controller {

    public static final String FORM_VIEW = "form";
    public static final String RESULT_VIEW = "result";
    

//    // 1
//    @GetMapping("/")
//    public RedirectView redirect(){
//       return new RedirectView ("/roles3/showform");
//  }
//    // 2
//    @GetMapping("/")
//    public String redirect(){
//        return "redirect:/roles3/showform";
//    }
    
    
    //3 este si sirve
    @GetMapping("/")
    public ModelAndView redirect(ModelMap model) {
        model.addAttribute("attribute", "/");
        return new ModelAndView("redirect:/roles3/showform", model);
    }

    @GetMapping("/showform")
    public String showform(Model model) {        
        model.addAttribute("person", new Person());
        return FORM_VIEW;
    }

    @PostMapping("/addperson")
    public ModelAndView addperson(@ModelAttribute("person") Person person) {
        ModelAndView mav = new ModelAndView(RESULT_VIEW);
        mav.addObject("person", person);
        return mav;

    }

}
