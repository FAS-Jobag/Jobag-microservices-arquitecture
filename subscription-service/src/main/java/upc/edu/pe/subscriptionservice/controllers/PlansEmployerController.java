package upc.edu.pe.subscriptionservice.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import upc.edu.pe.subscriptionservice.entities.PlanEmployer;
import upc.edu.pe.subscriptionservice.services.PlansEmployerService;

/**
* PlansEmployerController
*/
@RestController
@RequestMapping("/subscriptions")
public class PlansEmployerController {
	@Autowired
	private PlansEmployerService plansEmployerService;

	@Operation(summary = "Find plan for employer", description = "Find plan for employers by id", tags = {"plans_employer"})
	@ApiResponses( value = {
		@ApiResponse(responseCode = "200", description = "Find plan", content = @Content(mediaType = "application/json"))
	})
	@GetMapping(path = "/id/{id}/employers", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PlanEmployer> fetchById(@PathVariable("id") Long id){
		try {
			Optional<PlanEmployer> optionalPlanEmployer = plansEmployerService.findById(id);
			if(optionalPlanEmployer.isPresent()){
				return new ResponseEntity<PlanEmployer>(optionalPlanEmployer.get(),HttpStatus.OK);

			}else{
				return new ResponseEntity<PlanEmployer>(HttpStatus.NOT_FOUND);
			}
		} catch(Exception e){
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Operation(summary = "Create plan for employer", description = "Create Plan for employer", tags = {"plans_employer"})
	@ApiResponses( value = {
		@ApiResponse(responseCode = "200", description = "Created plan", content = @Content(mediaType = "application/json"))
	})
	@PostMapping(path = "/employers", produces = MediaType.APPLICATION_JSON_VALUE)
	public PlanEmployer createEmployer(@RequestBody PlanEmployer entity) throws Exception{
		PlanEmployer plan = entity;
		return plansEmployerService.save(plan);
	}

	@Operation(summary = "Delete plan for employer", description = "Delete plan for Employer", tags = {"plans_employer"})
	@ApiResponses( value = {
		@ApiResponse(responseCode = "200", description = "Deleted plan", content = @Content(mediaType = "application/json"))
	})
	@DeleteMapping(path = "/id/{id}/employers", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PlanEmployer> deleteById(@PathVariable("id") Long id){
		try {
			Optional<PlanEmployer> optionalPlanEmployer = plansEmployerService.findById(id);
			if(optionalPlanEmployer.isPresent()){
				plansEmployerService.deleteById(id);
				return new ResponseEntity<PlanEmployer>(optionalPlanEmployer.get(),HttpStatus.OK);
			}else{
				return new ResponseEntity<PlanEmployer>(HttpStatus.NOT_FOUND);
			}
		} catch(Exception e){
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Operation(summary = "List all Plans for employers", description = "List all plans available for employers", tags = {"plans_employer"})
	@ApiResponses( value = {
		@ApiResponse(responseCode = "200", description = "Listed plans", content = @Content(mediaType = "application/json"))
	})
	@GetMapping(path = "/employers", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<PlanEmployer>> fetchAllEntity(){
		try {
			List<PlanEmployer> optionalPlansEmployers = plansEmployerService.findAll();
			if(!optionalPlansEmployers.isEmpty()){
				return new ResponseEntity<List<PlanEmployer>>(optionalPlansEmployers, HttpStatus.OK);
			}else{
				return new ResponseEntity<List<PlanEmployer>>(HttpStatus.NOT_FOUND);
			}
		} catch(Exception e){
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
