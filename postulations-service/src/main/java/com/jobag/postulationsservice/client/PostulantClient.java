package com.jobag.postulationsservice.client;

import com.jobag.postulationsservice.model.Postulant;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * PostulantClient
 */
@FeignClient(name = "postulants-service", fallback = PostulantHystrixFallBackFactory.class)
public interface PostulantClient {
    @GetMapping(value = "/postulants/{id}")
    public ResponseEntity<Postulant> getPostulant(@PathVariable("id") Long id);
    
}
