package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class P03_shopPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public P03_shopPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Navigate to the main shop page
    public void navigateToShopPage() {
        driver.get("https://www.demoblaze.com/");
    }

    // Click on the Laptops category to view laptop products
    public void clickLaptopsCategory() {
        driver.findElement(By.linkText("Laptops")).click();
    }

    // Select a product by its name from the list
    public void selectProduct(String productName) {
        driver.findElement(By.xpath("//a[text()='" + productName + "']")).click();
    }

    // Add the selected product to the cart and handle the alert confirmation
    public void addProductToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Add to cart']"))).click();
        wait.until(ExpectedConditions.alertIsPresent()).accept();  // Handle the product added alert
    }

    // Navigate to the shopping cart page
    public void navigateToCart() {
        driver.findElement(By.id("cartur")).click();
    }

    // Verify that the product is visible in the cart
    public void verifyProductInCart(String productName) {
        WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(), '" + productName + "')]")));
        if (product == null) {
            throw new AssertionError("Product not found in cart: " + productName);
        }
    }

    // Verify the product's price in the cart
    public void verifyProductPriceInCart(String productName, String expectedPrice) {
        WebElement priceElement = driver.findElement(By.xpath("//td[contains(text(), '" + productName + "')]/following-sibling::td"));
        String actualPrice = priceElement.getText();
        if (!actualPrice.equals(expectedPrice)) {
            throw new AssertionError("Expected price: " + expectedPrice + ", but found: " + actualPrice);
        }
    }

    // Verify the total amount displayed in the cart
    public void verifyTotalAmount(String expectedTotal) {
        WebElement totalElement = driver.findElement(By.id("totalp"));
        String actualTotal = totalElement.getText();
        if (!actualTotal.equals(expectedTotal)) {
            throw new AssertionError("Expected total amount: " + expectedTotal + ", but found: " + actualTotal);
        }
    }

    // Click the 'Place Order' button to proceed with checkout
    public void clickPlaceOrderButton() {
        driver.findElement(By.xpath("//button[text()='Place Order']")).click();
    }

    // Fill in the checkout form with the necessary information
    public void fillCheckoutForm(String name, String country, String city, String creditCard, String month, String year) {
        driver.findElement(By.id("name")).sendKeys(name);
        driver.findElement(By.id("country")).sendKeys(country);
        driver.findElement(By.id("city")).sendKeys(city);
        driver.findElement(By.id("card")).sendKeys(creditCard);
        driver.findElement(By.id("month")).sendKeys(month);
        driver.findElement(By.id("year")).sendKeys(year);
    }

    // Click the 'Purchase' button to complete the purchase
    public void clickPurchaseButton() {
        driver.findElement(By.xpath("//button[text()='Purchase']")).click();
    }

    // Verify that the purchase was successful by checking the success message
    public void verifyPurchaseSuccess() {
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Thank you for your purchase!')]")));
        if (successMessage == null) {
            throw new AssertionError("Purchase success message not displayed.");
        }
    }
}
