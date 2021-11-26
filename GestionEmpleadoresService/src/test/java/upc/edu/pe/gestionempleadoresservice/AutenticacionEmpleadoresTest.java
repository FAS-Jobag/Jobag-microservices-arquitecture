package upc.edu.pe.gestionempleadoresservice;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import upc.edu.pe.gestionempleadoresservice.entities.Empleador;
import upc.edu.pe.gestionempleadoresservice.models.User;

public class AutenticacionEmpleadoresTest {
    Empleador empleador = new Empleador();
    User user = new User();

    @Test
    @Given("The employer wants to log in with his/her previous created account")
    public void the_postulant_wants_to_log_in() {
        empleador.setCorreo("test@gmail.com");
        empleador.setContraseña("password");
    }

    @Test
    @When("The employer insert his/her authentication's information ")
    public void the_postulant_inserts_authentication_information(){
        empleador.setCorreo("test@gmail.com");
        empleador.setContraseña("password");
    }

    @Test
    @Then("The application responds with the employer' primary information ")
    public void application_responds_postulant_primary_information() throws Throwable{

        Assertions.assertEquals(user.getCorreo(),empleador.getCorreo());
        Assertions.assertEquals(user.getContraseña(),empleador.getContraseña());

    }
}
