
package com.example.demo4.controller;

import com.example.demo4.entity.CentroDeCostosEntity;
import com.example.demo4.model.CentroDeCostosModel;
import com.example.demo4.services.api.CentroDeCostosServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CentroDeCostosController {
    
    @Autowired
    private CentroDeCostosServiceAPI centroDeCostosServiceAPI;
    
    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("list", centroDeCostosServiceAPI.getAll());
        return "index";
    }
    
    @GetMapping("/save/{id}")
    public String showSave(@PathVariable("id")Long id,Model model){
        if(id != null && id !=0){
            model.addAttribute("CentroDeCostosx", centroDeCostosServiceAPI.get(id));
            model.addAttribute("IdDelCentroDeCostosx",null);
        }else{
            model.addAttribute("CentroDeCostosx", new CentroDeCostosModel());
            model.addAttribute("IdDelCentroDeCostosx",centroDeCostosServiceAPI.getAll().size()+1);
        }
        return "save";
    }
    
    @PostMapping("/save")
    public String save(CentroDeCostosEntity centroDeCostosx, Model model){        
        centroDeCostosServiceAPI.save(centroDeCostosx);
        return "redirect:/";
    }
    
    /*@GetMapping("/Crear")
    public String save(CentroDeCostosEntity centroDeCostosx, Model model){        
        centroDeCostosServiceAPI.save(centroDeCostosx);
        return "save";
    }*/
    
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id,Model model){
        centroDeCostosServiceAPI.delete(id);
        
        return "redirect:/";
    }
}
