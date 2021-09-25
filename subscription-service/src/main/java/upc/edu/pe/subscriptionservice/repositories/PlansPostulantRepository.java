package upc.edu.pe.subscriptionservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import upc.edu.pe.subscriptionservice.entities.PlansPostulant;

/**
* PlansPostulantRepository
*/
@Repository
public interface PlansPostulantRepository extends JpaRepository<PlansPostulant,Long> {
}
