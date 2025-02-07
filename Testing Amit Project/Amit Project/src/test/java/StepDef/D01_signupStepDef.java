package StepDef;

import Pages.P01_signup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class D01_signupStepDef {
    P01_signup signupPage;

    // Initialize the signupPage in the setup phase
    @Given("user navigates to sign up page")
    public void userNavigatesToSignUpPage() {
        signupPage = new P01_signup(TestBase.driver);  // Initialize signupPage before use
        signupPage.navigateToSignUpPage();
    }

    @When("user enters username {string} and password {string}")
    public void userEntersUsernameAndPassword(String username, String password) {
        signupPage.enterUsername(username);
        signupPage.enterPassword(password);
    }

    @When("user clicks on sign up button")
    public void userClicksOnSignUpButton() {
        signupPage.clickSignupButton();
    }

    @Then("user should see a success message")
    public void userShouldSeeASuccessMessage() {
        signupPage.verifySignupErrorMessage("Sign up successful");
    }

    @Then("error message {string} is displayed")
    public void errorMessageIsDisplayed(String expectedMessage) {
        signupPage.verifySignupErrorMessage(expectedMessage);
    }
}
