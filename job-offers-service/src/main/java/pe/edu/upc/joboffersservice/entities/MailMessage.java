package pe.edu.upc.joboffersservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "mail_messages")
public class MailMessage {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String message;

    @Column(name = "document_link", nullable = false)
    private String documentLink;

    /*
     * Attributes of ddd (goods practices)
     * */

    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    @Column(length = 1, nullable = false)
    private String status;

    // RelationShips
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "job_offer_id")
    private JobOffer jobOffer;

}
