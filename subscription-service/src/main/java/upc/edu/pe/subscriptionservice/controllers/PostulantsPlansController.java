package upc.edu.pe.subscriptionservice.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.subscriptionservice.entities.PlanPostulant;
import upc.edu.pe.subscriptionservice.entities.PostulantsPlans;
import upc.edu.pe.subscriptionservice.services.PostulantsPlansService;

/**
* PostulantsPlansController
*/
@RestController
@RequestMapping("postulants/{postulantId}")
public class PostulantsPlansController {
    @Autowired
    private PostulantsPlansService postulantsPlansService;

    @Operation(summary = "Assign subscription to postulant", tags = {"Postulants-Plans"})
    @ApiResponse(responseCode = "200", description = "this return postulants plans")
    @PutMapping(path = "/subscriptions/{subscriptionId}")
    public ResponseEntity<PostulantsPlans> assignSubscriptionToPostulant
            (@PathVariable Long postulantId, @PathVariable Long subscriptionId) {

        try {
            PostulantsPlans result = postulantsPlansService.assignSubscriptionToPostulant(subscriptionId, postulantId);
            if (result != null) {
                return ResponseEntity.ok(result);
            }
            else return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @Operation(summary = "Unassign subscription to postulant", tags = {"Postulants-Plans"})
    @ApiResponse(responseCode = "200", description = "this return code 200 or code 500")
    @DeleteMapping(path = "/subscriptions/{subscriptionId}")
    public ResponseEntity<?> unassignSubscriptionToPostulant
            (@PathVariable Long postulantId, @PathVariable Long subscriptionId) {

        try {
            postulantsPlansService.unassignSubscriptionToPostulant(subscriptionId, postulantId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @Operation(summary = "Get plan by postulant id", tags = {"Postulants-Plans"})
    @ApiResponse(responseCode = "200", description = "this return Postulants plans")
    @GetMapping(path = "/subscriptions")
    public ResponseEntity<?> getPlanByPostulantId(@PathVariable Long postulantId) {
        try {
            PostulantsPlans plan = postulantsPlansService.getPlanByPostulantId(postulantId);
            return ResponseEntity.ok(plan);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
