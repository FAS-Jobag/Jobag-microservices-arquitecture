package upc.edu.pe.gestionempleadoresservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import upc.edu.pe.gestionempleadoresservice.entities.Sector;

@Repository
public interface SectorRepository extends JpaRepository<Sector, Long>{
}
