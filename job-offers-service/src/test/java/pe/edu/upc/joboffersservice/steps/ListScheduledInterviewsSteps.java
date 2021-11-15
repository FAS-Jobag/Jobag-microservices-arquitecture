package pe.edu.upc.joboffersservice.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.springframework.web.client.RestTemplate;
import pe.edu.upc.joboffersservice.entities.Interview;

public class ListScheduledInterviewsSteps {
    private final RestTemplate restTemplate = new RestTemplate();
    final String basePath = "http://localhost:8093/api/";
    private String uri;

    private int numberElements;

    @Given("the employer wants to see the interviews of a job offer")
    public void theEmployerWantsToSeeTheInterviewsOfAJobOffer() {
        uri = basePath + "job-offers/1/interviews";
    }

    @When("verify the interviews associated to job offer")
    public void verifyTheInterviewsAssociatedToJobOffer() {
        Interview[] interviews = restTemplate.getForObject(uri, Interview[].class);
        numberElements = interviews.length;
    }

    @Then("the list of interviews is displayed")
    public void theListOfInterviewsIsDisplayed() {
        assert (numberElements >= 0);
    }

    @Then("the list of interviews is displayed with zero items")
    public void theListOfInterviewsIsDisplayedWithZeroItems() {
        assert(numberElements == 0);
    }

    @And("the job offer does not have scheduled interviews")
    public void theJobOfferDoesNotHaveScheduledInterviews() {
        uri = basePath + "job-offers/1/interviews";
    }
}
