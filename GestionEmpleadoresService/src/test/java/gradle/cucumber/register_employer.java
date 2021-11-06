package gradle.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class register_employer {

    private final WebDriver driver = new FirefoxDriver();

    //First Scenario
    @Given("The employer enters the application")
    public void theEmployerEntersTheApplication() {
        driver.navigate();
    }

    @When("Press the option to register by affiliating company data, RUC and a password")
    public void pressTheOptionToRegisterByAffiliatingCompanyDataRUCAndAPassword() {
    }

    @Then("You are notified by text message that the registration was successful")
    public void youAreNotifiedByTextMessageThatTheRegistrationWasSuccessful() {
    }

    //Second Scenario

    @When("Press the option to register and it does not fill in the data properly")
    public void pressTheOptionToRegisterAndItDoesNotFillInTheDataProperly() {
    }

    @Then("The registration process is not carried out because you must enter valid data")
    public void theRegistrationProcessIsNotCarriedOutBecauseYouMustEnterValidData() {
    }
}
