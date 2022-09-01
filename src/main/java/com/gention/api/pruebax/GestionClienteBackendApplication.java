package com.gention.api.pruebax;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
//@ComponentScan(basePackageClasses=ClienteController.class)
public class GestionClienteBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionClienteBackendApplication.class, args);
	}

}
