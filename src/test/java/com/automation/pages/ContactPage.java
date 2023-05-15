package com.automation.pages;

import com.automation.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactPage extends BasePage{

    @FindBy(xpath = "//h2[text()='Get In Touch']")
    public WebElement getInTouch;
    @FindBy(xpath = "//input[@name='name']")
    public WebElement conName;
    @FindBy(xpath = "//input[@name='email']")
    public WebElement conEmail;
    @FindBy(xpath = "//input[@name='subject']")
    public WebElement conSubject;
    @FindBy(xpath = "//textarea[@name='message']")
    public WebElement conMessage;
    @FindBy(xpath = "//input[@name='submit']")
    public WebElement submitBtn;
    @FindBy(xpath = "//input[@name='upload_file']")
    public WebElement fileUpload;
    @FindBy(xpath = "//div[@class='status alert alert-success']")
    public WebElement succesText;
    @FindBy(xpath = "//span[text()=' Home']")
    public WebElement goHome;


    public void setContactUsInfo(String name,String email, String  subject, String message){
        conName.sendKeys(name);
        conEmail.sendKeys(email);
        conSubject.sendKeys(subject);
        conMessage.sendKeys(message);
        fileUpload.sendKeys("C:\\Users\\User\\IdeaProjects\\AutomationExercise\\src\\test\\resources\\New Microsoft Word-Dokument.docx");
        submitBtn.click();

    }
}
