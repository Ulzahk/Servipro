
package com.example.demo4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/example2")
public class Example2Controller {
    
    public static final String EXAMPLE2_VIEW = ("example2");
    //Mandar parametros 
    //localhost:8081/example2/request1?nm=John
    //localhost:8081/example2/request1?nm=Mikel
    @GetMapping("/request1")
    public ModelAndView request1(@RequestParam(name="nm",required = false,defaultValue = "NULL")String name){
        ModelAndView MOV = new ModelAndView(EXAMPLE2_VIEW);
        MOV.addObject("nm_in_model",name);
        return MOV;
    }
            
    
}
