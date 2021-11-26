package pe.edu.upc.joboffersservice.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.springframework.web.client.RestTemplate;
import pe.edu.upc.joboffersservice.entities.JobOffer;

public class SearchJobOffersSteps {
    private final RestTemplate restTemplate = new RestTemplate();
    private String url = "http://localhost:8093/api/";
    private int numberElements;
    private int expectedNumberElements;

    @Given("the postulant wishes to search for job offers")
    public void thePostulantWishesToSearchForJobOffers() {
        url.concat("job-offers");
        numberElements = 0;
    }

    @Given("no job offers available")
    public void noJobOffersAvailable() {
        expectedNumberElements = 0;
    }

    @When("searches for these job offers")
    public void searchesForTheseJobOffers() {
        JobOffer[] jobOffers = restTemplate.getForObject(url + "job-offers", JobOffer[].class);
        numberElements = jobOffers != null ? jobOffers.length : -1;
    }

    @Then("the list of jobs offers is shown")
    public void theListOfJobsOffersIsShown() {
        Assertions.assertTrue(numberElements >= 0);
    }

    @Then("the list of jobs offers is shown without elements")
    public void theListOfJobsOffersIsShownWithoutElements() {
        assert(numberElements == expectedNumberElements);
    }
}
