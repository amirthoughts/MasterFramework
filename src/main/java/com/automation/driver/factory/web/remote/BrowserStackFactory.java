package com.automation.driver.factory.web.remote;

import com.automation.driver.manager.web.remote.browserstack.BrowserStackChromeManager;
import com.automation.driver.manager.web.remote.browserstack.BrowserStackFirefoxManager;
import com.automation.driver.manager.web.remote.selenium.SeleniumGridChromeManager;
import com.automation.driver.manager.web.remote.selenium.SeleniumGridFirefoxManager;
import com.automation.enums.BrowserRemoteModeType;
import com.automation.enums.BrowserType;
import org.openqa.selenium.WebDriver;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public class BrowserStackFactory {

    private BrowserStackFactory() {}

    //<----Without lambda function -->

//    public static  WebDriver getDriver(BrowserType browserType){
//        return browserType  == BrowserType.CHROME
//                ? BrowserStackChromeManager.getDriver()
//                : BrowserStackFirefoxManager.getDriver();
//    }


                 //OR

    //Optimising using Lambda function

    private static final Map<BrowserType, Supplier<WebDriver>> MAP = new EnumMap<>(BrowserType.class);

    static {
        MAP.put(BrowserType.CHROME, BrowserStackChromeManager::getDriver);
        MAP.put(BrowserType.FIREFOX, BrowserStackFirefoxManager::getDriver);
    }

    public static WebDriver getDriver(BrowserType browserType){
        return MAP.get(browserType).get();
    }
}
