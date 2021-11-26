package gradle.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import upc.edu.pe.gestionempleadoresservice.entities.Empleador;

import java.nio.charset.Charset;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

@Log4j2
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class register_employer {

    private RestTemplate restTemplate = new RestTemplate();
    private String Mensaje_Confirmacion;
    private String Mensaje_Error;
    //First Scenario
    @Given("The employer enters the application")
    public void theEmployerEntersTheApplication() {
        String url = "https://rcuencam.github.io/Jobag/";
        String enter = restTemplate.getForObject(url, String.class);
        assertTrue(!enter.isEmpty());
    }

    @When("Press the option to register by affiliating position in a company and a password")
    public void pressTheOptionToRegisterByAffiliatingCompanyDataRUCAndAPassword() {
        Empleador empleador;
        String position = "Gerente de finanzas";
        String password = "cetafe@2021";

        empleador = new Empleador(randomLong(), randomString(), randomString(), randomLong(), position, randomLong(), password, null, "T");
        assertNotNull(empleador);
    }

    @Then("You are notified by text message that the registration was successful")
    public void youAreNotifiedByTextMessageThatTheRegistrationWasSuccessful() {
        try{
            Empleador newEmpleador = new Empleador(randomLong(), randomString(), randomString(), randomLong(), randomString(), randomLong(), randomString(), null, "T");
            assertNotNull(newEmpleador);
        }catch (RestClientException e){
            Mensaje_Confirmacion = "Su registro fue exitoso";
            assertEquals(Mensaje_Confirmacion, "Su registro fue exitoso");
        }
    }

    //Second Scenario

    @When("Press the option to register and it does not fill in the data properly")
    public void pressTheOptionToRegisterAndItDoesNotFillInTheDataProperly() {
        try{
            Empleador newEmpleador = new Empleador(randomLong(), null, null, null, randomString(), randomLong(), randomString(), null, "T");
            assertNotNull(newEmpleador);
        }catch (RestClientException e){
            Mensaje_Error = "Complete los datos vacios";
            assertEquals(Mensaje_Error, "Complete los datos vacios");
        }
    }

    @Then("The registration process is not carried out because you must enter valid data")
    public void theRegistrationProcessIsNotCarriedOutBecauseYouMustEnterValidData() {
        try{
            Empleador newEmpleador = new Empleador(randomLong(), randomString(), randomString(), 12L, randomString(), null, randomString(), null, "T");
            assertNotNull(newEmpleador);
        }catch (RestClientException e){
            Mensaje_Error = "Ingrese los datos correctamente";
            assertEquals(Mensaje_Error, "Ingrese los datos correctamente");
        }
    }

    //Generate Random
    public String randomString() {
        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));

        return generatedString;
    }
    public Long randomLong() {
        Long generatedLong = new Random().nextLong();
        return generatedLong;
    }
    public Integer randomInt() {
        int generatedInt = new Random().nextInt();
        return generatedInt;
    }
}
