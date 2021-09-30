package upc.edu.pe.projectgradle.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "postulants")
@Data
public class Postulant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 40, nullable = false)
    private String firstName;

    @Column(length = 40, nullable = false)
    private String lastName;

    @Column(length = 30, nullable = false)
    private String email;

    @Column(length = 40, nullable = false)
    private String number;

    @Column(length = 20, nullable = false)
    private String password;

    @Column(length = 40, nullable = false)
    private String document;

    @Column(length = 40, nullable = false)
    private String civil_status;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
}
