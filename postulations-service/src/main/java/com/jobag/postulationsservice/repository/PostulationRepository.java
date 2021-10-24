package com.jobag.postulationsservice.repository;

import com.jobag.postulationsservice.entity.Postulation;
import com.jobag.postulationsservice.model.JobOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostulationRepository extends JpaRepository<Postulation,Long> {
}
