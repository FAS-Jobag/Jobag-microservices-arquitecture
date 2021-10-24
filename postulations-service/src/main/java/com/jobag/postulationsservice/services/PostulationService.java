package com.jobag.postulationsservice.services;

import com.jobag.postulationsservice.entity.Postulation;
import org.springframework.stereotype.Service;

@Service
public interface PostulationService extends CrudServices<Postulation, Long> {
}
