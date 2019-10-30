/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.servipro.controller;

import main.java.com.servipro.entity.TipoNovedadEntity;
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

//    @Autowired
//    private TipoNovedadServiceApi tipoNovedadServiceApi;
//
//    @RequestMapping("/tiponov")
//    public String index(Model model) {
//        model.addAttribute("list", tipoNovedadServiceApi.getAll());
//        model.addAttribute("IdDelCentroDeCostosx",null);
//        return "indexTipoNovedad";
//    }
////
//    @GetMapping("/save/{id}")
//    public String showSave(@PathVariable("id") Integer id, Model model) {
//        if (id != null && id != 0) {
//            model.addAttribute("tipo_novedad", tipoNovedadServiceApi.get(id));
//        }
//        return "save";
//    }
////    
//    @PostMapping("/save")
//    public String save(TipoNovedadEntity tipo_novedad, Model model) {
//    tipo_novedadServiceApi.save(tipo_novedad);
//    return "redirect:/"; //redirige al index
//    }
//    
//    @GetMapping("/delete/{id}")
//    public String delete(@PathVariable Integer id, Model model){
//    tipo_novedadServiceApi.delete(id);
//    return "redirect:/";
//    }
//    
    


}
