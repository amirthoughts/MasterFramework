package com.automation.tests.mobile.base;

import com.automation.driver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class MobileBase {

    //local, remote(selenium-grid,selenide, browserstack) : chrome, firefox

    @BeforeMethod
    public void setup() {
        Driver.initDriverForMobile();
    }

    @AfterMethod
    public void tearDown() {
        Driver.quitDriver();
    }
}
