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
import com.servipro.entity.Usuario;
import com.servipro.entity.Usuario;
import com.servipro.repository.UsuarioCRUDRepository;
import com.servipro.repository.UsuarioCRUDRepository;

/**
 *
 * @author practicante
 */
@Controller
public class UserController {
        private final UsuarioCRUDRepository userRepository;

    @Autowired
    public UserController(UsuarioCRUDRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @GetMapping("/signup")
    public String showSignUpForm(Usuario user) {
        return "add-user";
    }
    
    @PostMapping("/adduser")
    public String addUser(@Valid Usuario user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-user";
        }
        
        userRepository.save(user);
        model.addAttribute("users", userRepository.findAll());
        return "index";
    }
    
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Usuario user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        model.addAttribute("user", user);
        return "update-user";
    }
    
    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, @Valid Usuario user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            user.setIdempleado(id);
            return "update-user";
        }
        
        userRepository.save(user);
        model.addAttribute("users", userRepository.findAll());
        return "index";
    }
    
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        Usuario user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        userRepository.delete(user);
        model.addAttribute("users", userRepository.findAll());
        return "index";
    }
}
