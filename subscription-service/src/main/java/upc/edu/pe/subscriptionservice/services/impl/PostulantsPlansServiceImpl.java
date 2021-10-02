package upc.edu.pe.subscriptionservice.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import upc.edu.pe.subscriptionservice.entities.PostulantsPlans;
import upc.edu.pe.subscriptionservice.repositories.PostulantsPlansRepository;
import upc.edu.pe.subscriptionservice.services.PostulantsPlansService;

/**
* PostulantsPlansServiceImpl
*/
@Service
public class PostulantsPlansServiceImpl implements PostulantsPlansService {
	@Autowired
	private PostulantsPlansRepository postulantsPlansRepository;

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
	
}
