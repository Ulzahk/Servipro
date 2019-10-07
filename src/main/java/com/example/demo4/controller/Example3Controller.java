package com.example.demo4.controller;

import model.Person;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/example3")

public class Example3Controller {
    
    private static final Log LOGGER = LogFactory.getLog(Example3Controller.class);
    
    public static final String FORM_VIEW = "form";
    public static final String RESULT_VIEW = "result";

    
    @GetMapping("/ShowForm")
    public String ShowForm(Model model){
        LOGGER.info("INFO TRACE");
        LOGGER.warn("WARNING TRACE");
        LOGGER.error("ERROR TRACE");
        LOGGER.debug("DEBUG TRACE");
        model.addAttribute("person", new Person());
        //ESTA OPERACION CREA UN ERROR 500 = INTERNAL SERVER ERROR.
        //int i = 6/0;
        return FORM_VIEW;
    }
    //Redireccionar 
    //localhost:8081/example3/
    @GetMapping("/")
    public String redirect(){
        return "redirect:/example3/ShowForm";
    }
    
    
    @PostMapping("/addperson")
    public ModelAndView addPerson(@ModelAttribute("person") Person person){
     LOGGER.info("METHOD: 'addperson' -- PARAMS: '" + person + "'");
     ModelAndView MOV = new ModelAndView(RESULT_VIEW);
     MOV.addObject("person", person);
     LOGGER.info("TEMPLATE: '" + RESULT_VIEW + "' -- DATA: '" + person + "'");
     return MOV;
    } 
    
}
