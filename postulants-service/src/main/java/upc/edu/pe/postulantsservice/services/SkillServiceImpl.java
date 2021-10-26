package upc.edu.pe.postulantsservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import upc.edu.pe.postulantsservice.entity.Skill;
import upc.edu.pe.postulantsservice.repositories.ProfessionalProfileRepository;
import upc.edu.pe.postulantsservice.repositories.SkillRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SkillServiceImpl implements SkillService{

    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private ProfessionalProfileRepository professionalProfileRepository;

    @Transactional
    @Override
    public Skill save(Skill entity) throws Exception {
        return skillRepository.save(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Skill> findAll() throws Exception {
        return skillRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Skill> findById(Long id) throws Exception {
        return skillRepository.findById(id);
    }

    @Transactional
    @Override
    public Skill update(Long id, Skill entity) throws Exception {
        entity.setId(id);
        return skillRepository.save(entity);
    }

    @Transactional
    @Override
    public void deleteById(Long id) throws Exception {
        skillRepository.deleteById(id);
    }

    @Override
    public Skill saveSkillByProfessionalProfileId(Long id, Skill skill) throws Exception {
        return professionalProfileRepository.findById(id).map(professionalProfile -> {
            skill.setProfessionalProfile(professionalProfile);
            return skillRepository.save(skill);
        }).orElseThrow();
    }

    @Override
    public List<Skill> getSkillsByProfessionalProfileId(Long id) throws Exception {
        return professionalProfileRepository.findById(id).map(professionalProfile -> {
            return professionalProfile.getSkills();
        }).orElseThrow();
    }
}
