package upc.edu.pe.projectgradle.services;

import upc.edu.pe.projectgradle.entity.Studie;

public interface StudieService extends CrudServices<Studie, Long>{
    Studie saveStudieByProfessionalProfileI(Long id, Studie studie) throws Exception;
}
