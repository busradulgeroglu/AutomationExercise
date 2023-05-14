package com.automation.test;

import com.automation.pages.AccountPage;
import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;
import com.automation.utilities.BrowserUtils;
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

}
