package upc.edu.pe.postulantsservice.services;

import upc.edu.pe.postulantsservice.entity.Studie;

public interface StudieService extends CrudServices<Studie, Long>{
    Studie saveStudieByProfessionalProfileI(Long id, Studie studie) throws Exception;
}
