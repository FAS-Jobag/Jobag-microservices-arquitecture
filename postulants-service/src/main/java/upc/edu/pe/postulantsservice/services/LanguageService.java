package upc.edu.pe.postulantsservice.services;

import upc.edu.pe.postulantsservice.entity.Language;

public interface LanguageService extends CrudServices<Language, Long>{
    Language saveLanguageByProfessionalProfileId(Long id, Language language) throws Exception;
}
