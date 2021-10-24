package com.jobag.postulationsservice.client;

import com.jobag.postulationsservice.model.ProfessionalProfile;
import org.springframework.http.ResponseEntity;

public class ProfessionalProfileHystrixFallBackFactory implements ProfessionalProfileClient {
    @Override
    public ResponseEntity<ProfessionalProfile> getProfessionalProfile(Long id) {
        ProfessionalProfile professionalProfile = ProfessionalProfile.builder()
                .ocupation("none")
                .video("none")
                .experiencie("none").build();
        return ResponseEntity.ok().build();
    }
}
