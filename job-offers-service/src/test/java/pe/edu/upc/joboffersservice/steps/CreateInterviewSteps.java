package pe.edu.upc.joboffersservice.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import pe.edu.upc.joboffersservice.entities.Interview;

import java.time.Instant;
import java.util.Date;

public class CreateInterviewSteps {
    private final RestTemplate restTemplate = new RestTemplate();
    private String basePath = "http://localhost:8093/api/";
    private String uri;

    Interview interview;

    @Given("the employer wants to create an interview")
    public void theEmployerWantsToCreateAnInterview() {
        uri = basePath + "job-offers/1/interviews";
    }

    @When("complete all data")
    public void completeAllData() {
        interview = new Interview();
        interview.setLink("link");
        interview.setPending(true);
        interview.setDuration(60.00);
        interview.setCreateAt(Date.from(Instant.now()));
        interview.setStatus("1");
    }

    @When("does not complete all data")
    public void doesNotCompleteAllData() {
        interview = new Interview();
        interview.setPending(true);
        interview.setDuration(60.00);
        interview.setCreateAt(Date.from(Instant.now()));
        interview.setStatus("1");
    }

    @Then("the interview is created")
    public void theInterviewIsCreated() {
        // restTemplate.postForObject(uri, interview, Interview.class);
        assert(interview != null);
    }

    @Then("the interview not is created")
    public void theInterviewNotIsCreated() {
        // restTemplate.postForObject(uri, interview, Interview.class);
        assert(interview == null);
    }
}
