package com.automation.driver;

import com.automation.driver.entity.MobileDriverData;
import com.automation.driver.entity.WebDriverData;
import com.automation.driver.factory.DriverFactory;
import com.automation.enums.MobilePlatformType;
import org.openqa.selenium.WebDriver;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

import static com.automation.config.factory.ConfigFactory.*;

public class Driver {

    private Driver(){}


    //local web, remote web, local mobile, remote mobile

    public static void initDriverForWeb(){
        if(Objects.isNull(DriverManager.getDriver())){
            WebDriverData webDriverData = new WebDriverData(getConfig().browser(),getConfig().browserRemoteMode());
            WebDriver driver = DriverFactory.getDriverForWeb(getConfig().browserRunMode()).getDriver(webDriverData);
            DriverManager.setDriver(driver);
            navigateToURL();
            maximizeTheWindow();
            waitImplicitly();
            waitForPageLoad();
        }
    }

    public static void navigateToURL(){
        DriverManager.getDriver().get(getConfig().webUrl());
        System.out.println("Navigated to URL: >>>>>>>>>> " + getConfig().webUrl());
    }

    public static void maximizeTheWindow(){
        DriverManager.getDriver().manage().window().maximize();
    }

    public static void waitForPageLoad(){
        DriverManager.getDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }

    public static void waitImplicitly(){
        DriverManager.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static void initDriverForMobile(){
        MobileDriverData mobileDriverData = new MobileDriverData(MobilePlatformType.ANDROID, getConfig().mobileRemoteMode());
        WebDriver driver = DriverFactory.getDriverForMobile(getConfig().mobileRunMode()).getDriver(mobileDriverData);
        DriverManager.setDriver(driver);
    }

    public static void quitDriver(){
        if(Objects.nonNull(DriverManager.getDriver())){
          DriverManager.getDriver().quit();
          DriverManager.unload();

        }

    }
}
