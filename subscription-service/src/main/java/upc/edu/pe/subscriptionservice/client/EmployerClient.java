package upc.edu.pe.subscriptionservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import upc.edu.pe.subscriptionservice.models.Employer;

@FeignClient(name = "employers-service")
public interface EmployerClient {
    @GetMapping(value = "/empleadores/id/{id}")
    ResponseEntity<Employer> getEmployer(@PathVariable("id") long id);
}
