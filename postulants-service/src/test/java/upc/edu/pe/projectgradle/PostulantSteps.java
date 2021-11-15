package upc.edu.pe.projectgradle;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lombok.extern.log4j.Log4j2;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import upc.edu.pe.postulantsservice.entity.Postulant;

import static org.junit.Assert.*;

@Log4j2
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class PostulantSteps {
    private RestTemplate restTemplate = new RestTemplate();
    private String url = "http://laptop-bvnen24d:8091/postulants";
    public String successfull_message;
    private String error_message;


    @Given("I enter the registration platform")
    public void i_enter_the_registration_platform() {
        String page = restTemplate.getForObject(url, String.class);
        assertTrue(!page.isEmpty());
    }

    @And("I create my postulant profile with my {string}")
    public void iCreateMyPostulantProfileWithMyEmail(String email) {
        Postulant newPostulant = new Postulant();
        newPostulant.setEmail(email);

        try {
            Postulant postulant = restTemplate.postForObject(url, newPostulant, Postulant.class);
            assertNotNull(postulant);
        } catch(RestClientException e) {
            error_message = "Account not created";
        }

        this.successfull_message = "Account create successfully";
    }

    @Then("I want to see a successfull {string}")
    public void i_want_to_see_a_successfull(String string) {
        assertEquals(string,successfull_message);
    }
}
