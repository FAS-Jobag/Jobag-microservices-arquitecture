package upc.edu.pe.projectgradle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import upc.edu.pe.projectgradle.entity.ProfessionalProfile;

public interface ProfessionalProfileRepository extends JpaRepository<ProfessionalProfile, Long> {
}
