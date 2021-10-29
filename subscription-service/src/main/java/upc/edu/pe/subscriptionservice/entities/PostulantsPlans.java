package upc.edu.pe.subscriptionservice.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;
import upc.edu.pe.subscriptionservice.models.Postulant;

/**
* PostulantsPlans
*/
@Entity
@Table(name = "postulants_plans")
@Data
public class PostulantsPlans {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "postulant_id")
	private Long postulantId;

	@Transient
	private Postulant postulant;

	@ManyToOne
	@JoinColumn(name = "plan_postulant_id")
	private PlanPostulant plansPostulant;
}
