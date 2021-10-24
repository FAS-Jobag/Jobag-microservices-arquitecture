package upc.edu.pe.postulantsservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import upc.edu.pe.postulantsservice.entity.Studie;

public interface StudieRepository extends JpaRepository<Studie, Long> {
}
