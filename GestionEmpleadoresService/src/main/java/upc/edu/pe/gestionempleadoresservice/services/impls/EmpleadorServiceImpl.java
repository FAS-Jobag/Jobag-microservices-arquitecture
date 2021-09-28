package upc.edu.pe.gestionempleadoresservice.services.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import upc.edu.pe.gestionempleadoresservice.entities.Empleador;
import upc.edu.pe.gestionempleadoresservice.repositories.EmpleadorRepository;
import upc.edu.pe.gestionempleadoresservice.services.EmpleadorService;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadorServiceImpl implements EmpleadorService {

    @Autowired
    private EmpleadorRepository empleadorRepository;

    @Transactional
    @Override
    public Empleador save(Empleador entity) throws Exception {
        return empleadorRepository.save(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Empleador> findAll() throws Exception {
        return empleadorRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Empleador> findById(Long aLong) throws Exception {
        return empleadorRepository.findById(aLong);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Empleador> findByDNI(Long DNI) throws Exception {
        return empleadorRepository.findByDNI(DNI);
    }

    @Override
    public Empleador update(Long id, Empleador entity) throws Exception {
        Empleador empleador = empleadorRepository.findById(id);
    }

    @Override
    public ResponseEntity<?> deleteById(Long id) throws Exception {
        return null;
    }


}
