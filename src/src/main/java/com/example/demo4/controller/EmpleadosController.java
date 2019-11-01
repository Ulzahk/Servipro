/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo4.controller;

import com.example.demo4.entity.EmpleadosEntity;
import com.example.demo4.model.EmpleadosModel;
import com.example.demo4.services.api.EmpleadosServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmpleadosController {
    
    @Autowired
    private EmpleadosServiceAPI empleadosServiceAPI;
    
    @RequestMapping("/empleados")
    public String Empleados (Model model){
        model.addAttribute("list", empleadosServiceAPI.getAll());
        return "Empleados";
    }
    
    @GetMapping("/GuardarEmpleados/{id_empleado}")
    public String showFormEmpleados(@PathVariable("id_empleado")Integer id,Model model){
        if(id != null && id != 0){
            model.addAttribute("IdEmpleado", empleadosServiceAPI.get(id));
            model.addAttribute("IdDelEmpleado", null);
        }else{
            model.addAttribute("IdEmpleado", new EmpleadosModel());
            
        }
        return "GuardarEmpleados";
    }
    
    @PostMapping("/GuardarEmpleados")
    public String guardar(EmpleadosEntity IdEmpleado,Model model){
        
        empleadosServiceAPI.save(IdEmpleado);
        return "redirect:/empleados";
    }
    
    
    
    
}
