/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.servipro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author PRACTICANTE
 */
@Controller
@RequestMapping("/algo")
public class HelloWorldController {
    
    @GetMapping("/helloworld")
    public String helloworld() {
        return "helloworld";
    }
    
}
