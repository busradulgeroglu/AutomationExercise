package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class SearchPage extends BasePage{
    @FindBy(xpath = "//h2[text()='Searched Products']")
    public WebElement searchProductText;

    @FindBy(xpath = "//input[@id='search_product']")
    public WebElement searchProduct;

    @FindBy(xpath = "//button[@id='submit_search']")
    public WebElement searchProductBtn;

    @FindBy(xpath = "//div[@class='col-sm-4']")
    public List<WebElement> searchProducts;

    public void setSearchProduct(String product){
        searchProduct.sendKeys(product);
        searchProductBtn.click();
    }

    public void seeSearchProducts(){
        for(int i = 0; i<searchProducts.size(); i++){
            WebElement w = searchProducts.get(i);
            Assert.assertTrue(w.isDisplayed());
        }
    }
}
