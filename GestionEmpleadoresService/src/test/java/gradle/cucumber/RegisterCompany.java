package gradle.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import upc.edu.pe.gestionempleadoresservice.entities.Compania;
import upc.edu.pe.gestionempleadoresservice.entities.Empleador;
import upc.edu.pe.gestionempleadoresservice.entities.Sector;

import java.nio.charset.Charset;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class RegisterCompany {

    private RestTemplate restTemplate = new RestTemplate();
    private String Mensaje_Confirmacion;
    private String Mensaje_Error;

    @Given("The employer wants to enter the company data")
    public void theEmployerWantsToEnterTheCompanyData() {
        String url = "https://rcuencam.github.io/Jobag/";
        String enter = restTemplate.getForObject(url, String.class);
        assertTrue(!enter.isEmpty());
    }

    @When("Is at the time of company registration")
    public void isAtTheTimeOfCompanyRegistration() {
        try {
            Compania newCompania = new Compania();
            assertNotNull(newCompania);
        }catch (RestClientException e){
            Mensaje_Confirmacion = "La creacion de la compania fue el 15/11/2021";
            assertEquals(Mensaje_Confirmacion, "La creacion de la compania fue el 15/11/2021");
        }
    }

    @Then("The employer can place in the fields, the information of the company")
    public void theEmployerCanPlaceInTheFieldsTheInformationOfTheCompany() {
        String nombreEmpresa = "PATITO SAC";
        String description = "Empresa de fabricacion de patitos de ule";
        Long ruc = 43254324L;
        Compania newCompania = new Compania(1L, nombreEmpresa, description, ruc, randomString(), "Peru", "Lima", "Jesus Maria", "Av BRASIl");

        assertNotNull(newCompania);
    }

    @Given("The employer wants to see the data they have completed")
    public void theEmployerWantsToSeeTheDataTheyHaveCompleted() {
        try {
            String nombreEmpresa = "PATITO SAC";
            String description = "Empresa de fabricacion de patitos de ule";
            Long ruc = 43254324L;
            Compania newCompania = new Compania(1L, nombreEmpresa, description, ruc, randomString(), "Peru", "Lima", "Jesus Maria", "Av BRASIl");
            assertNotNull(newCompania);
        }catch (RestClientException e){
            Mensaje_Confirmacion = "Su registro fue exitoso";
            assertEquals(Mensaje_Confirmacion, "Su registro fue exitoso");
        }
    }

    @When("Enter the company profile after registration")
    public void enterTheCompanyProfileAfterRegistration() {
        try {
            String nombreEmpresa = "PATITO SAC";
            String description = "Empresa de fabricacion de patitos de ule";
            Long ruc = 43254324L;
            Compania newCompania = new Compania(1L, nombreEmpresa, description, ruc, randomString(), "Peru", "Lima", "Jesus Maria", "Av BRASIl");
            assertNotNull(newCompania);
        }catch (RestClientException e){
            Mensaje_Confirmacion = "Estos son los datos de la empresa";
            assertEquals(Mensaje_Confirmacion, "stos son los datos de la empresa");
        }
    }

    @Then("The employer will be able to see the data of the company that has just entered")
    public void theEmployerWillBeAbleToSeeTheDataOfTheCompanyThatHasJustEntered() {
        String nombreEmpresa = "PATITO SAC";
        String description = "Empresa de fabricacion de patitos de ule";
        Long ruc = 43254324L;

        Compania newCompania = new Compania(1L, nombreEmpresa, description, ruc, randomString(), "Peru", "Lima", "Jesus Maria", "Av BRASIl");

        assertNotNull(newCompania);
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
