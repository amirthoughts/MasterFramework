package com.automation.driver.factory.mobile.local;

import com.automation.driver.manager.mobile.local.AndroidManager;
import com.automation.driver.manager.mobile.local.IOSManager;
import com.automation.driver.manager.web.local.ChromeManager;
import com.automation.driver.manager.web.local.FirefoxManager;
import com.automation.enums.BrowserType;
import com.automation.enums.MobilePlatformType;
import org.openqa.selenium.WebDriver;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public final class LocalMobileDriverFactory {


    private LocalMobileDriverFactory(){}

    //Optimised using Lambda function

    private static final Map<MobilePlatformType, Supplier<WebDriver>> MAP = new EnumMap<>(MobilePlatformType.class);

    static {
        MAP.put(MobilePlatformType.ANDROID, AndroidManager::getDriver);
        MAP.put(MobilePlatformType.IOS, IOSManager::getDriver);
    }

    public static WebDriver getDriver(MobilePlatformType mobilePlatformType) {
        return MAP.get(mobilePlatformType).get();
    }

}
