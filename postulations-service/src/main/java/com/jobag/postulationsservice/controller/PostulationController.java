package com.jobag.postulationsservice.controller;

import com.jobag.postulationsservice.entity.Postulation;
import com.jobag.postulationsservice.services.PostulationService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/postulations")
public class PostulationController {
    @Autowired
    private PostulationService postulationService;

    @GetMapping(path = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Postulation> getById(@PathVariable Long id) {
        Postulation postulation  = postulationService.getPostulation(id);
        if (null == postulation) {
            return  ResponseEntity.notFound().build();
        }
        return  ResponseEntity.ok(postulation);
    }

    @Operation(summary="End-point para obtener la información de todas las postulaciones registradas",
            description="Mostrara a todas las postulaciones registradas")
    @GetMapping(path = "all")
    public ResponseEntity<List<Postulation>> listAllPostulations() throws Exception {
        List<Postulation> postulations = postulationService.findAll();
        if (postulations.isEmpty()) {
            return  ResponseEntity.noContent().build();
        }
        return  ResponseEntity.ok(postulations);
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

    @PostMapping(path = "jobOffer/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Postulation> saveByJobOfferId(@PathVariable Long id) {
        Postulation postulation = new Postulation();
        try {
            Postulation newPostulation =postulationService.createPostulacionByJobOfferId(id, postulation);
            if(newPostulation.getJobOfferId() != 0){
                return ResponseEntity.ok(newPostulation);
            }else{
                return ResponseEntity.badRequest().build();
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

}
