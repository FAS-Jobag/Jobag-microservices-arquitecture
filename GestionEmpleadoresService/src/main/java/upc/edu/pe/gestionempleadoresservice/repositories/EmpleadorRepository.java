package upc.edu.pe.gestionempleadoresservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import upc.edu.pe.gestionempleadoresservice.entities.Empleador;

import java.util.Optional;

@Repository
public interface EmpleadorRepository extends JpaRepository<Empleador, Long>{
    Optional<Empleador> findByDNI (Long aLong);
    Boolean existsByDNI(Long DNI);
    Boolean existsByCorreo(String correo);
    Boolean existsByCelular(Long celular);
    Empleador findByCorreoAndContraseña(String correo, String contraseña);

}
