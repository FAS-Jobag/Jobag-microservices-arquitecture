package com.jobag.postulationsservice.entity;



import com.jobag.postulationsservice.model.Postulant;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "postulation_item")
public class PostulationItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "postulant_id")
    private Long postulantId;
    @Transient
    private Postulant postulant;

}
