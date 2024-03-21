package org.example.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    public static WebDriver webDriver;

    public CheckoutPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        webDriver = driver;
    }

    @FindBy(xpath = "//input[@id='first-name']")
    private WebElement fieldFirstName;
    @FindBy(xpath = "//input[@id='last-name']")
    private WebElement fieldLastName;
    @FindBy(xpath = "//input[@id='postal-code']")
    private WebElement fieldPostalCode;
    @FindBy(xpath = "//input[@id='continue']")
    private WebElement buttonContinue;
    @FindBy(xpath = "//div[@class='summary_subtotal_label']")
    private WebElement priceItem;
    @FindBy(xpath = "//div[@class='summary_tax_label']")
    private WebElement priceTax;
    @FindBy(xpath = "//div[@class='summary_info_label summary_total_label']")
    private WebElement priceFinal;
    @FindBy(xpath = "//button[@id='finish']")
    private WebElement buttonFinish;
    @FindBy(xpath = "//h2[@class='complete-header']")
    private WebElement completeMessage;

    public void inputFieldFirstName(String FirstName){
        fieldFirstName.sendKeys(FirstName);
    }
    public void inputFieldLastName(String LastName){
        fieldLastName.sendKeys(LastName);
    }
    public void inputFieldPostalCode(String PostalCode){
        fieldPostalCode.sendKeys(PostalCode);
    }
    public boolean verifyCheckoutPage(){
        boolean a = fieldFirstName.isDisplayed();
        boolean b = fieldLastName.isDisplayed();
        boolean c = fieldPostalCode.isDisplayed();
        return a && b && c;
    }
    public void clickButtonContinue(){
        buttonContinue.click();
    }
    public boolean verifyPrice(){
        float totalItemPrice = Float.parseFloat(priceItem.getText().split("\\$")[1]);
        float taxPrice = Float.parseFloat(priceTax.getText().split("\\$")[1]);
        float finalPrice = Float.parseFloat(priceFinal.getText().split("\\$")[1]);
        return totalItemPrice + taxPrice == finalPrice;
    }
    public void clickButtonFinish(){
        buttonFinish.click();
    }
    public String getCompleteMessage(){
        return completeMessage.getText();
    }
}
