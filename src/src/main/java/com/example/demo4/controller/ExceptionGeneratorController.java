/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionGeneratorController {
    @RequestMapping("/anotherService")
    public String generator() throws Exception{
        throw new Exception("exception");
    
    }
}
