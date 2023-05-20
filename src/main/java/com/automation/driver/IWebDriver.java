package com.automation.driver;

import com.automation.driver.entity.WebDriverData;
import org.openqa.selenium.WebDriver;

public interface IWebDriver {

    WebDriver getDriver(WebDriverData webDriverData);
}
