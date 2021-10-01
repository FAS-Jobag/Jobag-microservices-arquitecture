package upc.edu.pe.projectgradle.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "studies")
@Data
public class Studie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 40, nullable = false)
    private String name;

    @Column(length = 40, nullable = false)
    private String degree;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="professional_profile_id")
    private ProfessionalProfile professionalProfile;
}
