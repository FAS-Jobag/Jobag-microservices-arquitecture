package upc.edu.pe.projectgradle.controllers;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.projectgradle.entity.Postulant;
import upc.edu.pe.projectgradle.entity.ProfessionalProfile;
import upc.edu.pe.projectgradle.services.PostulantService;
import upc.edu.pe.projectgradle.services.ProfessionalProfileService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(name = "/postulants")
public class PostulantController {

    @Autowired
    private PostulantService postulantService;

    @Autowired
    private ProfessionalProfileService professionalProfileService;


    @Operation(summary = "All Postulants", tags = {"Postulants"})
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Postulant> getAllPostulants() throws Exception {
        return postulantService.findAll();
    }

    @Operation(summary = "Get postulant by ID", description = "Get postulant by ID", tags={"Postulants"})
    @GetMapping(path = "/postulants/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Postulant> fetchPostulantById(@PathVariable("id") Long id) {
        try{
            Optional<Postulant> optionalPostulant = postulantService.findById(id);

            if(optionalPostulant.isPresent()) {
                return new ResponseEntity<Postulant>(optionalPostulant.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "Post postulant", description = "Post postulant", tags={"Postulants"})
    @PostMapping(path = "/postulants", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Postulant> postPostulant(@RequestBody Postulant postulant) {
        try{
            Postulant optionalPostulant = postulantService.save(postulant);

            return new ResponseEntity<Postulant>(optionalPostulant, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "Update Postulant", tags = {"Postulants"})
    @PutMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Postulant> updatePostulantById(@PathVariable Long id, @RequestBody Postulant postulant) {
        try {
            return ResponseEntity.ok(postulantService.update(id, postulant));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @Operation(summary = "Delete Postulant", tags = {"Postulants"})
    @DeleteMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Postulant> deletePostulantById(@PathVariable Long id) {
        try {
            postulantService.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @Operation(summary = "save a Professional Profile of a Postulant", tags = {"Professional Profiles"})
    @PostMapping(path = "/postulants/{postulantId}/professional_profile", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProfessionalProfile> createProfessionalProfile(@PathVariable Long postulantId, @RequestBody ProfessionalProfile professionalProfile) {
        try {
            return ResponseEntity.ok(professionalProfileService.saveByPostulantId(postulantId, professionalProfile));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }


}
