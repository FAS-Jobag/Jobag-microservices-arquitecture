package gradle.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlanEmployer {

    private RestTemplate restTemplate = new RestTemplate();
    private String Mensaje = null;

    @Given("the employer is interested in purchasing a monthly plan")
    public void theEmployerIsInterestedInPurchasingAMonthlyPlan() {
        String url = "https://rcuencam.github.io/Jobag/";
        String enter = restTemplate.getForObject(url, String.class);
        assertTrue(!enter.isEmpty());
    }

    @When("You can find it in the “Subscriptions” section and select the option “Buy a plan” for a monthly plan")
    public void youCanFindItInTheSubscriptionsSectionAndSelectTheOptionBuyAPlanForAMonthlyPlan() {
        String url = "https://rcuencam.github.io/Jobag/#plans";
        String enter = restTemplate.getForObject(url, String.class);
        assertTrue(!enter.isEmpty());
    }

    @Then("the employer acquires the plan")
    public void theEmployerAcquiresThePlan() {
        String url = "https://rcuencam.github.io/Jobag/#plans";
        String enter = restTemplate.getForObject(url, String.class);
        try{
            assertTrue(!enter.isEmpty());
        }catch (RestClientException e){
            Mensaje = "Ya tiene un plan en vigencia";
            assertNotNull(Mensaje);
        }
    }

    @Given("the employer has a monthly plan")
    public void theEmployerHasAMonthlyPlan() {
        String url = "https://rcuencam.github.io/Jobag/#plans";
        String enter = restTemplate.getForObject(url, String.class);
        try{
            assertTrue(!enter.isEmpty());
        }catch (RestClientException e){
            Mensaje = "Ya tiene un plan en vigencia";
            assertNotNull(Mensaje);
        }
    }

    @When("You can find it in the {string} section and select the {string} option for a monthly plan")
    public void youCanFindItInTheSectionAndSelectTheOptionForAMonthlyPlan(String arg0, String arg1) {
        arg0 = "#plans";
        arg1 = "Mas informacion";

        String url = "https://rcuencam.github.io/Jobag/" + arg0;
        String enter = restTemplate.getForObject(url, String.class);
        try {
            String subsciption = url + arg1;
        }catch (RestClientException e){
            Mensaje = "Subripcion Premiun";
            assertNotNull(Mensaje);
        }
        assertTrue(!enter.isEmpty());
    }

    @Then("the employer acquires the new selected plan")
    public void theEmployerAcquiresTheNewSelectedPlan() {
        String url = "https://rcuencam.github.io/Jobag/#plans";
        String enter = restTemplate.getForObject(url, String.class);
        try{
            assertTrue(!enter.isEmpty());
        }catch (RestClientException e){
            Mensaje = "Felicidades por adquirir el nuevo plan";
            assertNotNull(Mensaje);
        }
    }
}
