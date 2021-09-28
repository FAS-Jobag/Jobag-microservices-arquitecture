package upc.edu.pe.gestionempleadoresservice.services.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import upc.edu.pe.gestionempleadoresservice.entities.Sector;
import upc.edu.pe.gestionempleadoresservice.repositories.SectorRepository;
import upc.edu.pe.gestionempleadoresservice.services.SectorService;

import java.util.List;
import java.util.Optional;

@Service
public class SectorServiceImpl implements SectorService {
    @Autowired
    private SectorRepository sectorRepository;

    @Override
    public Sector getSector(Long id) {
        return sectorRepository.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public Sector save(Sector entity) throws Exception {
        return sectorRepository.save(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Sector> findAll() throws Exception {
        return sectorRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Sector> findById(Long aLong) throws Exception {
        return sectorRepository.findById(aLong);
    }

    @Transactional
    @Override
    public Sector updateById(Sector entity) throws Exception {
        Sector sectorDB = getSector(entity.getId());

        if(null == sectorDB)
            return null;

        return sectorRepository.save(
                sectorDB.setNombre(entity.getNombre())
                .setDescripcion(entity.getDescripcion())
        );
    }

    @Override
    public void deleteById(Sector entity) throws Exception {
        Sector sectorDB = getSector(entity.getId());
        
        sectorRepository.delete(sectorDB);
    }
}
