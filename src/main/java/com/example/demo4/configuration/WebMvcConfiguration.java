/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo4.configuration;

import com.example.demo4.component.RequestTimeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *
 * @author PRACTICANTE
 */

@Configuration
public class WebMvcConfiguration extends WebMvcConfigurerAdapter{

    @Autowired
    @Qualifier("requestTimeInterceptor")
    private RequestTimeInterceptor requestTimeInterceptor;
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(requestTimeInterceptor);    
    }
    
    
}
