package org.example.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class InventoryPage {
    public static WebDriver webDriver;

    public InventoryPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        webDriver = driver;
    }

    @FindBy(xpath = "//span[@class='title']")
    private WebElement labelProduct;
    @FindBy(xpath = "//select[@class='product_sort_container']")
    private WebElement sortProduct;
    @FindBy(xpath = "//div[@id='shopping_cart_container']/a[1]")
    private WebElement iconCart;
    @FindBy(xpath = "//span[@class='title']")
    private WebElement labelCart;
    @FindBy(xpath = "//button[@id='checkout']")
    private WebElement buttonCheckout;

    public boolean verifyLabelProduct(){
        return labelProduct.isDisplayed();
    }
    public void selectSortProduct(String text){
        Select select = new Select(sortProduct);
        select.selectByVisibleText(text);
    }
    public void clickAddToCartItem(String item){
        String button = "//div[text()='" + item + "']/ancestor::div[@class='inventory_item_description']//button[text()='Add to cart']";
        webDriver.findElement(By.xpath(button)).click();
    }
    public void clickIconCart(){
        iconCart.click();
    }
    public boolean verifyLabelCart(){
        return labelCart.isDisplayed();
    }
    public void clickRemove(String item){
        String button = "//div[text()='" + item + "']/ancestor::div[@class='cart_item_label']//button[text()='Remove']";
        webDriver.findElement(By.xpath(button)).click();
    }
    public void clickButtonCheckout(){
        buttonCheckout.click();
    }



}
