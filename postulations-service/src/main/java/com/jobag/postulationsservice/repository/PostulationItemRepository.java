package com.jobag.postulationsservice.repository;

import com.jobag.postulationsservice.entity.PostulationItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostulationItemRepository extends JpaRepository<PostulationItem, Long> {
}
