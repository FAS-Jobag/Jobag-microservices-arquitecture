package pe.edu.upc.joboffersservice.client;

import org.springframework.http.ResponseEntity;
import pe.edu.upc.joboffersservice.entities.Employeer;

public class EmployeerHystrixFallbackFactory implements EmployeerClient{

    @Override
    public ResponseEntity<Employeer> getEmployeer(Long id) {
        Employeer employeer = Employeer.builder()
                .nombres("none")
                .apellidos("none")
                .correo("none")
                .celular("none")
                .contraseña("none")
                .dni("none").build();

        return ResponseEntity.ok(employeer);
    }
}
