package pe.edu.upc.joboffersservice.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.joboffersservice.entities.Contract;
import pe.edu.upc.joboffersservice.entities.JobOffer;
import pe.edu.upc.joboffersservice.services.ContractService;
import pe.edu.upc.joboffersservice.services.JobOfferService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/contracts")
public class ContractsController {
    @Autowired
    private ContractService contractService;

    @Operation(summary = "find contract by id", tags = {"contracts"})
    @ApiResponse(responseCode = "200", description = "this return a contract by id")
    @GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Contract> getById(@PathVariable Long id) {
        try {
            Optional<Contract> result = contractService.findById(id);
            return result.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @Operation(summary = "update a contract for id", tags = {"contracts"})
    @ApiResponse(responseCode = "200", description = "this return the contract updated")
    @PutMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Contract> update(@PathVariable Long id, @RequestBody Contract contract) {
        try {
            return ResponseEntity.ok(contractService.update(id, contract));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @Operation(summary = "delete a contract for id", tags = {"contracts"})
    @ApiResponse(responseCode = "200", description = "It returns ok or internal server error")
    @DeleteMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JobOffer> deleteById(@PathVariable Long id) {
        try {
            contractService.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
