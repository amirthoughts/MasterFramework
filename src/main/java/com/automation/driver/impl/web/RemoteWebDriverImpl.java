package com.automation.driver.impl.web;

import com.automation.driver.IWebDriver;
import com.automation.driver.entity.WebDriverData;
import com.automation.driver.factory.web.local.LocalDriverFactory;
import com.automation.driver.factory.web.remote.RemoteDriverFactory;
import org.openqa.selenium.WebDriver;

public class RemoteWebDriverImpl implements IWebDriver {
    @Override
    public WebDriver getDriver(WebDriverData webDriverData) {
        return RemoteDriverFactory.getDriver(webDriverData.getBrowserRemoteModeType(), webDriverData.getBrowserType());
    }
}
