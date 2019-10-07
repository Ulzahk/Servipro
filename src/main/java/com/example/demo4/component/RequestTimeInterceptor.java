/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo4.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/**
 *
 * @author PRACTICANTE
 */

@Component("requestTimeInterceptor")

public class RequestTimeInterceptor extends HandlerInterceptorAdapter {
 
    private static final Log LOG = LogFactory.getLog(RequestTimeInterceptor.class);
        
    //PRIMERO
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception{
        request.setAttribute("startTime", System.currentTimeMillis());
        return true;
    }
    
    //SEGUNDO
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception{
       long startTime = (long) request.getAttribute("startTime");
       LOG.info("--REQUEST URL: '" + request.getRequestURL().toString() + "' -- TOTAL TIME: '" + (System.currentTimeMillis() - startTime)+ "'ms'" );
    }
    
   
}
