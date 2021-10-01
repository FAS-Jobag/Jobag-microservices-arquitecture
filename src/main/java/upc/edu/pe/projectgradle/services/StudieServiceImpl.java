package upc.edu.pe.projectgradle.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import upc.edu.pe.projectgradle.entity.Studie;
import upc.edu.pe.projectgradle.repositories.ProfessionalProfileRepository;
import upc.edu.pe.projectgradle.repositories.StudieRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudieServiceImpl implements StudieService{

    @Autowired
    private StudieRepository studieRepository;

    @Autowired
    private ProfessionalProfileRepository professionalProfileRepository;


    @Transactional
    @Override
    public Studie save(Studie entity) throws Exception {
        return studieRepository.save(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Studie> findAll() throws Exception {
        return studieRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Studie> findById(Long id) throws Exception {
        return studieRepository.findById(id);
    }

    @Transactional
    @Override
    public Studie update(Long id, Studie entity) throws Exception {
        entity.setId(id);
        return studieRepository.save(entity);
    }

    @Transactional
    @Override
    public void deleteById(Long id) throws Exception {
        studieRepository.deleteById(id);
    }

    @Override
    public Studie saveStudieByProfessionalProfileI(Long id, Studie studie) throws Exception {
        return professionalProfileRepository.findById(id).map(professionalProfile -> {
            studie.setProfessionalProfile(professionalProfile);
            return studieRepository.save(studie);
        }).orElseThrow();
    }
}
