package StepDef;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
    public static WebDriver driver;

    // Set up the browser and WebDriver before all tests
    @BeforeAll
    public static void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");  
        driver = new ChromeDriver();  
        driver.manage().window().maximize();  
    }

    // Close the browser after test
    @AfterAll
    public static void closeBrowser() {
        if (driver != null) {
            driver.quit();  // 
        }
    }
}
