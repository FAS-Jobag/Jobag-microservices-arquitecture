package com.jobag.postulationsservice.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * Postulant
 */
@Data
@Builder
public class Postulant {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String number;
    private String password;
    private String document;
    private String civil_status;
    private Date createdAt;
}
