package pe.edu.upc.joboffersservice.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.joboffersservice.entities.Interview;
import pe.edu.upc.joboffersservice.services.InterviewService;

import java.util.Optional;

@RestController
@RequestMapping("api/interviews")
public class InterviewsController {
    @Autowired
    private InterviewService interviewService;

    @Operation(summary = "find interview by id", tags = {"interviews"})
    @ApiResponse(responseCode = "200", description = "this return a interview by id")
    @GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Interview> getById(@PathVariable Long id) {
        try {
            Optional<Interview> result = interviewService.findById(id);
            return result.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
