/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servipro.utilities;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


/**
 *
 * @author PRACTICANTE
 */
public class EncriptadorContrasena {
    
    
    public String EncriptarContrasena(String contrasena) {
        BCryptPasswordEncoder encriptador = new BCryptPasswordEncoder(4);        
	return encriptador.encode(contrasena);
    }
    
    /*public static void main(String ...args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(8);
        //El String que mandamos al metodo encode es el password que queremos encriptar.
	System.out.println(bCryptPasswordEncoder.encode("12345678"));
    }*/
    
    
    
}
