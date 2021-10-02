package com.jobag.postulationsservice.client;

import com.jobag.postulationsservice.model.JobOffer;
import org.springframework.http.ResponseEntity;

import java.util.Date;

public class JobOfferHystrixFallbackFactory implements JobOfferClient{
    @Override
    public ResponseEntity<JobOffer> getJobOffer(long id) {
        JobOffer jobOffer = JobOffer.builder()
                .name("none")
                .type("none")
                .salary(0.0)
                .description("none")
                .workplace("none")
                .date(new Date())
                .experience("none").build();

        return ResponseEntity.ok(jobOffer);

    }
}
