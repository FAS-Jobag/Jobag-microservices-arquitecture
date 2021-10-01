package pe.edu.upc.joboffersservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.joboffersservice.entities.Interview;

public interface InterviewRepository extends JpaRepository<Interview, Long> {
}
