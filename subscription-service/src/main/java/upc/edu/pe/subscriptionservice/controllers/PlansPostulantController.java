package upc.edu.pe.subscriptionservice.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import upc.edu.pe.subscriptionservice.entities.PlanPostulant;
import upc.edu.pe.subscriptionservice.services.PlansPostulantService;

/**
* PlansPostulantController
*/
@RestController
@RequestMapping(name = "/plans_postulant")
public class PlansPostulantController {

	@Autowired
	private PlansPostulantService plansPostulantService;

	@Operation(summary = "Find plan postulant", description = "find plan postulant by id", tags = {"plans_postulant"})
	@ApiResponses( value = {
		@ApiResponse(responseCode = "200", description = "Plan encontrado", content = @Content(mediaType = "application/json"))
	})
	@GetMapping(path = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PlanPostulant> fetchById( @PathVariable("id") Long id){
		try {
			Optional<PlanPostulant> optionalPlanPostulant = plansPostulantService.findById(id);
			if (optionalPlanPostulant.isPresent()){
				return new ResponseEntity<PlanPostulant>(optionalPlanPostulant.get(),HttpStatus.OK);
			}else{
				return new ResponseEntity<PlanPostulant>(HttpStatus.NOT_FOUND);
			}
			
		} catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/plan")
	public PlanPostulant createPlan (@RequestBody PlanPostulant entity) throws Exception{
			PlanPostulant plan = entity;
			return plansPostulantService.save(plan);
	}

	@DeleteMapping("/plan/id/{id}")
	public ResponseEntity<PlanPostulant> deleteById(@PathVariable("id") Long id){
		try {
			Optional<PlanPostulant>optionalPlanPostulant = plansPostulantService.findById(id);
			if (optionalPlanPostulant.isPresent()){
				plansPostulantService.deleteById(id);
				return new ResponseEntity<PlanPostulant>(optionalPlanPostulant.get(),HttpStatus.OK);
			}else{
				return new ResponseEntity<PlanPostulant>(HttpStatus.NOT_FOUND);
			}
		} catch(Exception e){
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/plans")
	public ResponseEntity<List<PlanPostulant>> fetchAllEntity(){
		try {
			List<PlanPostulant> optionalPlansPostulant = plansPostulantService.findAll();
			if(!optionalPlansPostulant.isEmpty()){
				return new ResponseEntity<List<PlanPostulant>>(optionalPlansPostulant,HttpStatus.OK);
			}else{
				return new ResponseEntity<List<PlanPostulant>>(HttpStatus.NOT_FOUND);
			}
		} catch(Exception e){
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
