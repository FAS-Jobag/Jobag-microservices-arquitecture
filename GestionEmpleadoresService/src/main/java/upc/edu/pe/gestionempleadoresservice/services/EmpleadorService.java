package upc.edu.pe.gestionempleadoresservice.services;

import upc.edu.pe.gestionempleadoresservice.entities.Empleador;

import java.util.List;
import java.util.Optional;

public interface EmpleadorService{
    Empleador getEmpleador(Long id);

    //Para guardar una nueva entidad
    Empleador save(Empleador entity) throws Exception;

    //Mostrar Todos
    List<Empleador> findAll() throws Exception;

    //Muestra por Id
    Optional<Empleador> findById(Long aLong) throws Exception;

    //Muestra por el numero de DNI
    Optional<Empleador> findByDNI (Long DNI) throws Exception;

    //Para cambiar los datos de la entidad
    Empleador update (Empleador entity) throws Exception;

    //Eliminar por Id
    void deleteById(Empleador empleadores) throws Exception;
}
