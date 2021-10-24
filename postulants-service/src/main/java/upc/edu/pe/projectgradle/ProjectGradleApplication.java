package upc.edu.pe.projectgradle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProjectGradleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectGradleApplication.class, args);
	}
}
