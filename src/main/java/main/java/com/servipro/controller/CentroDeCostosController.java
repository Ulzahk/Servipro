
package main.java.com.servipro.controller;

import main.java.com.servipro.entity.CentroDeCostosEntity;
import main.java.com.servipro.model.CentroDeCostosModel;
import main.java.com.servipro.service.api.CentroDeCostosServiceApi;
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
    private CentroDeCostosServiceApi centroDeCostosServiceApi;
    
    @RequestMapping("/centrocostos")
    public String index(Model model){
        model.addAttribute("list", centroDeCostosServiceApi.getAll());
        return "indexCentroDeCostos";
    }
    
    @GetMapping("/save/{id}")
    public String showSave(@PathVariable("id")Long id,Model model){
        if(id != null && id !=0){
            model.addAttribute("CentroDeCostosx", centroDeCostosServiceApi.get(id));
            model.addAttribute("IdDelCentroDeCostosx",null);
        }else{
            model.addAttribute("CentroDeCostosx", new CentroDeCostosModel());
            model.addAttribute("IdDelCentroDeCostosx",centroDeCostosServiceApi.getAll().size()+1);
        }
        return "save";
    }
    
    @PostMapping("/save")
    public String save(CentroDeCostosEntity centroDeCostosx, Model model){        
        centroDeCostosServiceApi.save(centroDeCostosx);
        return "redirect:/";
    }
    
    /*@GetMapping("/Crear")
    public String save(CentroDeCostosEntity centroDeCostosx, Model model){        
        centroDeCostosServiceAPI.save(centroDeCostosx);
        return "save";
    }*/
    
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id,Model model){
        centroDeCostosServiceApi.delete(id);
        
        return "redirect:/";
    }
}
