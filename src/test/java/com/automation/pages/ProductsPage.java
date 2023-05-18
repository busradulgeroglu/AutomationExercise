package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class ProductsPage extends BasePage{

    @FindBy(xpath = "//div[@id='dismiss-button']")
    public WebElement adCloseBtn;

    @FindBy (xpath = "//h2[text()='All Products']")
    public WebElement allProductsText;

    @FindBy(xpath = "//div[@class='col-sm-4']")
    public List<WebElement> products;

    @FindBy(xpath = "(//a[text()='View Product'])[1]")
    public WebElement firstProducts;

    @FindBy(xpath = "//div[@class='product-information']")
    public WebElement productInformation;






    public void seeProducts(){
        for(int i = 1; i<products.size(); i++){
            WebElement w = products.get(i);
            Assert.assertTrue(w.isDisplayed());
        }
    }






}
