package com.automation.tests.web.base;

import com.automation.driver.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aspectj.lang.annotation.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class WebBase {

    //local, remote(selenium-grid,selenide, browserstack) : chrome, firefox

    @BeforeMethod
    public void setup() {
        Driver.initDriverForWeb();
    }

    @AfterMethod
    public void tearDown() {
        Driver.quitDriver();
    }
}
