package com.automation.driver.factory;

import com.automation.driver.*;
import com.automation.driver.impl.mobile.LocalMobileDriverImpl;
import com.automation.driver.impl.mobile.RemoteMobileDriverImpl;
import com.automation.driver.impl.web.LocalWebDriverImpl;
import com.automation.driver.impl.web.RemoteWebDriverImpl;
import com.automation.enums.RunModeType;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public class DriverFactory {

    private DriverFactory(){}

      //<----Without lambda function -->

/*    public static WebDriver getDriverForWeb(WebDriverData webDriverData){

        return webDriverData.getRunModeType() == RunModeType.LOCAL
        ? new LocalWebDriverImpl().getDriver(webDriverData)
        : new RemoteWebDriverImpl().getDriver(webDriverData);


    }

    public static WebDriver getDriverForMobile(MobileDriverData mobileDriverData){

        return mobileDriverData.getRunModeType() == RunModeType.LOCAL
            ? new LocalMobileDriverImpl().getDriver(mobileDriverData)
            : new RemoteMobileDriverImpl().getDriver(mobileDriverData);
    }*/

                      //OR
    //Optimising using Lambda functions

    private static Map<RunModeType, Supplier<IWebDriver>> WEB = new EnumMap<>(RunModeType.class);
    private static Map<RunModeType, Supplier<IMobileDriver>> MOBILE = new EnumMap<>(RunModeType.class);



    static {
        WEB.put(RunModeType.LOCAL, LocalWebDriverImpl::new);
        WEB.put(RunModeType.REMOTE, RemoteWebDriverImpl::new);
        MOBILE.put(RunModeType.LOCAL, LocalMobileDriverImpl::new);
        MOBILE.put(RunModeType.REMOTE, RemoteMobileDriverImpl::new);
    }

    public static IWebDriver getDriverForWeb(RunModeType runModeType){
        return WEB.get(runModeType).get();
    }

    public static IMobileDriver getDriverForMobile(RunModeType runModeType){
        return  MOBILE.get(runModeType).get();
    }




}
