package upc.edu.pe.projectgradle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import upc.edu.pe.projectgradle.entity.Persona;

/**
* PersonaRepository
*/
@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
}
