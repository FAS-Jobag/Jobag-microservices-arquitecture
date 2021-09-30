package upc.edu.pe.projectgradle.controllers;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.projectgradle.entity.Postulant;
import upc.edu.pe.projectgradle.services.PostulantService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(name = "/postulants")
public class PostulantController {

    @Autowired
    private PostulantService postulantService;
    
    @Operation(summary = "Get postulant by ID", description = "Get postulant by ID", tags={"Postulants"})
    @GetMapping(path = "/postulants/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Postulant> fetchById(@PathVariable("id") Long id) {
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


}
