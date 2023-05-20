package com.automation.driver.factory.web.remote;

import com.automation.enums.BrowserRemoteModeType;
import com.automation.enums.BrowserType;
import org.openqa.selenium.WebDriver;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Function;


public final class RemoteDriverFactory {

    private RemoteDriverFactory(){}

    //<----Without lambda function -->

//    public static WebDriver getDriver(BrowserRemoteModeType browserRemoteModeType, BrowserType browserType){
//        if(browserRemoteModeType == BrowserRemoteModeType.SELENIUM){
//            return SeleniumGridFactory.getDriver(browserType);
//        } else if(browserRemoteModeType == BrowserRemoteModeType.SELELNOID){
//            return SelenoidFactory.getDriver(browserType);
//        } else if(browserRemoteModeType == BrowserRemoteModeType.BROWSER_STACK){
//            return BrowserStackFactory.getDriver(browserType);
//        }
//        return null;
//    }


                   //OR

    //Optimising using Lambda function

    private static final Map<BrowserRemoteModeType, Function<BrowserType, WebDriver>> MAP
             = new EnumMap<>(BrowserRemoteModeType.class);

    static {
        MAP.put(BrowserRemoteModeType.SELENIUM, SeleniumGridFactory::getDriver);
        MAP.put(BrowserRemoteModeType.SELENOID, SelenoidFactory::getDriver);
        MAP.put(BrowserRemoteModeType.BROWSER_STACK, BrowserStackFactory::getDriver);
    }

    public static WebDriver getDriver(BrowserRemoteModeType browserRemoteModeType, BrowserType browserType) {
        return MAP.get(browserRemoteModeType).apply(browserType);
    }
}
