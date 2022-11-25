package com.example.cliente_paises.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"controller","service","config"})
public class ClientePaisesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientePaisesApplication.class, args);
	}

}
