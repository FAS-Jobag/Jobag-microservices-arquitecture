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
* PlansPostulant
*/
@Entity
@Table(name = "plans_postulant")
@Data
public class PlanPostulant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 70)
	private String description;

	@Column(name = "limit_postulations")
	private Long limitPostulations;

	@Column(name = "pre_design_templates")
	private Boolean preDesignTemplates;

	@Column
	private int duration;

	@Column(name = "created_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;

	@Column(length = 1)
	private String status;
}
