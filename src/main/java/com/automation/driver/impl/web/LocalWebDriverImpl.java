package com.automation.driver.impl.web;

import com.automation.driver.IWebDriver;
import com.automation.driver.entity.WebDriverData;
import com.automation.driver.factory.web.local.LocalDriverFactory;
import org.openqa.selenium.WebDriver;

public class LocalWebDriverImpl implements IWebDriver {
    @Override
    public WebDriver getDriver(WebDriverData webDriverData) {
        return LocalDriverFactory.getDriver(webDriverData.getBrowserType());
    }
}
