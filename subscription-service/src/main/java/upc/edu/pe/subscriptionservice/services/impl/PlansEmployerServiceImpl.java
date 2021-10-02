package upc.edu.pe.subscriptionservice.services.impl;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import upc.edu.pe.subscriptionservice.entities.PlanEmployer;
import upc.edu.pe.subscriptionservice.repositories.PlansEmployerRepository;
import upc.edu.pe.subscriptionservice.services.PlansEmployerService;

/**
* PlansEmployerServiceImpl
*/
@Service
public class PlansEmployerServiceImpl implements PlansEmployerService {

	@Autowired
	private PlansEmployerRepository plansEmployerRepository;

	@Transactional
	@Override
	public PlanEmployer save(PlanEmployer entity) throws Exception {
		return plansEmployerRepository.save(entity);
	}

	@Transactional (readOnly = true)
	@Override
	public List<PlanEmployer> findAll() throws Exception {
		return plansEmployerRepository.findAll();
	}

	@Transactional (readOnly = true)
	@Override
	public Optional<PlanEmployer> findById(Long id) throws Exception {
		return plansEmployerRepository.findById(id);
	}

	@Transactional
	@Override
	public PlanEmployer update(PlanEmployer entity) throws Exception {
		return plansEmployerRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Long id) throws Exception {
		plansEmployerRepository.deleteById(id);
		
	}

}
