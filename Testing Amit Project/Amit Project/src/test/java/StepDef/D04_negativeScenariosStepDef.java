package StepDef;

import Pages.P04_negativeTests;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class D04_negativeScenariosStepDef {
    P04_negativeTests negativeTestsPage;

    // Initialize the negativeTestsPage object before each scenario
    @Before
    public void precondition() {
        negativeTestsPage = new P04_negativeTests(TestBase.driver);  // Initialize the page object
    }

    // Navigate to the sign-up page
    @Given("user go to sign up page")
    public void userGoToSignUpPage() {
        negativeTestsPage.navigateToSignUpPage();  // Navigate to the sign-up page
    }

    // Enter username and password during sign-up
    @And("user enter username {string} and password {string}")
    public void userEnterUsernameAndPassword(String username, String password) {
        negativeTestsPage.enterUsername(username);  // Enter the username
        negativeTestsPage.enterPassword(password);  // Enter the password
    }

    // Click the sign-up button
    @And("user clicks on sign up button")
    public void userClicksOnSignUpButton() {
        negativeTestsPage.clickSignupButton();  // Click the 'Sign Up' button
    }

    // Verify the error message displayed during sign-up
    @Then("error message {string} is displayed")
    public void errorMessageIsDisplayed(String expectedMessage) {
        negativeTestsPage.verifySignupErrorMessage(expectedMessage);  // Verify the error message shown
    }

    // Navigate to the login page
    @Given("user go to login page")
    public void userGoToLoginPage() {
        negativeTestsPage.navigateToLoginPage();  // Navigate to the login page
    }

    // Enter login credentials (username and password)
    @And("user enter login username {string} and password {string}")
    public void userEnterLoginUsernameAndPassword(String username, String password) {
        negativeTestsPage.enterLoginUsername(username);  // Enter the login username
        negativeTestsPage.enterLoginPassword(password);  // Enter the login password
    }

    // Click the login button
    @And("user clicks on login button")
    public void userClicksOnLoginButton() {
        negativeTestsPage.clickLoginButton();  // Click the 'Log In' button
    }

    // Verify the error message displayed during login
    @Then("login error message {string} is displayed")
    public void loginErrorMessageIsDisplayed(String expectedMessage) {
        negativeTestsPage.verifyLoginErrorMessage(expectedMessage);  // Verify the login error message
    }
}
