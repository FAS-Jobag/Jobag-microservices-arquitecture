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
* EmployersPlans
*/
@Entity
@Table(name = "employers_plans")
@Data
public class EmployersPlans {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "employer_id")
	private Long employerId;

	@ManyToOne
	@JoinColumn(name = "plan_employer_id")
	private PlanEmployer plansEmployer;
}
