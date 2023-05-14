package com.automation.pages;

import com.automation.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AccountPage extends BasePage{
    @FindBy (xpath = "//input[@id='password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//select[@id='days']")
    public WebElement days;

    @FindBy(xpath = "//select[@id='months']")
    public WebElement months;

    @FindBy(xpath = "//select[@id='years']")
    public WebElement years;

    @FindBy(xpath = "//input[@id='newsletter']")
    public WebElement newsletterBtn;

    @FindBy(xpath = "//input[@id='first_name']")
    public WebElement firstName;

    @FindBy(xpath = "//input[@id='last_name']")
    public WebElement lastName;

    @FindBy(xpath = "//input[@id='address1']")
    public WebElement addres;

    @FindBy(xpath = "//select[@id='country']")
    public WebElement country;

    @FindBy(xpath = "//input[@id='state']")
    public WebElement state;

    @FindBy(xpath = "//input[@id='city']")
    public WebElement city;

    @FindBy(xpath = "//input[@id='zipcode']")
    public WebElement zipcode;

    @FindBy(xpath = "//input[@id='mobile_number']")
    public WebElement mobilNumber;

    @FindBy(xpath = "//button[text()='Create Account']")
    public WebElement creatAccountBtn;


    @FindBy(xpath = "//b[text()='Account Created!']")
    public WebElement creatAccountText;

    @FindBy(xpath = "//a[text()='Continue']")
    public WebElement continueBtn;




    public void setUpInformation(String password, String dayInput, String monthInput,String yearInput){
        BrowserUtils.waitFor(1);

        passwordInput.sendKeys(password);

        BrowserUtils.waitFor(1);

        Select day = new Select(days);
        Select month = new Select(months);
        Select year = new Select(years);

        day.selectByVisibleText(dayInput);
        BrowserUtils.waitFor(1);
        month.selectByVisibleText(monthInput);
        BrowserUtils.waitFor(1);
        year.selectByVisibleText(yearInput);

    }

    public void extraInfo(String countryInput, String name, String lastname, String adress,
                          String stateInput, String cityInput, String zipcodeInput, String mobilInput){

        BrowserUtils.scrollToElement(country);

        firstName.sendKeys(name);
        lastName.sendKeys(lastname);

        BrowserUtils.waitFor(1);
        Select countrys = new Select(country);

        countrys.selectByVisibleText(countryInput);
        addres.sendKeys(adress);
        state.sendKeys(stateInput);
        city.sendKeys(cityInput);

        BrowserUtils.scrollToElement(mobilNumber);
        BrowserUtils.waitFor(1);

        zipcode.sendKeys(zipcodeInput);
        mobilNumber.sendKeys(mobilInput);

        BrowserUtils.scrollToElement(creatAccountBtn);

        creatAccountBtn.click();


    }

}
