package upc.edu.pe.postulantsservice.controllers;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.postulantsservice.models.User;
import upc.edu.pe.postulantsservice.services.PostulantService;
import upc.edu.pe.postulantsservice.services.ProfessionalProfileService;
import upc.edu.pe.postulantsservice.entity.Postulant;
import upc.edu.pe.postulantsservice.entity.ProfessionalProfile;

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
    @GetMapping(path = "/postulants", produces = MediaType.APPLICATION_JSON_VALUE)
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
    @PutMapping(path = "/postulants/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Postulant> updatePostulantById(@PathVariable Long id, @RequestBody Postulant postulant) {
        try {
            return ResponseEntity.ok(postulantService.update(id, postulant));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @Operation(summary = "Delete Postulant", tags = {"Postulants"})
    @DeleteMapping(path = "/postulants/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
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

    @Operation(summary = "Authenticate postulant by email and password", description = "Get postulant by email and password", tags={"Postulants"})
    @PostMapping(path = "/postulants/login", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Postulant> authenticatePostulant(@RequestBody User user) {
        try{
            Postulant postulant = postulantService.findByEmailAndPassword(user.email,user.password);

            if(postulant != null) {
                return ResponseEntity.ok(postulant);
                //return new ResponseEntity<Postulant>(postulant, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}