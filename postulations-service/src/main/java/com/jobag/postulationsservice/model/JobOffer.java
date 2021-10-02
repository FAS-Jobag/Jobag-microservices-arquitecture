package com.jobag.postulationsservice.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class JobOffer {

    private Long id;

    private String name;

    private String type;

    private Double salary;

    private String description;

    private String workplace;

    private Date date;

    private String experience;

}
