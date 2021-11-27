package com.jobag.postulationsservice.services.impl;

import com.jobag.postulationsservice.client.JobOfferClient;
import com.jobag.postulationsservice.client.PostulantClient;
import com.jobag.postulationsservice.entity.Postulation;
import com.jobag.postulationsservice.entity.PostulationItem;
import com.jobag.postulationsservice.model.JobOffer;
import com.jobag.postulationsservice.model.Postulant;
import com.jobag.postulationsservice.repository.PostulationItemRepository;
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
    PostulantClient postulantClient;

    @Transactional
    @Override
    public Postulation save(Postulation postulation) throws Exception {
        return postulationRepository.save(postulation);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Postulation> findAll() throws Exception {
        List<Postulation> lista = postulationRepository.findAll();
        lista.forEach( p -> {
            JobOffer jobOffer =jobOfferClient.getJobOffer(p.getJobOfferId()).getBody();
            p.setJobOffer(jobOffer);
            if (p.getPostulationItem() != null){
                List<PostulationItem> listItem = p.getPostulationItem().stream().map(postulationItem -> {
                    Postulant postulant = postulantClient.getPostulant(postulationItem.getPostulantId()).getBody();
                    postulationItem.setPostulant(postulant);
                    return postulationItem;
                }).collect(Collectors.toList());
                p.setPostulationItem(listItem);
            }
        });
        return lista;
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
            postulation.setJobOffer(jobOffer);
            if (postulation.getPostulationItem() != null){
                List<PostulationItem> listItem = postulation.getPostulationItem().stream().map(postulationItem -> {
                    Postulant postulant = postulantClient.getPostulant(postulationItem.getPostulantId()).getBody();
                    postulationItem.setPostulant(postulant);
                    return postulationItem;
                }).collect(Collectors.toList());
                postulation.setPostulationItem(listItem);
            }
        }
        return postulation;
    }

    @Override
    public Postulation createPostulacionByJobOfferId(Long jobOfferId, Postulation postulation) {
        Postulation postulationNew;
        if(null != jobOfferClient.getJobOffer(jobOfferId).getBody()){
            postulation.setJobOfferId(jobOfferId);
            postulationNew = postulationRepository.save(postulation);
            JobOffer jobOffer = jobOfferClient.getJobOffer(jobOfferId).getBody();
            postulationNew.setJobOffer(jobOffer);
            return postulationNew;
        }else{
            postulationNew = new Postulation();
            postulationNew.setJobOfferId(0L);
            return postulationNew;
        }
    }

	@Override
	public Postulation addPostulationItem(Long postulantId, Long postulationId) {
      Postulation postulation = postulationRepository.findById(postulationId).orElse(null);
      if (postulation != null){
          Postulant postulant = postulantClient.getPostulant(postulantId).getBody();
          if (postulant != null){
              PostulationItem newPostulationItem = new PostulationItem();
              newPostulationItem.setPostulantId(postulantId);
              newPostulationItem.setPostulant(postulant);
              postulation.getPostulationItem().add(newPostulationItem);
                
          }
          return postulationRepository.save(postulation);
      }
      return postulation;
	}

}
