package pe.edu.upc.joboffersservice.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "job_offers")
public class JobOffer {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 80)
    // job posting name
    private String name;

    @Column(length = 20)
    // type of employment: full-time or part-time
    private String type;

    // salary of work
    private Double salary;

    @Lob
    // description of work
    private String description;

    @Column
    // description of workplace
    private String workplace;

    @Temporal(TemporalType.TIMESTAMP)
    // publication date
    private Date date;

    @Lob
    // description of experience necessary
    private String experience;

    /*
     * Attributes of ddd (goods practices)
     * */

    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    @Column(length = 1, nullable = false)
    private String status;

    /*
     * Relationships
     * */


}
