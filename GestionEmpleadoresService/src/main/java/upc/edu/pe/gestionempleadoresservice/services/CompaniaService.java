package upc.edu.pe.gestionempleadoresservice.services;

import upc.edu.pe.gestionempleadoresservice.entities.Compania;
import upc.edu.pe.gestionempleadoresservice.entities.Sector;

import java.util.List;

public interface CompaniaService {

    public List<Compania> findCompaniaAll();
    public List<Compania> findCompaniaBySector(Sector sector);
    public Compania createCompania(Compania compania);
    public Compania updateCompania(Compania compania);
    void deleteCompania(Compania compania);
    public Compania getCompania(Long id);
}
