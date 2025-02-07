package StepDef;

import Pages.P03_shopPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

public class D03_shopPageStepDef {
    private P03_shopPage shopPage;
    private WebDriver driver;

    // Setup method to initialize WebDriver and shopPage object
    @Before
    public void setup() {
        driver = TestBase.driver;  // Get the WebDriver from TestBase class
        if (driver == null) {
            throw new IllegalStateException("WebDriver is not initialized. Check TestBase class.");
        }
        shopPage = new P03_shopPage(driver);  // Initialize the shopPage object
    }

    // Navigate to the shop page
    @Given("user navigates to shop page")
    public void userNavigatesToShopPage() {
        shopPage.navigateToShopPage();  // Visit the main shop page
    }

    // Click on the Laptops category to view laptop products
    @And("user selects the laptops category")
    public void userSelectsTheLaptopsCategory() {
        shopPage.clickLaptopsCategory();  // Click the Laptops link
    }

    // Select a specific product by its name
    @And("user selects product {string}")
    public void userSelectsProduct(String productName) {
        shopPage.selectProduct(productName);  // Select the product by name
    }

    // Add the selected product to the cart
    @And("user adds the product to cart")
    public void userAddsTheProductToCart() {
        shopPage.addProductToCart();  // Add the product to the cart
    }

    // Navigate to the shopping cart
    @And("user navigates to cart")
    public void userNavigatesToCart() {
        shopPage.navigateToCart();  // Navigate to the cart page
    }

    // Verify if the selected product is visible in the cart
    @Then("product {string} should be visible in the cart")
    public void productShouldBeVisibleInTheCart(String productName) {
        shopPage.verifyProductInCart(productName);  
    }

    // Verify the product price in the cart
    @And("user verifies product {string} price is {string}")
    public void userVerifiesProductPrice(String productName, String expectedPrice) {
        shopPage.verifyProductPriceInCart(productName, expectedPrice);  // Verify the price
    }

    // Verify the total amount in the cart
    @And("user verifies total amount is {string}")
    public void userVerifiesTotalAmount(String totalAmount) {
        shopPage.verifyTotalAmount(totalAmount);  // verifying the total amount
    }

    // Click the place order button
    @And("user clicks the place order button")
    public void userClicksThePlaceOrderButton() {
        shopPage.clickPlaceOrderButton();  // Click the place order button to proceed to checkout
    }

    // Fill out the checkout form with the necessary details
    @And("user fills checkout form with name {string}, country {string}, city {string}, credit card {string}, month {string}, and year {string}")
    public void userFillsCheckoutForm(String name, String country, String city, String creditCard, String month, String year) {
        shopPage.fillCheckoutForm(name, country, city, creditCard, month, year);  // Complete user data
    }

    // Click the purchase button to confirm the order
    @And("user clicks purchase button")
    public void userClicksPurchaseButton() {
        shopPage.clickPurchaseButton();  // Confirm the purchase
    }

    // Verify that the purchase was successful
    @Then("the purchase should be successful")
    public void thePurchaseShouldBeSuccessful() {
        shopPage.verifyPurchaseSuccess();  // Verify if the success message appears
    }
}
