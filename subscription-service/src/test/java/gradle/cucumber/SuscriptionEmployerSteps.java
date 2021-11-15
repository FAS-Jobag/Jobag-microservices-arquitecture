package gradle.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import upc.edu.pe.subscriptionservice.entities.PlanEmployer;

import java.util.Date;

/**
 * SuscriptionEmployerSteps
 */
public class SuscriptionEmployerSteps {
  PlanEmployer planEmployer;
  @Given("the administrator set the data of a new subscription")
  public void the_administrator_set_the_data_of_a_new_subscription() {
    planEmployer = new PlanEmployer();
    planEmployer.setId(1L);
    planEmployer.setDescription("New subscription");
    planEmployer.setLimitModification(2L);
    planEmployer.setLimitVideoconference(1L);
    planEmployer.setAssistance(true);
    planEmployer.setDuration(3L);
    planEmployer.setCreateAt(new Date());
    planEmployer.setStatus("A");
    System.out.println("Create Entity plan employer");
  }

  @When("run de function to create new subscription to employer")
  public void run_de_function_to_create_new_subscription_to_employer() {
    System.out.println("Execute create plan to employers");
  }

  @Then("the administrator get a data of a new subscription to employer")
  public void the_administrator_get_a_data_of_a_new_subscription_to_employer() {
    System.out.println("Return new subscription");
  }

  @Given("the administrator set the data of an existent subscription and the id")
  public void the_administrator_set_the_data_of_an_existent_subscription_and_the_id() {
    System.out.println("Get existend subscription");
  }

  @When("run the function to update an existent subscription employer")
  public void run_the_function_to_update_an_existent_subscription_employer() {
    System.out.println("Execute update plan");
  }

  @Then("the administrator get data of a existent subscription to employer updated")
  public void the_administrator_get_data_of_a_existent_subscription_to_employer_updated() {
    System.out.println("Return updated subscription");
  }

  @Given("the administrator set the id of an existent subscription")
  public void the_administrator_set_the_id_of_an_existent_subscription() {
    System.out.println("Set subscription id");
  }

  @When("run the function to delete an existent subscription to employers")
  public void run_the_function_to_delete_an_existent_subscription_to_employers() {
    System.out.println("Execute delete existeng subscription");
  }

  @When("run the function to search an existent subscription to employers by the id of deleted subscription to employer")
  public void run_the_function_to_search_an_existent_subscription_to_employers_by_the_id_of_deleted_subscription_to_employer() {
    System.out.println("Execute search subscription");
  }

  @Then("the administrator get a not found subscription to employer")
  public void the_administrator_get_a_not_found_subscription_to_employer() {
    System.out.println("Get not found subscription");
  }

  @When("the administrator run the function to search all existent subscription to employers")
  public void the_administrator_run_the_function_to_search_all_existent_subscription_to_employers() {
    System.out.println("Execute search all subscription");
  }
  @Then("the administrator get the list of existents subscriptions to employers")
  public void the_administrator_get_the_list_of_existents_subscriptions_to_employers() {
    System.out.println("Get all subscriptions to employers");
  }
}
