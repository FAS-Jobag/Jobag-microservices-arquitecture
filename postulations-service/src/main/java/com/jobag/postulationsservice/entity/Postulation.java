package com.jobag.postulationsservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jobag.postulationsservice.model.JobOffer;
import com.jobag.postulationsservice.model.ProfessionalProfile;
import lombok.Data;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "postulations")
@Data
public class Postulation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "job_offer_id")
    private Long jobOfferId;

    @Column(name = "create_at")
    @Temporal(TemporalType.DATE)
    private Date createAt;

    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "postulation_id")
    private List<PostulationItem> postulationItem;

    @Transient
    private JobOffer jobOffer;

    public Postulation(){
        postulationItem = new ArrayList<>();
    }
    @PrePersist
    public void prePersist() {
        this.createAt = new Date();
    }

    public void setId(Long id) {
        this.id = id;
    }
}
