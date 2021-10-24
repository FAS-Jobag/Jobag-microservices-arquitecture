package upc.edu.pe.postulantsservice.controllers;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.postulantsservice.services.SkillService;
import upc.edu.pe.postulantsservice.entity.Skill;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(name = "/skills")
public class SkillController {
    @Autowired
    private SkillService skillService;

    @Operation(summary = "All Skills", tags = {"Skills"})
    @GetMapping(path = "/skills", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Skill> getAllSkills() throws Exception {
        return skillService.findAll();
    }

    @Operation(summary = "Get Skill by ID", description = "Get Skill by ID", tags={"Skills"})
    @GetMapping(path = "/skills/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Skill> fetchById(@PathVariable("id") Long id) {
        try{
            Optional<Skill> optionalSkill = skillService.findById(id);

            if(optionalSkill.isPresent()) {
                return new ResponseEntity<Skill>(optionalSkill.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /*@Operation(summary = "Post Skill", description = "Post Skill", tags={"Skills"})
    @PostMapping(path = "/skills", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Skill> postSkill(@RequestBody Skill skill) {
        try{
            Skill optionalSkill = skillService.save(skill);

            return new ResponseEntity<Skill>(optionalSkill, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }*/

    @Operation(summary = "Update Skill", tags = {"Skills"})
    @PutMapping(path = "/skills/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Skill> updateSkillById(@PathVariable Long id, @RequestBody Skill skill) {
        try {
            return ResponseEntity.ok(skillService.update(id, skill));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @Operation(summary = "Delete Skill", tags = {"Skills"})
    @DeleteMapping(path = "/skills/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Skill> deleteSkillById(@PathVariable Long id) {
        try {
            skillService.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
