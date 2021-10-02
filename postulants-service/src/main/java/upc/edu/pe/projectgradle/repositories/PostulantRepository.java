package upc.edu.pe.projectgradle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import upc.edu.pe.projectgradle.entity.Postulant;

public interface PostulantRepository extends JpaRepository<Postulant, Long>  {
}
