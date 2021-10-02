package com.jobag.postulationservice.client;
//import org.springframework.cloud.openfeign.FeignClient;

import com.jobag.postulationservice.model.ProfessionalProfile;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "postulants-service", fallback = PostulantHystrixFallbackFactory.class)
public interface ProfessionalProfileClient {
    @GetMapping(value = "/professional-profile/{id}")
    public ResponseEntity<ProfessionalProfile> getProfessionalProfile(@PathVariable("id") long id);
}
