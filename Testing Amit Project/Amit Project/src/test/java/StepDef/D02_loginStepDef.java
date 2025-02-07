package StepDef;

import Pages.P02_userLogin;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class D02_loginStepDef {
    P02_userLogin loginPage;

    // Initialize the loginPage in the setup phase
    @Given("user go to login page")
    public void userGoToLoginPage() {
        loginPage = new P02_userLogin(TestBase.driver);  // Initialize loginPage before use
        loginPage.navigateToLoginPage();
    }

    @And("user enter username {string} and password {string}")
    public void userEnterUsernameAndPassword(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @And("user clicks on login button")
    public void userClicksOnLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("login error message {string} is displayed")
    public void loginErrorMessageIsDisplayed(String expectedMessage) {
        loginPage.verifyLoginErrorMessage(expectedMessage);
    }
}
