package com.automation.driver.factory.mobile.remote;

import com.automation.driver.manager.mobile.remote.BrowserStackAndroidManager;
import com.automation.driver.manager.mobile.remote.BrowserStackIOSManager;
import com.automation.enums.MobilePlatformType;
import org.openqa.selenium.WebDriver;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public final class SauceLabsMobileFactory {

    private SauceLabsMobileFactory(){}

    private static final Map<MobilePlatformType, Supplier<WebDriver>> MAP =
            new EnumMap<>(MobilePlatformType.class);

    static {
        MAP.put(MobilePlatformType.ANDROID, BrowserStackAndroidManager::getDriver);
        MAP.put(MobilePlatformType.IOS, BrowserStackIOSManager::getDriver);
    }

    public static WebDriver getDriver(MobilePlatformType mobilePlatformType){
        return MAP.get(mobilePlatformType).get();
    }
}