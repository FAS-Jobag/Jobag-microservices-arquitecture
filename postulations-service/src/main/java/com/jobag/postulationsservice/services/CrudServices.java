package com.jobag.postulationsservice.services;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CrudServices<T, ID> {
    T save(T entity) throws Exception;
    List<T> findAll() throws Exception;
    Optional<T> findById(ID id) throws Exception;
    T update(Long id, T entity) throws Exception;
    void deleteById(ID id) throws Exception;
}