package upc.edu.pe.projectgradle.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import upc.edu.pe.projectgradle.entity.Postulant;
import upc.edu.pe.projectgradle.repositories.PostulantRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PostulantServiceImpl implements PostulantService{

    @Autowired
    private PostulantRepository postulantRepository;

    @Transactional
    @Override
    public Postulant save(Postulant entity) throws Exception {
        return postulantRepository.save(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Postulant> findAll() throws Exception {
        return postulantRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Postulant> findById(Long id) throws Exception {
        return postulantRepository.findById(id);
    }

    @Transactional
    @Override
    public Postulant update(Postulant entity) throws Exception {
        return postulantRepository.save(entity);
    }

    @Transactional
    @Override
    public void deleteById(Long id) throws Exception {
        postulantRepository.deleteById(id);
    }
}
