/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo4.controller;

import com.example.demo4.component.RolesComponent;
import java.util.ArrayList;
import java.util.List;
import model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author PRACTICANTE
 */
@Controller
@RequestMapping("/roles")
public class RolesController {

    public static final String ROLES_VIEW = "roles"; // se establece una variable fija en caso de que se tengan que hacer cambios en todo el código


//Primera forma = para cuando sólo son redirecciones 
    @GetMapping("/rolesString")
    public String rolesString(Model model) {
     
        model.addAttribute("people", getPeople());
        return ROLES_VIEW;
    }

//Segunda forma = para cuando hay que insertar datos
    @GetMapping("/rolesMAV")
    public ModelAndView rolesMAV() {
        ModelAndView mav = new ModelAndView(ROLES_VIEW);
        mav.addObject("people", getPeople());
        return mav;
    }

    private List<Person> getPeople() {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Jon", 23));
        people.add(new Person("Max", 30));
        people.add(new Person("Laura", 23));
        people.add(new Person("Clara", 23));
        return people;
    }

    @GetMapping("/roles")
    public String roles() {
        return "roles";
    }
}

//@Controller
//public class RolesController {
//    
//    @RequestMapping("/url")
//    public String page(Model model) {
//        model.addAttribute("attribute", "value");
//        return "view.name";
//    }
//    
//}
