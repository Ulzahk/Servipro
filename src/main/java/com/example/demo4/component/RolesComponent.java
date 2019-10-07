/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo4.component;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

/**
 *
 * @author PRACTICANTE
 */
@Component("rolesComponent")
public class RolesComponent {
    
    private static final Log LOG = LogFactory.getLog(RolesComponent.class);
    
    public void sayHello(){
        LOG.info("HELLO FROM EXAMPLE COMPONENT");
        
    }
            
    
}
