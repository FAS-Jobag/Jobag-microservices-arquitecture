package com.jobag.postulationsservice.entity;

import com.jobag.postulationsservice.model.JobOffer;
import com.jobag.postulationsservice.model.ProfessionalProfile;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

public class Postulation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "job_offer_id")
    private Long jobOfferId;


    @Column(name = "create_at")
    @Temporal(TemporalType.DATE)
    private Date createAt;


    @Transient
    private List<ProfessionalProfile> professionalProfileList;

    @Transient
    private JobOffer jobOffer;


    @PrePersist
    public void prePersist() {
        this.createAt = new Date();
    }

    public void setId(Long id) {
        this.id = id;
    }
}
