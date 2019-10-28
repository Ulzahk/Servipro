/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servipro.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.servipro.entity.UsuarioEntity;
import com.servipro.model.UsuarioModel;
import com.servipro.repository.UsuarioJpaRepository;
import com.servipro.service.UsuarioService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.ModelAttribute;


/**
 *
 * @author practicante
 */
@Controller
@RequestMapping("/usuario")//se indica la ruta a la cual se asocia la clase controladora(especifica una request)
public class UsuarioController {
    @Autowired//se le indica a springboot que busque en sus "Beans" lo que sigue debajo (son todo aquelllo que comienza con @ como unos repositorios raros)
    @Qualifier("usuarioJpaRepository")//este inyecta la dependecnia (bean) (repositorio) "usuarioJpaRepository" que fue especificado en los parentesis para que se pueda usar en este archvio
    private UsuarioJpaRepository userJPARepository;//aca es como una especie de instanciamiento???, esta instruccion es necesaria
    
    @Autowired
    @Qualifier("UsuarioServiceImpl")
    private UsuarioService usuarioService;//Este es el servicio el cual usa la interfaz UsuarioService junto con un ainyeccion de dependencias de UsuarioServiceImpl
    /*@Autowired    
    public UsuarioController(UsuarioJpaRepository userRepository) {
        this.userJPARepository = userRepository;
    }*/
    
    @GetMapping("/listar")//forma rapida de hacer una request de tipo get con springboot 
    public ModelAndView ListarUsuarios()
    {
        ModelAndView mav = new ModelAndView("listar");
        /* TEMPORALMENTE INGRESO USUARIO INCIIO*/
        ArrayList<UsuarioModel> lista= new ArrayList<UsuarioModel>();
        lista.add(new UsuarioModel(0, "001", "password", 0));
        /* TEMPORALMENTE INGRESO USUARIO FIN*/
        mav.addObject("usuarios", lista);
        return mav;
    }
    
    //A continuaacion la Forma para pocos datos (variables sencillas y no objetos complejos)sin conexion a la bd
    
    
    /*@RequestMapping("/registrarse")
    public String DesplegarFormularioRegistro(UsuarioEntity usuario,Model model) {
        model.addAttribute("UsuarioNuevo",usuario);
        return new ModelAndView("registrarse");
    }*/
        
//A continuaacion la Forma para varios datos complejos como objetos (usar el model aca)sin conexion a la bd
    
    
    @GetMapping("/registrarse")//@Get mapping es la forma abreviada de spring de hacer un request mapping indcando que es de tipo GET
    public ModelAndView DesplegarFormularioRegistro(UsuarioModel usuario) {
        ModelAndView mav =new ModelAndView("registrarse");
        mav.addObject("usuario", usuario);
        return mav;
    }
    
    
    
    @PostMapping("/registrar")
    public ModelAndView registrarUsuario(@ModelAttribute("usuario")UsuarioEntity usuario) {        
        usuarioService.addUsuario(usuario);
        ModelAndView mav =new ModelAndView("listar");
        //mav.addObject("usuario", usuario);
        return mav;
        //modelo.addAttribute("users", userJPARepository.findAll());
        //return "registrarse";
    }
    
    @GetMapping("/editar/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        UsuarioEntity user = userJPARepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        model.addAttribute("user", user);
        return "update-user";
    }
    
    //@PathVariable("id") long id, @Valid UsuarioEntity user, BindingResult result, Model model
    @PostMapping("/guardar/{id}")
    public void updateUser() {/*
        if (result.hasErrors()) {
            user.setIdempleado(id);
            return "update-user";
        }
        
        userJPARepository.save(user);
        model.addAttribute("users", userJPARepository.findAll());
        return "index";*/
    }
    
    @GetMapping("/borrar/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        UsuarioEntity user = userJPARepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        userJPARepository.delete(user);
        model.addAttribute("users", userJPARepository.findAll());
        return "index";
    }
}
