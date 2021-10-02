package com.jobag.postulationsservice.controller;

import com.jobag.postulationsservice.entity.Postulation;
import com.jobag.postulationsservice.services.PostulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

public class PostulationController {
    @Autowired
    private PostulationService postulationService;

    @GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Postulation> getById(@PathVariable Long id) {
        try {
            Optional<Postulation> result = postulationService.findById(id);
            return result.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Postulation> save(@RequestBody Postulation Postulation) {
        try {
            return ResponseEntity.ok(postulationService.save(Postulation));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }


    @PutMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Postulation> update(@PathVariable Long id, @RequestBody Postulation Postulation) {
        try {
            return ResponseEntity.ok(postulationService.update(id, Postulation));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Postulation> deleteById(@PathVariable Long id) {
        try {
            postulationService.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
