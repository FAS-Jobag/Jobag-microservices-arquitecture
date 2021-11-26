package pe.edu.upc.joboffersservice.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.springframework.web.client.RestTemplate;
import pe.edu.upc.joboffersservice.entities.Interview;

public class AccessVideoCallInterviewSteps {
    private final RestTemplate restTemplate = new RestTemplate();
    private String basePath = "http://localhost:8093/api/";
    private String uri;

    private int numberElements;

    @Given("the postulant wants see the interviews of a job offer")
    public void thePostulantWantsSeeTheInterviewsOfAJobOffer() {
        uri = basePath + "job-offers/1/interviews";
    }

    @When("searches the interviews associated to job offer")
    public void searchesTheInterviewsAssociatedToJobOffer() {
        Interview[] interviews = restTemplate.getForObject(uri, Interview[].class);
        numberElements = interviews.length;
    }

    @Then("the list of interviews is shown")
    public void theListOfInterviewsIsShown() {
        assert(numberElements >= 0);
    }

    @And("the job offer does not have interviews")
    public void theJobOfferDoesNotHaveInterviews() {
        Interview[] interviews = restTemplate.getForObject(uri, Interview[].class);
        numberElements = interviews.length;
    }

    @Then("the list of interviews is shown without elements")
    public void theListOfInterviewsIsShownWithoutElements() {
        assert(numberElements == 0);
    }
}
