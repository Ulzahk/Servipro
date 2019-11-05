/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servipro.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.servipro.entity.UsuarioEntity;
import com.servipro.model.UsuarioModel;
import com.servipro.repository.UsuarioJpaRepository;
import com.servipro.service.UsuarioService;
import com.servipro.service.impl.UsuarioServiceImpl;
import com.servipro.utilities.EncriptadorContrasena;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.ArrayList;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.view.RedirectView;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;


/**
 *
 * @author practicante
 */
@Controller
@RequestMapping("/usuario")//se indica la ruta a la cual se asocia la clase controladora(especifica una request)
public class UsuarioController {
    /*
    
    @Autowired//se le indica a springboot que busque en sus "Beans" lo que sigue debajo (son todo aquelllo que comienza con @ como unos repositorios raros)
    @Qualifier("usuarioJpaRepository")//este inyecta la dependecnia (bean) (repositorio) "usuarioJpaRepository" que fue especificado en los parentesis para que se pueda usar en este archvio
    private UsuarioJpaRepository userJPARepository; //aca es como una especie de instanciamiento???, esta instruccion es necesaria
    
    */
    
    @Autowired
    @Qualifier("UsuarioServiceImpl")
    private UsuarioServiceImpl UsuarioServiceImpl;//Este Inyecta beans que pueden ser componentes,servicios,repositorios en este caso inyecta el servicioImpl de usuarios
    
    /*@Autowired    
    public UsuarioController(UsuarioJpaRepository userRepository) {//ESTE NO SE INYECTABA ACA SINO QUE DEBIA INYECTARSE EN EL IMPL
        this.userJPARepository = userRepository;
    }*/
    
    @GetMapping("/listar")//forma rapida de hacer una request de tipo get con springboot 
    public ModelAndView ListarUsuarios()
    {
        ModelAndView mav = new ModelAndView("listar");
        /* TEMPORALMENTE INGRESO USUARIO INCIIO*/
        //ArrayList<UsuarioModel> lista= new ArrayList<UsuarioModel>();
        //lista.add(new UsuarioModel(0, "001", "password", 0));
        /* TEMPORALMENTE INGRESO USUARIO FIN*/
        mav.addObject("usuarios", UsuarioServiceImpl.getAll());
        return mav;
    }
    
    //A continuaacion la Forma para pocos datos (variables sencillas y no objetos complejos)sin conexion a la bd por el momento
    
    
    /*@RequestMapping("/registrarse")
    public String DesplegarFormularioRegistro(UsuarioEntity usuario,Model model) {
        model.addAttribute("UsuarioNuevo",usuario);
        return new ModelAndView("registrarse");
    }*/
        
//A continuaacion la Forma para varios datos complejos como objetos (usar el model aca)sin conexion a la bd por el momento
    
    
    @GetMapping("/registrarse")//@Get mapping es la forma abreviada de spring de hacer un request mapping indcando que es de tipo GET
    public ModelAndView DesplegarFormularioRegistro(UsuarioModel usuariox) {
        ModelAndView mav =new ModelAndView("registrarse");
        mav.addObject("usuariox", usuariox);
        return mav;
    }
    
    
    
    @PostMapping("/registrar")//para leer valores en la plantilla es ${} y para asignar valores desde la plantilla hacia el back es *{}
    public ModelAndView registrarUsuario(UsuarioEntity usuariox) {
        
        EncriptadorContrasena encriptador= new EncriptadorContrasena();//revisar posibles problemas de seguridad al ponerlo aca
        usuariox.setContrasena(encriptador.EncriptarContrasena(usuariox.getContrasena()));
        
        ModelAndView mav;
        if (UsuarioServiceImpl.Existe(usuariox.getId().intValue())) {
            mav =new ModelAndView("registrarse");
            mav.addObject("usuariox", usuariox);
            mav.addObject("errorUsuarioExiste","Error el usuario ya existe");
            return mav;
        }
        UsuarioServiceImpl.save(usuariox);
        mav =new ModelAndView("listar");
        mav.addObject("usuarios", UsuarioServiceImpl.getAll());
        return mav;
        //ModelAndView mav =new ModelAndView("listar");
        //mav.addObject("usuario", usuario);
        //return "redirect:/usuarios/listar";
        //modelo.addAttribute("users", userJPARepository.findAll());
        //return "registrarse";
    }
    
    @GetMapping("/editar/{id}")
    public String desplegarFormularioActualizarUsuario(@PathVariable("id") int id, Model model) {
        UsuarioEntity usuario = UsuarioServiceImpl.getById(id);
        if (usuario == null) {
            throw new IllegalArgumentException("Id de empleado invalida:" + id);
        }
        model.addAttribute("usuario", usuario);
        return "editarUsuario";
    }
    
    //@PathVariable("id") long id, @Valid UsuarioEntity user, BindingResult result, Model model
    @PostMapping("/guardar/{id}")
    public String actualizarUsuario(@PathVariable("id") int id,UsuarioEntity usuario, Model model) {
        /*
        if (result.hasErrors()) {
            user.setIdempleado(id);
            return "update-user";
        }*/
        
        UsuarioServiceImpl.save(usuario);
        model.addAttribute("usuarios", UsuarioServiceImpl.getAll());
        return "redirect:/usuario/listar";
    }
    
    /*@GetMapping("/eliminar/{id}")
    public String deleteUser(@PathVariable("id") int id, Model model) {
        //UsuarioEntity user = userJPARepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        //userJPARepository.delete(user);
        //model.addAttribute("users", userJPARepository.findAll());
        return "redirect:/usuarios/listar";
    }*/
    
    /* POSIBLEMENTE EL METODO LOGIN DE ABAJO ES PARA DESECHAR*/
    
    /*@GetMapping("/login")
    public String login(UsuarioModel usuarioLog,Model model)
    {
        model.addAttribute("usuarioLog", usuarioLog);
        return "login";
    }*/
    
    
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
        if (/*UsuarioServiceImpl.Existe(Integer.parseInt(username))*/username.equals("hola") && password.equals("hola")) {
            /*mav =new ModelAndView("registrarse");
            mav.addObject("usuarioLog", usuarioLog);
            mav.addObject("errorUsuarioExiste","Error el usuario ya existe");
            return mav;*/
            String token = getJWTToken(username);
            UsuarioModel user = new UsuarioModel();
            user.setIdusuario(username);
            user.setToken(token);
            mav =new ModelAndView("redirect:/usuario/listar");
            return mav;
        }        
        mav =new ModelAndView("redirect:/login?error=true");        
        return mav;
    }
    
    
    
    
    
    
}
