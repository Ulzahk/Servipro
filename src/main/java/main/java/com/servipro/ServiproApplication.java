package main.java.com.servipro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//@SpringBootApplication(scanBasePackages={"main.java.com.servipro.repository"})
@SpringBootApplication
@EnableAutoConfiguration 
public class ServiproApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiproApplication.class, args);
	}

}
