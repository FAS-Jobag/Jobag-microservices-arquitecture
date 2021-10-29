package upc.edu.pe.subscriptionservice.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import upc.edu.pe.subscriptionservice.client.PostulantClient;
import upc.edu.pe.subscriptionservice.entities.PlanPostulant;
import upc.edu.pe.subscriptionservice.entities.PostulantsPlans;
import upc.edu.pe.subscriptionservice.models.Postulant;
import upc.edu.pe.subscriptionservice.repositories.PlansPostulantRepository;
import upc.edu.pe.subscriptionservice.repositories.PostulantsPlansRepository;
import upc.edu.pe.subscriptionservice.services.PostulantsPlansService;

/**
* PostulantsPlansServiceImpl
*/
@Service
public class PostulantsPlansServiceImpl implements PostulantsPlansService {
	@Autowired
	private PostulantsPlansRepository postulantsPlansRepository;

	@Autowired
	private PlansPostulantRepository plansPostulantRepository;

	@Autowired
	private PostulantClient postulantClient;

	@Transactional
	@Override
	public PostulantsPlans save(PostulantsPlans entity) throws Exception {
		return postulantsPlansRepository.save(entity);
	}

	@Transactional(readOnly = true)
	@Override
	public List<PostulantsPlans> findAll() throws Exception {
		return postulantsPlansRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<PostulantsPlans> findById(Long id) throws Exception {
		return postulantsPlansRepository.findById(id); 
	}

	@Transactional
	@Override
	public PostulantsPlans update(PostulantsPlans entity) throws Exception {
		return postulantsPlansRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Long id) throws Exception {
		postulantsPlansRepository.deleteById(id);
	}

	@Transactional
	@Override
	public PostulantsPlans assignSubscriptionToPostulant(Long subscriptionId, Long postulantId) {
		// Postulant postulant = postulantClient.getPostulant(1).getBody();
		// System.out.println(postulant.getFirstName());
		if (postulantsPlansRepository.findByPostulantId(postulantId) != null) return null;

		return plansPostulantRepository.findById(subscriptionId).map(plan -> {
			PostulantsPlans postulantsPlans = new PostulantsPlans();
			postulantsPlans.setPlansPostulant(plan);
			postulantsPlans.setPostulantId(postulantId);
			return postulantsPlansRepository.save(postulantsPlans);
		}).orElse(null);
	}

	@Override
	public void unassignSubscriptionToPostulant(Long subscriptionId, Long postulantId) {
		PlanPostulant plan = plansPostulantRepository.findById(subscriptionId).orElse(null);
		if (plan != null) {
			PostulantsPlans postulantPlan = postulantsPlansRepository.findByPostulantId(postulantId);
			postulantsPlansRepository.delete(postulantPlan);
		}
	}

	@Override
	public PostulantsPlans getPlanByPostulantId(Long postulantId) {
		PostulantsPlans plan = postulantsPlansRepository.findByPostulantId(postulantId);
		ResponseEntity<Postulant> postulant = postulantClient.getPostulant(plan.getPostulantId());
		plan.setPostulant(postulant.getBody());
		return  plan;
	}
}
