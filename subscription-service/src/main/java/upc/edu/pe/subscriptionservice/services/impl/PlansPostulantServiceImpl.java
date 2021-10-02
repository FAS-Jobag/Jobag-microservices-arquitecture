package upc.edu.pe.subscriptionservice.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import upc.edu.pe.subscriptionservice.entities.PlanPostulant;
import upc.edu.pe.subscriptionservice.repositories.PlansPostulantRepository;
import upc.edu.pe.subscriptionservice.services.PlansPostulantService;

/**
* PlansPostulantServiceImpl
*/
@Service
public class PlansPostulantServiceImpl implements PlansPostulantService {

	@Autowired
	private PlansPostulantRepository plansPostulantRepository;

	@Transactional
	@Override
	public PlanPostulant save(PlanPostulant entity) throws Exception {
		return plansPostulantRepository.save(entity);
	}

	@Transactional( readOnly = true)
	@Override
	public List<PlanPostulant> findAll() throws Exception {
		return plansPostulantRepository.findAll();
	}

	@Transactional( readOnly = true)
	@Override
	public Optional<PlanPostulant> findById(Long id) throws Exception {
		return plansPostulantRepository.findById(id);
	}

	@Transactional
	@Override
	public PlanPostulant update(PlanPostulant entity) throws Exception {
		return plansPostulantRepository.save(entity); 
	}

	@Transactional
	@Override
	public void deleteById(Long id) throws Exception {
		plansPostulantRepository.deleteById(id);
		
	}
	
}
