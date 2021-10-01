package upc.edu.pe.subscriptionservice.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

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

	@ManyToOne
	@JoinColumn(name = "plan_postulant_id")
	private PlanPostulant plansPostulant;
}
