package upc.edu.pe.subscriptionservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import upc.edu.pe.subscriptionservice.entities.PlanEmployer;

/**
* PlansEmployerRepository
*/
@Repository
public interface PlansEmployerRepository extends JpaRepository<PlanEmployer,Long> {
}
