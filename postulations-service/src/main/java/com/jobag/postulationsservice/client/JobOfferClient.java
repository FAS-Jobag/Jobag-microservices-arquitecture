package com.jobag.postulationsservice.client;

import com.jobag.postulationsservice.model.JobOffer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "job-offers-service", fallback = JobOfferHystrixFallbackFactory.class)

public interface JobOfferClient {
    @GetMapping(value = "/job-offers/{id}")
    public ResponseEntity<JobOffer> getJobOffer(@PathVariable("id") long id);
}
