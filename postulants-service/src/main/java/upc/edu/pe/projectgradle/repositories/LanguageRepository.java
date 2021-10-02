package upc.edu.pe.projectgradle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import upc.edu.pe.projectgradle.entity.Language;

public interface LanguageRepository extends JpaRepository<Language, Long> {
}
