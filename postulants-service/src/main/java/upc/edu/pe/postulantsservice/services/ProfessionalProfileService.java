package upc.edu.pe.postulantsservice.services;

import upc.edu.pe.postulantsservice.entity.ProfessionalProfile;

public interface ProfessionalProfileService extends CrudServices<ProfessionalProfile, Long>{
    ProfessionalProfile saveByPostulantId(Long id, ProfessionalProfile professionalProfile) throws Exception;
}
