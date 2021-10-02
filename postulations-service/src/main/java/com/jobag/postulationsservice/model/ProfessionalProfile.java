package com.jobag.postulationsservice.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProfessionalProfile {

    private Long id;

    private String ocupation;

    private String video;

    private String experiencie;
}
