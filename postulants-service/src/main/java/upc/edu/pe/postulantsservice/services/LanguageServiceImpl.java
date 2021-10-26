package upc.edu.pe.postulantsservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import upc.edu.pe.postulantsservice.entity.Language;
import upc.edu.pe.postulantsservice.repositories.LanguageRepository;
import upc.edu.pe.postulantsservice.repositories.ProfessionalProfileRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LanguageServiceImpl implements LanguageService{
    @Autowired
    private LanguageRepository languageRepository;

    @Autowired
    private ProfessionalProfileRepository professionalProfileRepository;

    @Transactional
    @Override
    public Language save(Language entity) throws Exception {
        return languageRepository.save(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Language> findAll() throws Exception {
        return languageRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Language> findById(Long id) throws Exception {
        return languageRepository.findById(id);
    }

    @Transactional
    @Override
    public Language update(Long id, Language entity) throws Exception {
        entity.setId(id);
        return languageRepository.save(entity);
    }

    @Transactional
    @Override
    public void deleteById(Long id) throws Exception {
        languageRepository.deleteById(id);
    }


    @Override
    public Language saveLanguageByProfessionalProfileId(Long id, Language language) throws Exception {
        return professionalProfileRepository.findById(id).map(professionalProfile -> {
            language.setProfessionalProfile(professionalProfile);
            return languageRepository.save(language);
        }).orElseThrow();
    }

    @Override
    public List<Language> getLanguagesByProfessionalProfileId(Long professionalProfileId) throws Exception {
        return professionalProfileRepository.findById(professionalProfileId).map(professionalProfile -> {
            return professionalProfile.getLanguages();
        }).orElseThrow();
    }
}
