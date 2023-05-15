package com.automation.test;

import com.automation.pages.AccountPage;
import com.automation.pages.ContactPage;
import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;
import com.automation.utilities.BrowserUtils;
import com.automation.utilities.ConfigurationReader;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test1 extends TestBase{

    @Test
    public void test(){
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.homeButton.isDisplayed());
        LoginPage loginPage = new LoginPage();
        loginPage.signUp("sen21","sen21212121@gmail.com");
        //Assert.assertTrue(loginPage.accountInformation.isDisplayed());
        BrowserUtils.waitFor(1);
        String actualText = "ENTER ACCOUNT INFORMATION";
        String expectedText= loginPage.accountInformation.getText();
        Assert.assertEquals(actualText,expectedText);
        AccountPage accountPage = new AccountPage();
        accountPage.setUpInformation("123456789","5","April","1993");
        accountPage.newsletterBtn.click();
        Assert.assertTrue(accountPage.newsletterBtn.isSelected());
        accountPage.extraInfo("Canada","dul","dul","jager",
                "california","14467","1456987","58565");
        String actualText2= "ACCOUNT CREATED!";
        String expectedText2 = accountPage.creatAccountText.getText();
        Assert.assertEquals(actualText2,expectedText2);
        BrowserUtils.waitFor(1);
        accountPage.continueBtn.click();
    }


    @Test
    public void test2(){
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        extentLogger = report.createTest("Negative login test");
        extentLogger.info("Verify that home page is visible successfully");
        Assert.assertTrue(homePage.homeButton.isDisplayed());
        extentLogger.info("Click on 'Signup / Login' button");
        homePage.signUpButton.click();
        extentLogger.info("Verify 'Login to your account' is visible");
        Assert.assertTrue(loginPage.loginText.isDisplayed());
        extentLogger.info("Enter incorrect email address and password");
        loginPage.login();
        extentLogger.info(" Click 'login' button");
        loginPage.loginBtn.click();
        extentLogger.info("Verify error 'Your email or password is incorrect!' is visible");
        Assert.assertTrue(loginPage.warningMessage.isDisplayed());
    }

    @Test
    public void test3(){
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        extentLogger = report.createTest("Negative login test");
        extentLogger.info("Verify that home page is visible successfully");
        Assert.assertTrue(homePage.homeButton.isDisplayed());
        extentLogger.info("Click on 'Signup / Login' button");
        homePage.signUpButton.click();
        extentLogger.info("Enter correct email address and password");
        loginPage.login();
        extentLogger.info(" Click 'login' button");
        loginPage.loginBtn.click();
        extentLogger.info("Verify that 'Logged in as username' is visible");
        String expectedText = loginPage.welcomeMessage.getText();
        Assert.assertEquals(expectedText,"Logged in as busra dulger");
        //Assert.assertTrue(loginPage.welcomeMessage.isDisplayed());
        extentLogger.info("Click 'Logout' button");
        loginPage.logOut.click();
        extentLogger.info("Verify that user is navigated to login page");
        Assert.assertTrue(loginPage.loginText.isDisplayed());
    }

    @Test

    public void test4(){
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        extentLogger = report.createTest("Register with existing email");
        extentLogger.info("Verify that home page is visible successfully");
        Assert.assertTrue(homePage.homeButton.isDisplayed());
        extentLogger.info("Click on 'Signup / Login' button");
        homePage.signUpButton.click();
        String actualText = "New User Signup!";
        String expectedText= loginPage.signUpText.getText();
        Assert.assertEquals(expectedText,actualText);
        extentLogger.info("Enter name and already registered email address");
        loginPage.signUp(ConfigurationReader.get("name"),ConfigurationReader.get("email"));
        extentLogger.info("Verify error 'Email Address already exist!' is visible");
        Assert.assertTrue(loginPage.signUpWarningText.isDisplayed());
    }

    @Test

    public void test5(){

        HomePage homePage = new HomePage();
        ContactPage contactPage = new ContactPage();

        extentLogger = report.createTest("Contact Us Form Test");
        extentLogger.info("Verify that home page is visible successfully");
        Assert.assertTrue(homePage.homeButton.isDisplayed());
        extentLogger.info("Click on 'Contact Us' button");
        homePage.contactUs.click();
        extentLogger.info("Verify 'GET IN TOUCH' is visible");
        Assert.assertTrue(contactPage.getInTouch.isDisplayed());
        extentLogger.info("Enter name, email, subject and message");
        contactPage.setContactUsInfo("bsr", "benten@gmail.com","oylesine",
                "sanane");
        extentLogger.info("Click OK button");
        Alert alert = driver.switchTo().alert();
        alert.accept();
        extentLogger.info("Verify success message 'Success! " +
                "Your details have been submitted successfully.' is visible");
        String expectedText = contactPage.succesText.getText();
        String actualText = "Success! Your details have been submitted successfully.";
        Assert.assertEquals(actualText,expectedText);
        extentLogger.info("Click 'Home' button and verify that landed to home page successfully");
        contactPage.goHome.click();

    }

}
