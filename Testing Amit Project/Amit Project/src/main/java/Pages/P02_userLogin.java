package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class P02_userLogin {
    private WebDriver driver;
    private WebDriverWait wait;

    public P02_userLogin(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Set up WebDriver wait
    }

    // Locators for login elements
    private By loginLink = By.id("login2");
    private By usernameField = By.id("loginusername");
    private By passwordField = By.id("loginpassword");
    private By loginButton = By.xpath("//button[text()='Log in']");
    private By loginErrorMessage = By.xpath("//div[@class='sweet-alert']/h2");

    public void navigateToLoginPage() {
        driver.get("https://www.demoblaze.com/index.html");
        driver.findElement(loginLink).click(); // Click login link to go to the login page
    }

    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username); // Enter username
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password); // Enter password
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click(); // Click login button to submit login
    }

    public void verifyLoginErrorMessage(String expectedMessage) {
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(loginErrorMessage)); // Wait for error message
        Assert.assertTrue(message.getText().contains(expectedMessage), "Login error message is incorrect."); // Verify error message
    }
}
