package com.jobag.postulationsservice.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
* SwaggerConfiguration
*/
@Configuration
public class SwaggerConfiguration {
	@Bean(name = "postulantionsServiceOpenApi")
	public OpenAPI postulantionsServiceOpenApi(){
		return new OpenAPI()
			.components(new Components())
			.info(new Info()
					.title("Postulantion Microservice")
					.description("Microservicio de la creación y gestión de Postulanciones"));
	}


}
