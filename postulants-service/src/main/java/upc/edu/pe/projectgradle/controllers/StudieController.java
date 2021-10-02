package upc.edu.pe.projectgradle.controllers;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.projectgradle.entity.Studie;
import upc.edu.pe.projectgradle.services.StudieService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(name = "/studies")
public class StudieController {
    @Autowired
    private StudieService studieService;

    @Operation(summary = "All Studies", tags = {"Studies"})
    @GetMapping(path = "/studies", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Studie> getAllStudies() throws Exception {
        return studieService.findAll();
    }

    @Operation(summary = "Get Studie by ID", description = "Get Studie by ID", tags={"Studies"})
    @GetMapping(path = "/studies/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Studie> fetchById(@PathVariable("id") Long id) {
        try{
            Optional<Studie> optionalStudie = studieService.findById(id);

            if(optionalStudie.isPresent()) {
                return new ResponseEntity<Studie>(optionalStudie.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /*@Operation(summary = "Post Studie", description = "Post Studie", tags={"Studies"})
    @PostMapping(path = "/studies/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Studie> postStudie(@RequestBody Studie studie) {
        try{
            Studie optionalStudie = studieService.save(studie);

            return new ResponseEntity<Studie>(optionalStudie, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }*/

    @Operation(summary = "Update Studie", tags = {"Studies"})
    @PutMapping(path = "/studies/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Studie> updateStudieById(@PathVariable Long id, @RequestBody Studie studie) {
        try {
            return ResponseEntity.ok(studieService.update(id, studie));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @Operation(summary = "Delete Studie", tags = {"Studies"})
    @DeleteMapping(path = "/studies/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Studie> deleteStudieById(@PathVariable Long id) {
        try {
            studieService.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
