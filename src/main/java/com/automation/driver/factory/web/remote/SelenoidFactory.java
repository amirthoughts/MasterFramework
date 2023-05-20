package com.automation.driver.factory.web.remote;

import com.automation.driver.manager.web.remote.selenium.SeleniumGridChromeManager;
import com.automation.driver.manager.web.remote.selenium.SeleniumGridFirefoxManager;
import com.automation.driver.manager.web.remote.selenoid.SelenoidChromeManager;
import com.automation.driver.manager.web.remote.selenoid.SelenoidFirefoxManager;
import com.automation.enums.BrowserType;
import org.openqa.selenium.WebDriver;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public final class SelenoidFactory {

    private SelenoidFactory() {}

    //<----Without lambda function -->

   /* public static WebDriver getDriver(BrowserType browserType) {
        return browserType  == BrowserType.CHROME
                ? SelenoidChromeManager.getDriver()
                : SelenoidFirefoxManager.getDriver();
    }*/

    //OR

    //Optimising using Lambda function

    private static final Map<BrowserType, Supplier<WebDriver>> MAP = new EnumMap<>(BrowserType.class);

    static {
        MAP.put(BrowserType.CHROME, SelenoidChromeManager::getDriver);
        MAP.put(BrowserType.FIREFOX, SelenoidFirefoxManager::getDriver);
    }

    public static WebDriver getDriver(BrowserType browserType){
        return MAP.get(browserType).get();
    }
}
