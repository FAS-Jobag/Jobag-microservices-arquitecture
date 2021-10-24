package com.jobag.postulationsservice.repository;

import com.jobag.postulationsservice.entity.Postulation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostulationRepository extends JpaRepository<Postulation,Long> {
}
