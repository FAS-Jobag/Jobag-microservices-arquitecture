package upc.edu.pe.postulantsservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import upc.edu.pe.postulantsservice.entity.Language;

public interface LanguageRepository extends JpaRepository<Language, Long> {
}
