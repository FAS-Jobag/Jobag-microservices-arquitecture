package upc.edu.pe.gestionempleadoresservice.services.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upc.edu.pe.gestionempleadoresservice.entities.Compania;
import upc.edu.pe.gestionempleadoresservice.entities.Sector;
import upc.edu.pe.gestionempleadoresservice.repositories.CompaniaRepository;
import upc.edu.pe.gestionempleadoresservice.repositories.EmpleadorRepository;
import upc.edu.pe.gestionempleadoresservice.repositories.SectorRepository;
import upc.edu.pe.gestionempleadoresservice.services.CompaniaService;

import java.util.List;
import java.util.Optional;

@Service
public class CompaniaServiceImpl implements CompaniaService {
    @Autowired
    private CompaniaRepository companiaRepository;

    @Autowired
    private EmpleadorRepository empleadorRepository;

    @Autowired
    private SectorRepository sectorRepository;

    @Override
    public List<Compania> findCompaniaAll() {
        return companiaRepository.findAll();
    }

    @Override
    public List<Compania> findCompaniaBySector(Sector sector) {
        return companiaRepository.findBySector(sector);
    }

    @Override
    public Compania createCompania(Compania compania) {
        return companiaRepository.save(compania);
    }

    @Override
    public Compania updateCompania(Compania compania) {
        return null;
    }

    @Override
    public void deleteCompania(Compania compania) {

    }

    @Override
    public Compania getCompania(Long id) {
        return null;
    }
}
