package upc.edu.pe.gestionempleadoresservice.services;

import upc.edu.pe.gestionempleadoresservice.entities.Empleadores;

import java.util.List;
import java.util.Optional;

public interface EmpleadorService {
    Empleadores getEmpleadores(Long id);

    //Para guardar una nueva entidad
    Empleadores save(Empleadores entity) throws Exception;

    //Mostrar Todos
    List<Empleadores> findAll() throws Exception;

    //Muestra por Id
    Optional<Empleadores> findById(Long aLong) throws Exception;

    //Muestra por el numero de DNI
    Optional<Empleadores> findByDNI (Long DNI) throws Exception;

    //Para cambiar los datos de la entidad
    Empleadores update (Empleadores entity) throws Exception;

    //Eliminar por Id
    Empleadores deleteById(Empleadores empleadores) throws Exception;
}
