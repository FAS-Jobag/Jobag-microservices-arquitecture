package upc.edu.pe.subscriptionservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import upc.edu.pe.subscriptionservice.entities.EmployersPlans;
import upc.edu.pe.subscriptionservice.entities.PostulantsPlans;

/**
* EmployersPlansRepository
*/
@Repository
public interface EmployersPlansRepository extends JpaRepository<EmployersPlans,Long> {
    EmployersPlans findByEmployerId(Long employerId);
}
