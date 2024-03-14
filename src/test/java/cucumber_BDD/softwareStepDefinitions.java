package cucumber_BDD;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;

public class softwareStepDefinitions {
    @Given("^i am a \"([^\"]*)\" in orange team$")
    public void i_am_a_softwareDeveloper_in_orange_team(String roleName){
        System.out.println(" i am a"+roleName+"in orange team");
    }
    @And("^i have a \"([^\"]*)\" works to do$")
    public void i_have_a_lotOf_works_to_do(String typeOfWork){
        System.out.println("i have a"+typeOfWork+"to do");
    }
    @When("^i have tough bugs i need to fix it well$")
    public void i_have_tough_bugs_i_need_to_fix_it_well(){
        System.out.println("softwareDeveloper");
    }
    @When("^sometimes i will get more work to do$")
    public void sometimes_i_will_get_more_work_to_do(){
        System.out.println("automationTester");
    }
    @Then("^i works \"([^\"]*)\"$")
    public void i_works_hard(String type){
        System.out.println("i works"+type);
    }
    @And("^i will get \"([^\"]*)\" of hike$")
    public void i_will_get_10_of_hike(String hike){
        System.out.println("i will get"+hike+"of hike");
    }
}
