package pe.edu.upc.joboffersservice.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.joboffersservice.entities.Contract;
import pe.edu.upc.joboffersservice.entities.Employeer;
import pe.edu.upc.joboffersservice.entities.Interview;
import pe.edu.upc.joboffersservice.entities.JobOffer;
import pe.edu.upc.joboffersservice.services.ContractService;
import pe.edu.upc.joboffersservice.services.InterviewService;
import pe.edu.upc.joboffersservice.services.JobOfferService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/job-offers")
public class JobOffersController {
    @Autowired
    private JobOfferService jobOfferService;
    @Autowired
    private ContractService contractService;
    @Autowired
    private InterviewService interviewService;

    @Operation(summary = "find all job offer", tags = {"job-offers"})
    @ApiResponse(responseCode = "200", description = "this return a list of job offers")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<JobOffer> getAll() throws Exception {
        return jobOfferService.findAll();
    }

    @Operation(summary = "find job offer by id", tags = {"job-offers"})
    @ApiResponse(responseCode = "200", description = "this return a job offer by id")
    @GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JobOffer> getById(@PathVariable Long id) {
        try {
            Optional<JobOffer> result = jobOfferService.findById(id);
            return result.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    /*@Operation(summary = "save a job offer", tags = {"job-offers"})
    @ApiResponse(responseCode = "200", description = "this return the job offer saved")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JobOffer> save(@RequestBody JobOffer jobOffer) {
        try {
            return ResponseEntity.ok(jobOfferService.save(jobOffer));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }*/

    @Operation(summary = "update a job offer for id", tags = {"job-offers"})
    @ApiResponse(responseCode = "200", description = "this return the job offer updated")
    @PutMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JobOffer> update(@PathVariable Long id, @RequestBody JobOffer jobOffer) {
        try {
            return ResponseEntity.ok(jobOfferService.update(id, jobOffer));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @Operation(summary = "delete a job offer for id", tags = {"job-offers"})
    @ApiResponse(responseCode = "200", description = "It returns ok or internal server error")
    @DeleteMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JobOffer> deleteById(@PathVariable Long id) {
        try {
            jobOfferService.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    /* *
     * Relationships
     */

    // Relationship between Job Offers and Contracts

    @Operation(summary = "find all contracts by job offer id", tags = {"job-offers-contracts"})
    @ApiResponse(responseCode = "200", description = "this return a list of contracts of a job offer")
    @GetMapping(path = "{jobOfferId}/contracts", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Contract> getAllContractsByOfferId(@PathVariable Long jobOfferId) throws Exception {
        return contractService.findByJobOfferId(jobOfferId);
    }

    @Operation(summary = "save a contract of a job offer", tags = {"job-offers-contracts"})
    @ApiResponse(responseCode = "200", description = "this return the contract saved")
    @PostMapping(path = "{jobOfferId}/contracts", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Contract> createContract(@PathVariable Long jobOfferId, @RequestBody Contract contract) {
        try {
            return ResponseEntity.ok(contractService.saveByJobOfferId(jobOfferId, contract));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    // relationship between Job Offers and interviews

    @Operation(summary = "find all interviews by job offer id", tags = {"job-offers-interviews"})
    @ApiResponse(responseCode = "200", description = "this return a list of interviews of a job offer")
    @GetMapping(path = "{jobOfferId}/interviews", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Interview> getAllInterviewsByOfferId(@PathVariable Long jobOfferId) throws Exception {
        return interviewService.findByJobOfferId(jobOfferId);
    }

    @Operation(summary = "save an interview of a job offer", tags = {"job-offers-interviews"})
    @ApiResponse(responseCode = "200", description = "this return the interview saved")
    @PostMapping(path = "{jobOfferId}/interviews", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Interview> createInterview(@PathVariable Long jobOfferId, @RequestBody Interview interview) {
        try {
            return ResponseEntity.ok(interviewService.saveByJobOfferId(jobOfferId, interview));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }


    @Operation(summary = "save a job offer by Employeer ID", tags = {"job-offers"})
    @ApiResponse(responseCode = "200", description = "this return the job offer saved by Employeer ID")
    @PostMapping(path="/employeer/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JobOffer> saveByEmployeerId(@PathVariable Long id, @RequestBody JobOffer jobOffer) {

        JobOffer newJobOffer = jobOfferService.createJobOfferByEmployeerId(id, jobOffer);
        System.out.println(newJobOffer);

        try{


            if(newJobOffer.getEmployeerId() != 0) {
                return ResponseEntity.ok(newJobOffer);
            }else {
                return ResponseEntity.badRequest().build();
            }

        }catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

}
