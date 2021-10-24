package upc.edu.pe.postulantsservice.controllers;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.postulantsservice.services.LanguageService;
import upc.edu.pe.postulantsservice.entity.Language;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(name = "/languages")
public class LanguageController {
    @Autowired
    private LanguageService languageService;

    @Operation(summary = "All Languages", tags = {"Languages"})
    @GetMapping(path="/languages", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Language> getAllLanguages() throws Exception {
        return languageService.findAll();
    }

    @Operation(summary = "Get Language by ID", description = "Get Language by ID", tags={"Languages"})
    @GetMapping(path = "/languages/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Language> fetchLanguagesById(@PathVariable("id") Long id) {
        try{
            Optional<Language> optionalLanguage = languageService.findById(id);

            if(optionalLanguage.isPresent()) {
                return new ResponseEntity<Language>(optionalLanguage.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /*@Operation(summary = "Post Language", description = "Post Language", tags={"Languages"})
    @PostMapping(path = "/languages", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Language> postLanguage(@RequestBody Language language) {
        try{
            Language optionalLanguage = languageService.save(language);

            return new ResponseEntity<Language>(optionalLanguage, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }*/

    @Operation(summary = "Update Language", tags = {"Languages"})
    @PutMapping(path = "/languages/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Language> updateLanguageById(@PathVariable Long id, @RequestBody Language language) {
        try {
            return ResponseEntity.ok(languageService.update(id, language));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @Operation(summary = "Delete Language", tags = {"Languages"})
    @DeleteMapping(path = "/languages/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Language> deleteLanguageById(@PathVariable Long id) {
        try {
            languageService.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
