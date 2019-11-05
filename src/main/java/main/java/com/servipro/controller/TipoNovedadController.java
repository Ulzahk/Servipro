/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.servipro.controller;

import main.java.com.servipro.entity.TipoNovedadEntity;
import main.java.com.servipro.model.TipoNovedadModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import main.java.com.servipro.service.api.TipoNovedadServiceApi;


@Controller
public class TipoNovedadController {

    @Autowired
    private TipoNovedadServiceApi tipoNovedadServiceApi;

    @RequestMapping("/tiponov")
    public String index(Model model) {
        model.addAttribute("list", tipoNovedadServiceApi.getAll());
        return "indexTipoNovedad";
    }

    @GetMapping("/savetiponov/{id}")
    public String showSave(@PathVariable("id") Integer id, Model model) {
        if (id != null && id != 0) {
            model.addAttribute("tipo_nov", tipoNovedadServiceApi.get(id));
            model.addAttribute("id_tipo_novx",null);
    }else{
            model.addAttribute("tipo_nov", new TipoNovedadModel());
            
        }
        return "saveTipoNovedad";
    }
////    
    @PostMapping("/savetiponov")
    public String save(TipoNovedadEntity tipo_novedad, Model model) {
    tipoNovedadServiceApi.save(tipo_novedad);
    return "indexTipoNovedad"; 
    }
//    
    @GetMapping("/deletetiponov/{id}")
    public String delete(@PathVariable Integer id, Model model){
    tipoNovedadServiceApi.delete(id);
    return "indexTipoNovedad";
    }
    
    


}
