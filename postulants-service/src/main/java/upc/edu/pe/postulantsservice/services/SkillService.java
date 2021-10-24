package upc.edu.pe.postulantsservice.services;

import upc.edu.pe.postulantsservice.entity.Skill;

public interface SkillService extends CrudServices<Skill, Long>{
    Skill saveSkillByProfessionalProfileId(Long id, Skill skill) throws Exception;
}
