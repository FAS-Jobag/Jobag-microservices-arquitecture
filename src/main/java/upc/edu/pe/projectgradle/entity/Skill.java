package upc.edu.pe.projectgradle.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "skills")
@Data
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 40, nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="professional_profile_id")
    private ProfessionalProfile professionalProfile;
}
