package upc.edu.pe.projectgradle.services;

import upc.edu.pe.projectgradle.entity.Language;
import upc.edu.pe.projectgradle.entity.Skill;

public interface SkillService extends CrudServices<Skill, Long>{
    Skill saveSkillByProfessionalProfileId(Long id, Skill skill) throws Exception;
}
