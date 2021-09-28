package upc.edu.pe.gestionempleadoresservice.services;

import upc.edu.pe.gestionempleadoresservice.entities.Compania;
import upc.edu.pe.gestionempleadoresservice.entities.Empleador;
import upc.edu.pe.gestionempleadoresservice.entities.Sector;

import java.util.List;

public interface CompaniaService {
    Empleador getEmpleador(Long id);

    Sector getSector(Long id);

    Compania getCompania(Long id);

    //Para guardar una nueva entidad
    Compania save(Compania compania) throws Exception;
}
