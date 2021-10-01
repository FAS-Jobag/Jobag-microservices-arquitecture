package upc.edu.pe.projectgradle.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "languages")
@Data
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 40, nullable = false)
    private String name;

    @Column(length = 40, nullable = false)
    private Integer level;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="professional_profile_id")
    private ProfessionalProfile professionalProfile;
}
