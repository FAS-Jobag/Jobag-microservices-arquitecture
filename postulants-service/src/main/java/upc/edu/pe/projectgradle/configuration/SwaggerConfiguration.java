package upc.edu.pe.projectgradle.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

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
					.title("Postulant Microservice")
					.description("Microservicio de Gestión de Postulantes"));
	}


}
