package upc.edu.pe.gestionempleadoresservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import upc.edu.pe.gestionempleadoresservice.entities.Compania;

import java.util.Optional;

@Repository
public interface CompaniaRepository extends JpaRepository<Compania, Long> {
    Optional<Compania> findByRuc (Long ruc);
    Optional<Compania> findByPais (String pais);
    Optional<Compania> findByCiudad (String ciudad);
    Optional<Compania> findByDistrito (String distrito);
}
