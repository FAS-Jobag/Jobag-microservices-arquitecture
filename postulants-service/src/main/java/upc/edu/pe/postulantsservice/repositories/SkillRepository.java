package upc.edu.pe.postulantsservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import upc.edu.pe.postulantsservice.entity.Skill;

public interface SkillRepository extends JpaRepository<Skill, Long> {
}
