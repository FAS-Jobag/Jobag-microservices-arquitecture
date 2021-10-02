package com.jobag.postulationsservice.services.impl;

import com.jobag.postulationsservice.entity.Postulation;
import com.jobag.postulationsservice.repository.PostulationRepository;
import com.jobag.postulationsservice.services.PostulationService;

import java.util.List;
import java.util.Optional;

public class PostulationServiceImpl implements PostulationService {
    private PostulationRepository postulationRepository;

    @Override
    public Postulation save(Postulation postulation) throws Exception {
        return postulationRepository.save(postulation);
    }

    @Override
    public List<Postulation> findAll() throws Exception {
        return postulationRepository.findAll();
    }

    @Override
    public Optional<Postulation> findById(Long id) throws Exception {
        return postulationRepository.findById(id);
    }

    @Override
    public Postulation update(Long id, Postulation postulation) throws Exception {
        postulation.setId(id);
        return postulationRepository.save(postulation);
    }

    @Override
    public void deleteById(Long id) throws Exception {
        postulationRepository.deleteById(id);

    }
}
