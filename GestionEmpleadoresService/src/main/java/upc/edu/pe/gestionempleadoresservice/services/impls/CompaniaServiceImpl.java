package upc.edu.pe.gestionempleadoresservice.services.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import upc.edu.pe.gestionempleadoresservice.entities.Compania;
import upc.edu.pe.gestionempleadoresservice.entities.Empleador;
import upc.edu.pe.gestionempleadoresservice.entities.Sector;
import upc.edu.pe.gestionempleadoresservice.repositories.CompaniaRepository;
import upc.edu.pe.gestionempleadoresservice.services.CompaniaService;

import java.util.List;
import java.util.Optional;

@Service
public class CompaniaServiceImpl implements CompaniaService{
    @Autowired
    private CompaniaRepository companiaRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Compania> findCompaniaAll() {
        return companiaRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Compania> findById(Long aLong) throws Exception {
        return companiaRepository.findById(aLong);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Compania> findCompaniaBySector(Sector sector) {
        return companiaRepository.findBySector(sector);
    }

    @Transactional
    @Override
    public Compania createCompania(Compania compania) {
        return companiaRepository.save(compania);
    }

    @Transactional
    @Override
    public Compania updateCompania(Compania compania) {
        Compania companiaDB = getCompania(compania.getId());

        if (null == companiaDB){
            return null;
        }

        return companiaRepository.save(
                companiaDB.setNombreEmpresa(compania.getNombreEmpresa())
                        .setPais(compania.getPais())
                        .setCiudad(compania.getCiudad())
                        .setDistrito(compania.getDistrito())
                        .setRuc(compania.getRuc())
                        .setLogo(compania.getLogo())
                        .setDescription(compania.getDescription())
                        .setDireccion(compania.getDireccion())
        );
    }

    @Transactional
    @Override
    public void deleteCompania(Compania compania) {
        Compania companiaDB = getCompania(compania.getId());

        companiaRepository.delete(companiaDB);
    }

    @Transactional
    @Override
    public Compania getCompania(Long id) {
        return companiaRepository.findById(id).orElse(null);
    }
}
