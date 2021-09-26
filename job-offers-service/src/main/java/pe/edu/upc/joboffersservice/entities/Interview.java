package pe.edu.upc.joboffersservice.entities;

// Entity used for the creation of the videoconference

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Data
@Table(name = "interviews")
public class Interview {
    @Id @GeneratedValue
    private Long id;

    @Column
    // link of the videoconference
    private String link;

    @Column
    // confirmation if the videoconference was held
    private Boolean pending;

    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    // start date of the conference
    private Date startDate;

    @Column
    // time of duration of the videoconference
    private Double duration;

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
