package upc.edu.pe.projectgradle.services;

import upc.edu.pe.projectgradle.entity.Language;

public interface LanguageService extends CrudServices<Language, Long>{
    Language saveLanguageByProfessionalProfileId(Long id, Language language) throws Exception;
}
