package com.jobag.postulationsservice.services;

import com.jobag.postulationsservice.entity.Postulation;

import org.springframework.stereotype.Service;

@Service
public interface PostulationService extends CrudServices<Postulation, Long> {
    public Postulation getPostulation(Long id);
    public Postulation createPostulacionByJobOfferId(Long jobOfferId, Postulation postulation);
    public Postulation addPostulationItem(Long postulantId, Long postulationId); 
}
