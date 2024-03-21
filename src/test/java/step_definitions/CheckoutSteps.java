package step_definitions;

import hooks.Hooks;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pageObject.CheckoutPage;
import org.example.pageObject.InventoryPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class CheckoutSteps {
    private final WebDriver driver = Hooks.driver;
    CheckoutPage checkoutPage = new CheckoutPage(driver);

    @When("User input {string} as FirstName and {string} as LastName and {string} as PostalCode and click continue")
    public void credential(String FirstName, String LastName, String PostalCode){
        checkoutPage.inputFieldFirstName(FirstName);
        checkoutPage.inputFieldLastName(LastName);
        checkoutPage.inputFieldPostalCode(PostalCode);
        checkoutPage.clickButtonContinue();
    }

    @Then("User redirected to checkout payment page")
    public void userRedirectedToCheckoutPaymentPage() {
        checkoutPage.verifyPrice();
    }

    @When("User click finish button")
    public void userClickFinishButton() {
        checkoutPage.clickButtonFinish();
    }

    @Then("User redirected to checkout complete page and should see {string}")
    public void userRedirectedToCheckoutCompletePageAndShouldSee(String text) {
        Assert.assertEquals(text, checkoutPage.getCompleteMessage());
    }
}
