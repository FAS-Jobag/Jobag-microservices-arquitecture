package upc.edu.pe.gestionempleadoresservice.services;

import upc.edu.pe.gestionempleadoresservice.entities.Compania;
import upc.edu.pe.gestionempleadoresservice.entities.Empleador;
import upc.edu.pe.gestionempleadoresservice.entities.Sector;

import java.util.List;
import java.util.Optional;

public interface CompaniaService{

    public Compania getCompania(Long id);
    public List<Compania> findCompaniaAll();
    Optional<Compania> findById(Long aLong) throws Exception;
    public List<Compania> findCompaniaBySector(Sector sector);
    public Compania createCompania(Compania compania);
    public Compania updateCompania(Compania compania);
    void deleteCompania(Compania compania);
}
