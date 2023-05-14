package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(xpath = "//a[text()=' Home']")
    public WebElement homeButton;
    @FindBy(xpath = "//a[text()=' Signup / Login']")
    public WebElement signUpButton;
}
