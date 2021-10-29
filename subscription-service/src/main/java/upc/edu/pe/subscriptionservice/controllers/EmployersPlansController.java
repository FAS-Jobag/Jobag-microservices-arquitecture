package upc.edu.pe.subscriptionservice.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.subscriptionservice.entities.EmployersPlans;
import upc.edu.pe.subscriptionservice.services.EmployersPlansService;

/**
* EmployersPlansController
*/
@RestController
@RequestMapping("employers/{employerId}")
public class EmployersPlansController {
    @Autowired
    private EmployersPlansService employersPlansService;

    @Operation(summary = "Assign subscription to employer", tags = {"Employer-Plans"})
    @ApiResponse(responseCode = "200", description = "this return employers plans")
    @PutMapping(path = "/subscriptions/{subscriptionId}")
    public ResponseEntity<EmployersPlans> assignSubscriptionToEmployer
            (@PathVariable Long employerId, @PathVariable Long subscriptionId) {

        try {
            EmployersPlans result = employersPlansService.assignSubscriptionToEmployer(subscriptionId, employerId);
            if (result != null) {
                return ResponseEntity.ok(result);
            }
            else return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @Operation(summary = "Unassign subscription to employer", tags = {"Employer-Plans"})
    @ApiResponse(responseCode = "200", description = "this return code 200 or code 500")
    @DeleteMapping(path = "/subscriptions/{subscriptionId}")
    public ResponseEntity<?> unassignSubscriptionToEmployer
            (@PathVariable Long employerId, @PathVariable Long subscriptionId) {

        try {
            employersPlansService.unassignSubscriptionToEmployer(subscriptionId, employerId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @Operation(summary = "Get plan by employer id", tags = {"Employer-Plans"})
    @ApiResponse(responseCode = "200", description = "this return employers plans")
    @GetMapping(path = "/subscriptions")
    public ResponseEntity<?> getPlanByEmployerId(@PathVariable Long employerId) {
        try {
            EmployersPlans plan = employersPlansService.getPlanByEmployerId(employerId);
            return ResponseEntity.ok(plan);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
	
}
