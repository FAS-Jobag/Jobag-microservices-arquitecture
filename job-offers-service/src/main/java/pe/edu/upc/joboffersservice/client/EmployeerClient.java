package pe.edu.upc.joboffersservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pe.edu.upc.joboffersservice.entities.Employeer;

@FeignClient(name="employers-service", fallback = EmployeerHystrixFallbackFactory.class)
public interface EmployeerClient {
    @GetMapping(value = "/empleadores/id/{id}")
    public ResponseEntity<Employeer> getEmployeer(@PathVariable("id") Long id);
}
