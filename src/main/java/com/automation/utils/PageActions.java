package com.automation.utils;

import com.automation.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class PageActions {

    private PageActions() {}

    public static void waitAndClick(By by){
        //Wait logic needs to be added here
        DriverManager.getDriver().findElement(by).click();
    }

    public static void waitAndSendKeys(By by, String value){
        //Wait logic needs to be added here
        DriverManager.getDriver().findElement(by).sendKeys(value);
    }

    public static String getText(By by){
       return DriverManager.getDriver().findElement(by).getText();
    }

    public static void waitAndSee(By by){
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),10);
        wait.until(ExpectedConditions.visibilityOf(DriverManager.getDriver().findElement(by)));
    }

    public static void pressKey(Keys keys){
        Actions actions = new Actions(DriverManager.getDriver());
        actions.sendKeys(keys).build().perform();
    }
}
