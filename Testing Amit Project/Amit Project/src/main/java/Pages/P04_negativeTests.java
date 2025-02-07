package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class P04_negativeTests {
    private WebDriver driver;
    private WebDriverWait wait;

    public P04_negativeTests(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators for Sign Up and Login elements
    By signupLink = By.id("signin2");
    By usernameField = By.id("sign-username");
    By passwordField = By.id("sign-password");
    By signupButton = By.xpath("//button[text()='Sign up']");
    By signupErrorMessage = By.xpath("//div[@class='sweet-alert']/h2");

    By loginLink = By.id("login2");
    By loginUsernameField = By.id("loginusername");
    By loginPasswordField = By.id("loginpassword");
    By loginButton = By.xpath("//button[text()='Log in']");
    By loginErrorMessage = By.xpath("//div[@class='sweet-alert']/h2");

    // Navigate to the Sign Up page
    public void navigateToSignUpPage() {
        driver.get("https://www.demoblaze.com/index.html");
        driver.findElement(signupLink).click();
    }

    // Enter username in the Sign Up form
    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    // Enter password in the Sign Up form
    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    // Click the Sign Up button
    public void clickSignupButton() {
        driver.findElement(signupButton).click();
    }

    // Verify the error message on Sign Up if present
    public void verifySignupErrorMessage(String expectedMessage) {
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(signupErrorMessage));
        Assert.assertTrue(message.getText().contains(expectedMessage), "Signup error message is incorrect.");
    }

    // Navigate to the Login page
    public void navigateToLoginPage() {
        driver.get("https://www.demoblaze.com/index.html");
        driver.findElement(loginLink).click();
    }

    // Enter username in the Login form
    public void enterLoginUsername(String username) {
        driver.findElement(loginUsernameField).sendKeys(username);
    }

    // Enter password in the Login form
    public void enterLoginPassword(String password) {
        driver.findElement(loginPasswordField).sendKeys(password);
    }

    // Click the Login button
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    // Verify the error message on Login if present
    public void verifyLoginErrorMessage(String expectedMessage) {
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(loginErrorMessage));
        Assert.assertTrue(message.getText().contains(expectedMessage), "Login error message is incorrect.");
    }
}
