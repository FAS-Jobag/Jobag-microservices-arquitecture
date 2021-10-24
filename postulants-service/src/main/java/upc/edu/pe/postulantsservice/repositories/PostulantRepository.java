package upc.edu.pe.postulantsservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import upc.edu.pe.postulantsservice.entity.Postulant;

public interface PostulantRepository extends JpaRepository<Postulant, Long>  {
}
