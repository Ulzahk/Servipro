package com.servipro;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@SpringBootApplication(scanBasePackages={"com.servipro.repository","com.servipro.model"})
//@ComponentScan({"com.servipro.repository","com.servipro.model","com.servipro.controller","com.servipro.repository"})
//@ComponentScan({"com.servipro", "com.servipro.model"})
@SpringBootApplication
@EnableAutoConfiguration

public class ServiproApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiproApplication.class, args);
	}

}
