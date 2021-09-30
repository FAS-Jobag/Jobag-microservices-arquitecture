package upc.edu.pe.gestionempleadoresservice.services;

import upc.edu.pe.gestionempleadoresservice.entities.Sector;

import java.util.List;
import java.util.Optional;

public interface SectorService{
    Sector getSector(Long id);

    //Para guardar una nueva entidad
    Sector save(Sector entity) throws Exception;

    //Mostrar Todos
    List<Sector> findAll() throws Exception;

    //Muestra por Id
    Optional<Sector> findById(Long aLong) throws Exception;

    //Para cambiar los datos de la entidad por Id
    Sector updateById (Sector entity) throws Exception;

    //Eliminar por Id
    void deleteById(Sector entity) throws Exception;
}
