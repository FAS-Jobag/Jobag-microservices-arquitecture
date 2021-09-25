package upc.edu.pe.subscriptionservice.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

/**
* PlansEmployer
*/
@Entity
@Table(name = "plans_employer")
@Data
public class PlansEmployer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 70)
	private String description;

	@Column(name = "limit_video_conferences")
	private Long limitVideoconference;

	@Column(name = "limit_modifications")
	private Long limitModification;

	@Column
	private Boolean assistance;

	@Column
	private Long duration;

	@Column(name = "created_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createAt;

	@Column(length = 1)
	private String status;
}
