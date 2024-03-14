package cucumber_BDD;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinitions {

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        System.out.println("login page");

    }
    @When("I enter valid credentials")
    public void i_enter_valid_credentials() {
        System.out.println("valid credentials");

    }
    @When("I click on the login button")
    public void i_click_on_the_login_button() {
        System.out.println("clicked on login button");

    }
    @Then("I should be logged in to my account")
    public void i_should_be_logged_in_to_my_account() {
        System.out.println("logged successfully");
    }

    @When("I enter invalid credentials")
    public void iEnterInvalidCredentials() {
        System.out.println("invalid credentials");
    }

    @Then("I should see an error message")
    public void iShouldSeeAnErrorMessage() {
        System.out.println("error");
    }
}
