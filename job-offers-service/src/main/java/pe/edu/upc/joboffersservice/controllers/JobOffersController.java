package pe.edu.upc.joboffersservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.joboffersservice.entities.JobOffer;
import pe.edu.upc.joboffersservice.services.JobOfferService;

import java.util.Optional;

@RestController
@RequestMapping("api/job-offers")
public class JobOffersController {
    @Autowired
    private JobOfferService jobOfferService;

    @GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JobOffer> getById(@PathVariable Long id) {
        try {
            Optional<JobOffer> result = jobOfferService.findById(id);
            return  result.isPresent() ? ResponseEntity.ok(result.get()) : ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping
    public ResponseEntity<JobOffer> save(@RequestBody JobOffer jobOffer) {
        try {
            JobOffer result = jobOfferService.save(jobOffer);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

}
