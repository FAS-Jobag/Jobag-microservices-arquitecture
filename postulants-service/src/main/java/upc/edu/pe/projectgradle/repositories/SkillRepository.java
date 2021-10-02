package upc.edu.pe.projectgradle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import upc.edu.pe.projectgradle.entity.Skill;

public interface SkillRepository extends JpaRepository<Skill, Long> {
}
