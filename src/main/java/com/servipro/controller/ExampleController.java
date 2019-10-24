
package com.servipro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/example")
public class ExampleController {
    
    public static final String EXAMPLE_VIEW = "example";
    @Autowired
    @Qualifier("exampleComponent")
    
    
    //PRIERMA FORMA
    @GetMapping("/exampleString")
    public String exampleString (Model model){
        model.addAttribute("name","John");
        return EXAMPLE_VIEW;
    }
    
    //SEGUNDA FORMA
    @GetMapping("/exampleMAV")
    public ModelAndView exampleMAV(){
        ModelAndView MOV = new ModelAndView("example");
        MOV.addObject("name","Mikel");
        return MOV;
    }
    

}
