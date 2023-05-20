package com.automation.driver.factory.mobile.remote;

import com.automation.driver.manager.mobile.remote.BrowserStackAndroidManager;
import com.automation.driver.manager.mobile.remote.BrowserStackIOSManager;
import com.automation.driver.manager.web.remote.browserstack.BrowserStackChromeManager;
import com.automation.driver.manager.web.remote.browserstack.BrowserStackFirefoxManager;
import com.automation.enums.BrowserType;
import com.automation.enums.MobilePlatformType;
import org.openqa.selenium.WebDriver;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public class BrowserStackMobileFactory {

    private BrowserStackMobileFactory() {}


    private static final Map<MobilePlatformType, Supplier<WebDriver>> MAP = new EnumMap<>(MobilePlatformType.class);

    static {
        MAP.put(MobilePlatformType.ANDROID, BrowserStackAndroidManager::getDriver);
        MAP.put(MobilePlatformType.IOS, BrowserStackIOSManager::getDriver);
    }

    public static WebDriver getDriver(MobilePlatformType mobilePlatformType){
        return MAP.get(mobilePlatformType).get();
    }
}
