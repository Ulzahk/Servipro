package com.example.demo4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages={
"com.example.demo4", "com.example.demo4.controller"})

@ComponentScan({"org.springframework.ui.Model"})//Para agregar el bean de ui model para resolver el problema de com.example.demo4.controller.ExampleController

@EnableAutoConfiguration 
public class Demo3Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo3Application.class, args);
	}

}
