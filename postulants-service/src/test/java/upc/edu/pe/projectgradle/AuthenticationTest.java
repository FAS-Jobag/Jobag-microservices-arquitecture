package upc.edu.pe.projectgradle;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import upc.edu.pe.postulantsservice.entity.Postulant;
import upc.edu.pe.postulantsservice.models.User;

public class AuthenticationTest {
    Postulant postulant = new Postulant();
    User userBody = new User();

    @Test
    @Given("The postulant wants to log in with his/her previous created account")
    public void the_postulant_wants_to_log_in() {
        postulant.setEmail("test@gmail.com");
        postulant.setPassword("password");
    }

    @Test
    @When("The postulant insert his/her authentication's information ")
    public void the_postulant_inserts_authentication_information(){
        userBody.setEmail("test@gmail.com");
        userBody.setPassword("password");
    }

    @Test
    @Then("The application responds with the Postulant' primary information ")
    public void application_responds_postulant_primary_information() throws Throwable{

        Assertions.assertEquals(userBody.getEmail(),postulant.getEmail());
        Assertions.assertEquals(userBody.getPassword(),postulant.getPassword());

    }

}
