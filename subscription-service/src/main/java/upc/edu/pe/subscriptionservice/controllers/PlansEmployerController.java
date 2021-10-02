package upc.edu.pe.subscriptionservice.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import upc.edu.pe.subscriptionservice.entities.PlanEmployer;
import upc.edu.pe.subscriptionservice.services.PlansEmployerService;

/**
* PlansEmployerController
*/
@RestController
@RequestMapping("/plans_employers")
public class PlansEmployerController {
	@Autowired
	private PlansEmployerService plansEmployerService;

	@GetMapping(path = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
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

	@PostMapping(path = "/plan", produces = MediaType.APPLICATION_JSON_VALUE)
	public PlanEmployer createEmployer() throws Exception{
	}
}
