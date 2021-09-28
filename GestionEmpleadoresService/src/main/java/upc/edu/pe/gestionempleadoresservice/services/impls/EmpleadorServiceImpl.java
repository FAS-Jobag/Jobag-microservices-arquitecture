package upc.edu.pe.gestionempleadoresservice.services.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import upc.edu.pe.gestionempleadoresservice.entities.Empleador;
import upc.edu.pe.gestionempleadoresservice.exception.ResourceNotFoundException;
import upc.edu.pe.gestionempleadoresservice.repositories.EmpleadorRepository;
import upc.edu.pe.gestionempleadoresservice.services.EmpleadorService;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadorServiceImpl implements EmpleadorService {

    @Autowired
    private EmpleadorRepository empleadorRepository;

    @Override
    public Empleador getEmpleador(Long id) {
        return empleadorRepository.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public Empleador save(Empleador entity) throws Exception {
        if (empleadorRepository.existsByDNI(entity.getDNI()))
            throw new  ResourceNotFoundException("El DNI ya esta registrado");

        if (empleadorRepository.existsByCorreo(entity.getCorreo()))
            throw new  ResourceNotFoundException("El correo electronico ya esta en uso");

        if (empleadorRepository.existsByCelular(entity.getCelular()))
            throw new  ResourceNotFoundException("El número de celular ya existe");

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
    public Empleador update(Empleador entity) throws Exception {
        Empleador empleadorDB = getEmpleador(entity.getId());

        if (null == empleadorDB){
            return null;
        }
        empleadorDB.getId();
        return empleadorRepository.save(
                empleadorDB.setNombres(entity.getNombres())
                .setApellidos(entity.getApellidos())
                .setDNI(entity.getDNI())
                .setCorreo(entity.getCorreo())
                .setCelular(entity.getCelular())
                .setContraseña(entity.getContraseña())
        );
    }

    @Override
    public void deleteById(Empleador empleadores) throws Exception {
        Empleador empleadorDB = getEmpleador(empleadores.getId());

        empleadorRepository.delete(empleadorDB);
    }


}
