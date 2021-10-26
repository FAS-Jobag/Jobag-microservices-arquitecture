package upc.edu.pe.postulantsservice.controllers;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.postulantsservice.entity.Studie;
import upc.edu.pe.postulantsservice.services.LanguageService;
import upc.edu.pe.postulantsservice.services.ProfessionalProfileService;
import upc.edu.pe.postulantsservice.services.SkillService;
import upc.edu.pe.postulantsservice.services.StudieService;
import upc.edu.pe.postulantsservice.entity.Language;
import upc.edu.pe.postulantsservice.entity.ProfessionalProfile;
import upc.edu.pe.postulantsservice.entity.Skill;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(name = "/professional_profile")
public class ProfessionalProfileController {
    @Autowired
    private ProfessionalProfileService professionalProfileService;

    @Autowired
    private LanguageService languageService;

    @Autowired
    private SkillService skillService;

    @Autowired
    private StudieService studieService;

    @Operation(summary = "All Professional Profiles", tags = {"Professional Profiles"})
    @GetMapping(path = "/professional_profiles", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProfessionalProfile> getAllProfessionalProfiles() throws Exception {
        return professionalProfileService.findAll();
    }

    @Operation(summary = "Get Professional Profile by ID", description = "Get Professional Profile by ID", tags={"Professional Profiles"})
    @GetMapping(path = "/professional_profile/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProfessionalProfile> fetchProfessionalProfileById(@PathVariable("id") Long id) {
        try{
            Optional<ProfessionalProfile> optionalProfessionalProfile = professionalProfileService.findById(id);

            if(optionalProfessionalProfile.isPresent()) {
                return new ResponseEntity<ProfessionalProfile>(optionalProfessionalProfile.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /*@Operation(summary = "Post Professional Profile", description = "Post Professional Profile", tags={"Professional Profiles"})
    @PostMapping(path = "/professional_profile", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProfessionalProfile> postProfessionalProfile(@RequestBody ProfessionalProfile professionalProfile) {
        try{
            ProfessionalProfile optionalProfessionalProfile = professionalProfileService.save(professionalProfile);

            return new ResponseEntity<ProfessionalProfile>(optionalProfessionalProfile, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }*/

    @Operation(summary = "Update Professional Profile", tags = {"Professional Profiles"})
    @PutMapping(path = "/professional_profile/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProfessionalProfile> updateProfessionalProfileById(@PathVariable Long id, @RequestBody ProfessionalProfile professionalProfile) {
        try {
            return ResponseEntity.ok(professionalProfileService.update(id, professionalProfile));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @Operation(summary = "Delete Professional Profile", tags = {"Professional Profiles"})
    @DeleteMapping(path = "/professional_profile/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProfessionalProfile> deleteProfessionalProfileById(@PathVariable Long id) {
        try {
            professionalProfileService.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @Operation(summary = "save a Language of a ProfessionalProfileId", tags = {"Professional Profiles"})
    @PostMapping(path = "/professional_profile/{id}/languages", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Language> createLanguage(@PathVariable Long id, @RequestBody Language language) {
        try {
            return ResponseEntity.ok(languageService.saveLanguageByProfessionalProfileId(id, language));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @Operation(summary = "save a Skill of a ProfessionalProfileId", tags = {"Professional Profiles"})
    @PostMapping(path = "/professional_profile/{id}/skills", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Skill> createSkill(@PathVariable Long id, @RequestBody Skill skill) {
        try {
            return ResponseEntity.ok(skillService.saveSkillByProfessionalProfileId(id, skill));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @Operation(summary = "save a Studie of a ProfessionalProfileId", tags = {"Professional Profiles"})
    @PostMapping(path = "/professional_profile/{id}/studies", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Studie> createStudie(@PathVariable Long id, @RequestBody Studie studie) {
        try {
            return ResponseEntity.ok(studieService.saveStudieByProfessionalProfileI(id, studie));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
