package upc.edu.pe.postulantsservice.services;

import upc.edu.pe.postulantsservice.entity.Language;

import java.util.List;

public interface LanguageService extends CrudServices<Language, Long>{
    Language saveLanguageByProfessionalProfileId(Long id, Language language) throws Exception;
    List<Language> getLanguagesByProfessionalProfileId(Long professionalProfileId) throws Exception;

}
