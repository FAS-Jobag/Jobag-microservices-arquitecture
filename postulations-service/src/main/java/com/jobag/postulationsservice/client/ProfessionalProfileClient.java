package com.jobag.postulationsservice.client;

import com.jobag.postulationsservice.model.ProfessionalProfile;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "postulants-service", fallback = JobOfferHystrixFallbackFactory.class)
public interface ProfessionalProfileClient {
    @GetMapping(value = "professional_profile/{id}")
    public ResponseEntity<ProfessionalProfile> getProfessionalProfile(@PathVariable("id") Long id);
}
