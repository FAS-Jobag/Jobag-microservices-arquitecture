package upc.edu.pe.gestionempleadoresservice.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import upc.edu.pe.gestionempleadoresservice.entities.Empleadores;

import java.util.Optional;

/**
* SwaggerConfiguration
*/
@Configuration
public class SwaggerConfiguration {
	@Bean(name = "projectgradleOpenApi")
	public OpenAPI projectgradleOpenApi(){
		return new OpenAPI()
			.components(new Components())
			.info(new Info()
					.title("Project gradble with swagger")
					.description("Microservice Gestion de Empleadores Service"));
	}
}
