package upc.edu.pe.subscriptionservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import upc.edu.pe.subscriptionservice.entities.PostulantsPlans;

/**
* PostulantsPlansRepository
*/
@Repository
public interface PostulantsPlansRepository extends JpaRepository<PostulantsPlans, Long> {
}
