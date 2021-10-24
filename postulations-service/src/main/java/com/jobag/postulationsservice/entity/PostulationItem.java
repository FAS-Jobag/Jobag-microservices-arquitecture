package com.jobag.postulationsservice.entity;



import com.jobag.postulationsservice.model.ProfessionalProfile;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "postulation_item")
public class PostulationItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "professional_profile_id")
    private Long professionalProfileId;
    @Transient
    private ProfessionalProfile professionalProfile;
}
