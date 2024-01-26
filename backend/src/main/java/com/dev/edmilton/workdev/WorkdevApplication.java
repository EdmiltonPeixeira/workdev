package com.dev.edmilton.workdev;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Workdev",
				version = "1.0.0",
				description = "Projeto de gerenciamento de workshops",
				contact = @Contact(
						name = "Edmilton Ribeiro Peixeira | Desenvolvedor",
						email = "edm.ufpasi@gmail.com"
				)
		)
)
public class WorkdevApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkdevApplication.class, args);
	}

}
