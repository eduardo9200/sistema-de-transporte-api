package br.edu.ifce.sistematransporteapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("br.edu.ifce.sistematransporteapi")
public class SistematransporteApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistematransporteApiApplication.class, args);
	}

}
