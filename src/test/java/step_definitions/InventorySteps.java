package step_definitions;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pageObject.CheckoutPage;
import org.example.pageObject.InventoryPage;
import org.example.pageObject.LoginPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class InventorySteps {
    private final WebDriver driver = Hooks.driver;
    InventoryPage inventoryPage = new InventoryPage(driver);
    CheckoutPage checkoutPage = new CheckoutPage(driver);

    @When("User sort product by {string}")
    public void userSortProductBy(String text) {
        inventoryPage.selectSortProduct(text);
    }

    @And("User click button add to cart item {string}")
    public void userClickButtonAddToCartItem(String item) {
        inventoryPage.clickAddToCartItem(item);
    }

    @And("User click cart icon")
    public void userClickCartIcon() {
        inventoryPage.clickIconCart();
    }

    @Then("User redirected to cart page")
    public void userRedirectedToCartPage() {
        Assert.assertTrue(inventoryPage.verifyLabelCart());
    }

    @When("User click button remove item {string}")
    public void userClickButtonRemoveItem(String text) {
        inventoryPage.clickRemove(text);
    }

    @And("user click checkout button")
    public void userClickCheckoutButton() {
        inventoryPage.clickButtonCheckout();
    }

    @Then("User redirected to checkout page")
    public void userRedirectedToCheckoutPage() {
        checkoutPage.verifyCheckoutPage();
    }
}
