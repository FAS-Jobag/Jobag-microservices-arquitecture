package pe.edu.upc.joboffersservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.joboffersservice.entities.Contract;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Long> {
}
