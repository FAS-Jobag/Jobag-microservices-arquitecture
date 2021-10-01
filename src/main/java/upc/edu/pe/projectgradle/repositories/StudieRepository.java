package upc.edu.pe.projectgradle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import upc.edu.pe.projectgradle.entity.Studie;

public interface StudieRepository extends JpaRepository<Studie, Long> {
}
