package upc.edu.pe.subscriptionservice.entities;


import javax.persistence.*;

import lombok.Data;
import upc.edu.pe.subscriptionservice.models.Employer;

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

	@Transient
	private Employer employer;

	@ManyToOne
	@JoinColumn(name = "plan_employer_id")
	private PlanEmployer plansEmployer;
}
