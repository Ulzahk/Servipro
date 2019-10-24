package com.servipro.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//@SpringBootApplication(scanBasePackages={"com.example.demo4.repository"})

@SpringBootApplication(scanBasePackages={"main.java.com.servipro.repository"})
@EnableAutoConfiguration 
public class ServiproApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiproApplication.class, args);
	}

}
