package com.jobag.postulationservice.client;
//import org.springframework.cloud.openfeign.FeignClient;

import com.jobag.postulationservice.model.ProfessionalProfile;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "postulants-service", fallback = PostulantHystrixFallbackFactory.class)
public interface ProfessionalProfileClient {
    @GetMapping(value = "/postulants/{id}")
    public ResponseEntity<> getProfessionalProfile(@PathVariable("id") long id);
}
