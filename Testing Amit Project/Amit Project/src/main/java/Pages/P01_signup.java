package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class P01_signup {
    private WebDriver driver;
    private WebDriverWait wait;

    public P01_signup(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait setup
    }

    // Locators for sign-up elements
    private By signupLink = By.id("signin2");
    private By usernameField = By.id("sign-username");
    private By passwordField = By.id("sign-password");
    private By signupButton = By.xpath("//button[text()='Sign up']");
    private By signupErrorMessage = By.xpath("//div[@class='sweet-alert']/h2");

    public void navigateToSignUpPage() {
        driver.get("https://www.demoblaze.com");
        driver.findElement(signupLink).click(); // Click sign-up button
    }

    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username); // Enter username
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password); // Enter password
    }

    public void clickSignupButton() {
        driver.findElement(signupButton).click(); // Click sign-up button
    }

    public void verifySignupErrorMessage(String expectedMessage) {
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(signupErrorMessage)); // Wait for error message
        Assert.assertTrue(message.getText().contains(expectedMessage), "Signup error message is incorrect."); // Validate message
    }
}
