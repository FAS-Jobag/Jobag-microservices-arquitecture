package upc.edu.pe.subscriptionservice.client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import upc.edu.pe.subscriptionservice.models.Postulant;

@FeignClient(name = "postulants-service")
public interface PostulantClient {
    @GetMapping(value = "/postulants/{id}")
    ResponseEntity<Postulant> getPostulant(@PathVariable("id") long id);
}
