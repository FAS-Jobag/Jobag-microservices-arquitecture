package upc.edu.pe.projectgradle.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import upc.edu.pe.projectgradle.entity.Postulant;
import upc.edu.pe.projectgradle.entity.ProfessionalProfile;
import upc.edu.pe.projectgradle.repositories.PostulantRepository;
import upc.edu.pe.projectgradle.repositories.ProfessionalProfileRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessionalProfileServiceImpl implements ProfessionalProfileService{

    @Autowired
    private ProfessionalProfileRepository professionalProfileRepository;

    @Autowired
    private PostulantRepository postulantRepository;

    @Transactional
    @Override
    public ProfessionalProfile save(ProfessionalProfile entity) throws Exception {
        return professionalProfileRepository.save(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public List<ProfessionalProfile> findAll() throws Exception {
        return professionalProfileRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<ProfessionalProfile> findById(Long id) throws Exception {
        return professionalProfileRepository.findById(id);
    }

    @Transactional
    @Override
    public ProfessionalProfile update(Long id, ProfessionalProfile entity) throws Exception {
        entity.setId(id);
        return professionalProfileRepository.save(entity);
    }

    @Transactional
    @Override
    public void deleteById(Long id) throws Exception {
        professionalProfileRepository.deleteById(id);
    }

    @Override
    public ProfessionalProfile saveByPostulantId(Long id, ProfessionalProfile professionalProfile) throws Exception {
        return postulantRepository.findById(id).map(postulant -> {
            professionalProfile.setPostulant(postulant);
            return professionalProfileRepository.save(professionalProfile);
        }).orElseThrow();
    }


}
