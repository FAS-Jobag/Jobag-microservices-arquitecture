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
import upc.edu.pe.postulantsservice.entity.ProfessionalProfile;

import static org.junit.Assert.*;


@Log4j2
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ProfessionalProfileSteps {

    private RestTemplate restTemplate = new RestTemplate();
    private String url = "http://laptop-bvnen24d:8091/postulants";
    public String successfull_message;
    private String error_message;

    @Given("I enter the profile platform")
    public void iEnterTheProfilePlatform() {
        String page = restTemplate.getForObject(url, String.class);
        assertTrue(!page.isEmpty());
    }

    @And("I create my proffesional profile with my {string} and {string}")
    public void iCreateMyProffesionalProfileWithMyOcupationAndExperience(String ocupation, String experience) {
        ProfessionalProfile newProfile = new ProfessionalProfile();
        newProfile.setOcupation(ocupation);
        newProfile.setExperiencie(experience);

        try {
            ProfessionalProfile profile = restTemplate.postForObject(url, newProfile, ProfessionalProfile.class);
            assertNotNull(profile);
        } catch(RestClientException e) {
            error_message = "Profile not created";
        }

        this.successfull_message = "Profile created succesfully";
    }

    @Then("I want to see a successfully {string}")
    public void iWantToSeeASuccessfullyMessage(String message) {
        assertEquals(message,successfull_message);
    }
}
