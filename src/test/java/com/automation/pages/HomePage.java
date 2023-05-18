package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(xpath = "//a[text()=' Home']")
    public WebElement homeButton;
    @FindBy(xpath = "//a[text()=' Signup / Login']")
    public WebElement signUpButton;
    @FindBy(xpath = "//a[text()=' Contact us']")
    public WebElement contactUs;
    @FindBy(xpath = "//a[text()=' Products']")
    public WebElement products;


}
