package gradle.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import upc.edu.pe.subscriptionservice.entities.PlanEmployer;

/**
 * SuscriptionEmployerSteps
 */
public class SuscriptionEmployerSteps {
  PlanEmployer planEmployer;

  @Given("the administrator set the data of a new subscription")
  public void the_administrator_set_the_data_of_a_new_subscription() {
    planEmployer = new PlanEmployer();
  }

  @When("run de function to create new subscription to employer")
  public void run_de_function_to_create_new_subscription_to_employer() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
  }

  @Then("the administrator get a data of a new subscription to employer")
  public void the_administrator_get_a_data_of_a_new_subscription_to_employer() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
  }

  @Given("the administrator set the data of an existent subscription and the id")
  public void the_administrator_set_the_data_of_an_existent_subscription_and_the_id() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
  }

  @When("run the function to update an existent subscription employer")
  public void run_the_function_to_update_an_existent_subscription_employer() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
  }

  @Then("the administrator get data of a existent subscription to employer updated")
  public void the_administrator_get_data_of_a_existent_subscription_to_employer_updated() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
  }

  @Given("the administrator set the id of an existent subscription")
  public void the_administrator_set_the_id_of_an_existent_subscription() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
  }

  @When("run the function to delete an existent subscription to employers")
  public void run_the_function_to_delete_an_existent_subscription_to_employers() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
  }

  @When("run the function to search an existent subscription to employers by the id of deleted subscription to employer")
  public void run_the_function_to_search_an_existent_subscription_to_employers_by_the_id_of_deleted_subscription_to_employer() {
      // Write code here that turns the phrase above into concrete actions
      throw new io.cucumber.java.PendingException();
  }

  @Then("the administrator get a not found subscription to employer")
  public void the_administrator_get_a_not_found_subscription_to_employer() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
  }

  @When("the administrator run the function to search all existent subscription to employers")
  public void the_administrator_run_the_function_to_search_all_existent_subscription_to_employers() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
  }
  @Then("the administrator get the list of existents subscriptions to employers")
  public void the_administrator_get_the_list_of_existents_subscriptions_to_employers() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
  }
}
