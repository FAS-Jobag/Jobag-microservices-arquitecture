package upc.edu.pe.postulantsservice.services;

import java.util.List;
import java.util.Optional;

public interface CrudServices<T, ID> {
    T save(T entity) throws Exception;
    List<T> findAll() throws Exception;
    Optional<T> findById(ID id) throws Exception;
    T update(Long id, T entity) throws Exception;
    void deleteById(ID id) throws Exception;
}
