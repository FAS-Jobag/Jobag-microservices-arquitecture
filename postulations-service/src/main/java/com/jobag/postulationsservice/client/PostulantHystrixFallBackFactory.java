package com.jobag.postulationsservice.client;

import java.util.Date;

import com.jobag.postulationsservice.model.Postulant;

import org.springframework.http.ResponseEntity;

/**
 * PostulantHystrixFallBackFactory
 */
public class PostulantHystrixFallBackFactory implements PostulantClient {

	@Override
	public ResponseEntity<Postulant> getPostulant(Long id) {
      Postulant postulant = Postulant.builder()
          .firstName("none")
          .lastName("none")
          .email("none")
          .number("none")
          .password("none")
          .document("none")
          .civil_status("none")
          .createdAt(new Date()).build();
      return ResponseEntity.ok(postulant);
	}

}
