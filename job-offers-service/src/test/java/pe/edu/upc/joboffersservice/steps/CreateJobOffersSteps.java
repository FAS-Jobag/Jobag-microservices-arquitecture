package pe.edu.upc.joboffersservice.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.springframework.web.client.RestTemplate;
import pe.edu.upc.joboffersservice.entities.JobOffer;

import java.time.Instant;
import java.util.Date;

public class CreateJobOffersSteps {
    private final RestTemplate restTemplate = new RestTemplate();
    private String basePath = "http://localhost:8093/api/";
    private String uri;
    private int elements;

    JobOffer jobOffer;

    @Given("the employer wants to publish a job offer")
    public void theEmployerWantsToPublishAJobOffer() {
        uri = basePath + "job-offers/employeer/1";
    }

    @When("publishes his job offer")
    public void publishesHisJobOffer() {
        jobOffer = new JobOffer();
        jobOffer.setName("Jhon");
        jobOffer.setType("type");
        jobOffer.setSalary(1000.00);
        jobOffer.setDescription("description");
        jobOffer.setWorkplace("work place");
        jobOffer.setDate(Date.from(Instant.now()));
        jobOffer.setExperience("experience");
        jobOffer.setCreateAt(Date.from(Instant.now()));
        jobOffer.setStatus("1");
    }

    @Then("the job offer is associated with the employer")
    public void theJobOfferIsAssociatedWithTheEmployer() {
        JobOffer[] response = restTemplate.getForObject(uri, JobOffer[].class);
    }

    @Given("the employer created a job offer")
    public void theEmployerCreatedAJobOffer() {
        uri = basePath + "job-offers/employeer/1";
    }

    @When("consults the job offers that he has created")
    public void consultsTheJobOffersThatHeHasCreated() {
        JobOffer[] response = restTemplate.getForObject(uri, JobOffer[].class);
        elements = response.length;
    }

    @Then("his list of job offers is displayed")
    public void hisListOfJobOffersIsDisplayed() {
        Assertions.assertTrue(elements >= 0);
    }
}
