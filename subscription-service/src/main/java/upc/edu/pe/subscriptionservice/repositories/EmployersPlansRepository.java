package upc.edu.pe.subscriptionservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import upc.edu.pe.subscriptionservice.entities.EmployersPlans;

/**
* EmployersPlansRepository
*/
@Repository
public interface EmployersPlansRepository extends JpaRepository<EmployersPlans,Long> {
}
