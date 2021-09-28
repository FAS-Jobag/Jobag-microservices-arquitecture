package upc.edu.pe.gestionempleadoresservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import upc.edu.pe.gestionempleadoresservice.entities.Compania;
import upc.edu.pe.gestionempleadoresservice.entities.Sector;

import java.util.List;

@Repository
public interface CompaniaRepository extends JpaRepository<Compania, Long> {
    public List<Compania> findBySector (Sector sector);
}
