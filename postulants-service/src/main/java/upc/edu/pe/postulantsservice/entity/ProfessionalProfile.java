package upc.edu.pe.postulantsservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "professional_profile")
@Data
public class ProfessionalProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 40, nullable = false)
    private String ocupation;

    @Column(length = 40, nullable = false)
    private String video;

    @Column(length = 40, nullable = false)
    private String experiencie;

    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "fk_Postulant", updatable = false, nullable = false)
    private Postulant postulant;



    @OneToMany(mappedBy = "professionalProfile")
    @JsonIgnore
    List<Language> languages = new ArrayList<>();

    @OneToMany(mappedBy = "professionalProfile")
    @JsonIgnore
    List<Skill> skills = new ArrayList<>();

    @OneToMany(mappedBy = "professionalProfile")
    @JsonIgnore
    List<Studie> studies = new ArrayList<>();

}
