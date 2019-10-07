/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author PRACTICANTE
 */
@ControllerAdvice
public class ErrorController {
    
    public static final String ISE_VIEW = "error/500";
    
    @ExceptionHandler(Exception.class)
    public String showInternalServerError() {    
        return ISE_VIEW;
    }
    
}
