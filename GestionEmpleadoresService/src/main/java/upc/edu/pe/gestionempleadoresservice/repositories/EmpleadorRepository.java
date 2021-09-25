package upc.edu.pe.gestionempleadoresservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import upc.edu.pe.gestionempleadoresservice.entities.Empleadores;

import java.util.Optional;

@Repository
public interface EmpleadorRepository extends JpaRepository<Empleadores, Long> {
    Optional<Empleadores> findByDNI (Long aLong);
}
