package com.jobag.postulationsservice.services.impl;

import com.jobag.postulationsservice.client.JobOfferClient;
import com.jobag.postulationsservice.client.ProfessionalProfileClient;
import com.jobag.postulationsservice.entity.Postulation;
import com.jobag.postulationsservice.entity.PostulationItem;
import com.jobag.postulationsservice.model.JobOffer;
import com.jobag.postulationsservice.model.ProfessionalProfile;
import com.jobag.postulationsservice.repository.PostulationRepository;
import com.jobag.postulationsservice.services.PostulationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class PostulationServiceImpl implements PostulationService {
    @Autowired
    private PostulationRepository postulationRepository;

    @Autowired
    JobOfferClient jobOfferClient;

    @Autowired
    ProfessionalProfileClient professionalProfileClient;

    @Transactional
    @Override
    public Postulation save(Postulation postulation) throws Exception {
        return postulationRepository.save(postulation);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Postulation> findAll() throws Exception {
        return postulationRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Postulation> findById(Long id) throws Exception {
        return postulationRepository.findById(id);
    }

    @Transactional
    @Override
    public Postulation update(Long id, Postulation postulation) throws Exception {
        postulation.setId(id);
        return postulationRepository.save(postulation);
    }

    @Transactional
    @Override
    public void deleteById(Long id) throws Exception {
        postulationRepository.deleteById(id);
    }

    @Override
    public Postulation getPostulation(Long id) {
        Postulation postulation= postulationRepository.findById(id).orElse(null);
        if (null != postulation){
            JobOffer jobOffer =jobOfferClient.getJobOffer(postulation.getJobOfferId()).getBody();
            //List<PostulationItem> listItem = postulation.getPostulationItem().stream().map(postulationItem -> {
            //    ProfessionalProfile professionalProfile = professionalProfileClient.getProfessionalProfile(postulationItem.getProfessionalProfileId()).getBody();
            //    postulationItem.setProfessionalProfile(professionalProfile);
            //    return postulationItem;
            //}).collect(Collectors.toList());
            postulation.setJobOffer(jobOffer);
        }
        return postulation;
    }

    @Override
    public Postulation createPostulacionByJobOfferId(Long jobOfferId, Postulation postulation) {
        if(null != jobOfferClient.getJobOffer(jobOfferId).getBody()){
            postulation.setJobOfferId(jobOfferId);
        }
        return postulationRepository.save(postulation);
    }
}
