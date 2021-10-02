package upc.edu.pe.projectgradle.services;

import upc.edu.pe.projectgradle.entity.Postulant;
import upc.edu.pe.projectgradle.entity.ProfessionalProfile;

public interface ProfessionalProfileService extends CrudServices<ProfessionalProfile, Long>{
    ProfessionalProfile saveByPostulantId(Long id, ProfessionalProfile professionalProfile) throws Exception;
}
