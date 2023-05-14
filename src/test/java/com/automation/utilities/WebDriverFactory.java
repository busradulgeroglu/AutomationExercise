package com.automation.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
    /*
    task
    write a static method that takes a string parameter name : browsertype
    it will setUp the browser
    and the method will return chromedriver or firefox object
    name of the method : getDriver
     */

    public static WebDriver getDriver(String browserTyp){
        WebDriver driver = null;
        switch (browserTyp.toLowerCase()){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
        }

        return driver;
    }
}
