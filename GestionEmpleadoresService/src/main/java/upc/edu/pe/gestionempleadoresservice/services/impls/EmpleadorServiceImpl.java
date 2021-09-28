package upc.edu.pe.gestionempleadoresservice.services.impls;

import org.springframework.beans.factory.annotation.Autowired;
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
    private EmpleadorRepository empleadoresRepository;

    @Override
    public Empleador getEmpleadores(Long id) {
        Empleador empleador = empleadoresRepository.findById(id).orElse(null);
        return empleador;
    }

    @Transactional
    @Override
    public Empleador save(Empleador entity) throws Exception {
        return empleadoresRepository.save(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Empleador> findAll() throws Exception {
        return empleadoresRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Empleador> findById(Long aLong) throws Exception {
        return empleadoresRepository.findById(aLong);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Empleador> findByDNI(Long DNI) throws Exception {
        return empleadoresRepository.findByDNI(DNI);
    }

    @Override
    public Empleador update(Empleador entity) throws Exception {
        Empleador empleadoresDB = getEmpleadores(entity.getId());
        if (empleadoresDB == null){
            return  null;
        }
        empleadoresDB.setId(entity.getId());
        empleadoresDB.setNombres(entity.getNombres());
        empleadoresDB.setApellidos(entity.getApellidos());
        empleadoresDB.setDNI(entity.getDNI());
        empleadoresDB.setCorreo(entity.getCorreo());
        empleadoresDB.setCelular(entity.getCelular());
        empleadoresDB.setContraseña(entity.getContraseña());

        return  empleadoresRepository.save(empleadoresDB);
    }

    //Consultar
    @Override
    public Empleador deleteById(Empleador empleadores) throws Exception {
        Empleador empleadoresDB = getEmpleadores(empleadores.getId());

        if (null == empleadoresDB){
            return null;
        }

        empleadoresDB.setStatus("DELETED");
        return empleadoresRepository.save(empleadoresDB);
    }

}
