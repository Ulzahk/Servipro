/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servipro.controller;

/**
 *
 * @author PRACTICANTE
 * 
 */
import com.servipro.model.UsuarioModel;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {
    
    @GetMapping({"/","/login"})
	public String index() {
		return "index";
	}
	
	@GetMapping("/menu")
	public String menu() {
		return "menu";
	}
	
	@GetMapping("/user")
	public String user() {
		return "user";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}
        
        
       private String getJWTToken(String username) {
		String secretKey = "a1D2&3A5%639f8loC0944G98@#zxDy102";
		List<GrantedAuthority> grantedAuthorities  = AuthorityUtils
				.commaSeparatedStringToAuthorityList("USER,ADMIN");
		
		String token = Jwts
				.builder()
				.setId("ServiProJWT")
				.setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		return "Bearer " + token;
	}
    
    
    
    @PostMapping("/login")
    public ModelAndView ingresar(String username,String password)
    {       
        
        ModelAndView mav;
        if (/*UsuarioServiceImpl.Existe(Integer.parseInt(username))*//*username.equals("hola") && password.equals("hola")*/true) {
            /*mav =new ModelAndView("registrarse");
            mav.addObject("usuarioLog", usuarioLog);
            mav.addObject("errorUsuarioExiste","Error el usuario ya existe");
            return mav;*/
            String token = getJWTToken(username);
            UsuarioModel user = new UsuarioModel();
            user.setIdusuario(username);
            user.setToken(token);
            mav =new ModelAndView("redirect:/usuario/listarex");
            return mav;
        }        
        mav =new ModelAndView("redirect:/login?error=true");        
        return mav;
    }
    
}
