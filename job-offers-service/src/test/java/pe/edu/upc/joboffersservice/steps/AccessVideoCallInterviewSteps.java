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
    private String url = "http://localhost:8093/api/";

    private int numberElements;

    @Given("the postulant wants see the interviews of a job offer")
    public void thePostulantWantsSeeTheInterviewsOfAJobOffer() {
        url.concat("job-offers/1/interviews");
    }

    @When("searches the interviews associated to job offer")
    public void searchesTheInterviewsAssociatedToJobOffer() {
        Interview[] interviews = restTemplate.getForObject(url, Interview[].class);
        numberElements = interviews.length;
    }

    @Then("the list of interviews is shown")
    public void theListOfInterviewsIsShown() {
        Assertions.assertTrue(numberElements >= 0);
    }

    @And("the job offer does not have interviews")
    public void theJobOfferDoesNotHaveInterviews() {
        Interview[] interviews = restTemplate.getForObject(url, Interview[].class);
        numberElements = interviews.length;
    }

    @Then("the list of interviews is shown without elements")
    public void theListOfInterviewsIsShownWithoutElements() {
        Assertions.assertEquals(0, numberElements);
    }
}
