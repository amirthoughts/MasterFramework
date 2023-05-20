package com.automation.driver.factory.mobile.remote;

import com.automation.config.factory.SauceLabsConfigFactory;
import com.automation.driver.factory.web.remote.BrowserStackFactory;
import com.automation.driver.factory.web.remote.SeleniumGridFactory;
import com.automation.driver.factory.web.remote.SelenoidFactory;
import com.automation.enums.BrowserRemoteModeType;
import com.automation.enums.BrowserType;
import com.automation.enums.MobilePlatformType;
import com.automation.enums.MobileRemoteModeType;
import org.openqa.selenium.WebDriver;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Function;


public final class RemoteMobileDriverFactory {

    private RemoteMobileDriverFactory(){}

    private static final Map<MobileRemoteModeType, Function<MobilePlatformType, WebDriver>> MAP
             = new EnumMap<>(MobileRemoteModeType.class);

    static {
        MAP.put(MobileRemoteModeType.BROWSER_STACK, BrowserStackMobileFactory::getDriver);
       MAP.put(MobileRemoteModeType.SAUCE_LABS, SauceLabsMobileFactory::getDriver);


    }

    public static WebDriver getDriver(MobileRemoteModeType mobileRemoteModeType, MobilePlatformType mobilePlatformType) {
        return MAP.get(mobileRemoteModeType).apply(mobilePlatformType);
    }
}
