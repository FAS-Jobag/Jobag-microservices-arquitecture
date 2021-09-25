package upc.edu.pe.subscriptionservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import upc.edu.pe.subscriptionservice.entities.PlansEmployer;

/**
* PlansEmployerRepository
*/
@Repository
public interface PlansEmployerRepository extends JpaRepository<PlansEmployer,Long> {
}
