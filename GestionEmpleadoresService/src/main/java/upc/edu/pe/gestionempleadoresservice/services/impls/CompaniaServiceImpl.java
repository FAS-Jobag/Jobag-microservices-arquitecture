package upc.edu.pe.gestionempleadoresservice.services.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upc.edu.pe.gestionempleadoresservice.entities.Compania;
import upc.edu.pe.gestionempleadoresservice.entities.Empleador;
import upc.edu.pe.gestionempleadoresservice.entities.Sector;
import upc.edu.pe.gestionempleadoresservice.repositories.CompaniaRepository;
import upc.edu.pe.gestionempleadoresservice.repositories.EmpleadorRepository;
import upc.edu.pe.gestionempleadoresservice.repositories.SectorRepository;
import upc.edu.pe.gestionempleadoresservice.services.CompaniaService;

@Service
public class CompaniaServiceImpl implements CompaniaService {
    @Autowired
    private CompaniaRepository companiaRepository;

    @Autowired
    private EmpleadorRepository empleadorRepository;

    @Autowired
    private SectorRepository sectorRepository;

    @Override
    public Empleador getEmpleador(Long id) {
        return empleadorRepository.findById(id).orElse(null);
    }

    @Override
    public Sector getSector(Long id) {
        return sectorRepository.findById(id).orElse(null);
    }

    @Override
    public Compania getCompania(Long id) {
        return companiaRepository.findById(id).orElse(null);
    }

    @Override
    public Compania save(Compania compania) throws Exception {
        return companiaRepository.save(compania);
    }
}
