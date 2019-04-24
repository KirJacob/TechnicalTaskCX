package stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SomeDefinitions {

    @Given("^today is Sunday$")
    public void today_is_Sunday() {
        System.out.println("today_is_Sunday");
        // Write code here that turns the phrase above into concrete actions
    }

    @When("^I ask whether it's Friday yet$")
    public void i_ask_whether_it_s_Friday_yet() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("i_ask_whether_it_s_Friday_yet");
    }

    @Then("^I should be told \"([^\"]*)\"$")
    public void i_should_be_told(String arg1) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("i_should_be_told");
    }
}
