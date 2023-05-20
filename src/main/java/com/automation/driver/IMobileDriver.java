package com.automation.driver;

import com.automation.driver.entity.MobileDriverData;
import com.automation.driver.entity.WebDriverData;
import org.openqa.selenium.WebDriver;

public interface IMobileDriver {

    WebDriver getDriver(MobileDriverData mobileDriverData);
}
