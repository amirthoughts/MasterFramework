package com.automation.driver.factory.web.local;

import com.automation.driver.manager.web.local.ChromeManager;
import com.automation.driver.manager.web.local.FirefoxManager;
import com.automation.enums.BrowserType;
import org.openqa.selenium.WebDriver;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public final class LocalDriverFactory {


    private LocalDriverFactory(){}

    //<----Without lambda function -->

//    public static WebDriver getDriver(BrowserType browserType){
//
//       return isBrowserChrome(browserType)
//               ? ChromeManager.getDriver()
//               : FirefoxManager.getDriver();
//    }
//
//    private static boolean isBrowserChrome(BrowserType browserType) {
//        return browserType == BrowserType.CHROME;
//    }

                  //OR

    //Optimising using Lambda function

    private static final Map<BrowserType, Supplier<WebDriver>> MAP = new EnumMap<>(BrowserType.class);

    static {
        MAP.put(BrowserType.CHROME, ChromeManager::getDriver);
        MAP.put(BrowserType.FIREFOX, FirefoxManager::getDriver);
    }

    public static WebDriver getDriver(BrowserType browserType) {
        return MAP.get(browserType).get();
    }

}
