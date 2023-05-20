package com.automation.driver;

import com.automation.enums.PlatformType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebDriver;

import java.util.EnumMap;
import java.util.Map;

import static com.automation.enums.PlatformType.MOBILE;
import static com.automation.enums.PlatformType.WEB;
import static java.lang.ThreadLocal.withInitial;

public final class DriverManager {

    private DriverManager() {}

    //Without optimisation

    /*private static final ThreadLocal<WebDriver> THREAD_LOCAL = new ThreadLocal<>();


    public static WebDriver getDriver(){
        return THREAD_LOCAL.get();
    }

    public static void setDriver(WebDriver driver){
        THREAD_LOCAL.set(driver);
    }

    //adding to fix memory leak issues of ThreadLocal suggested by Sonarlint
    public static void unload(){
        THREAD_LOCAL.remove();
    }*/

              //OR
    //With Optimization

    private static final ThreadLocal<WebDriver> WEB_DRIVER_THREAD_LOCAL = new ThreadLocal<>();
    private static final ThreadLocal<WebDriver> MOBILE_DRIVER_THREAD_LOCAL = new ThreadLocal<>();
    private static final ThreadLocal<PlatformType> CONTEXT = withInitial(() -> WEB);
    private static final Map<PlatformType, ThreadLocal<WebDriver>> DRIVER_MAP
            = new EnumMap<>(PlatformType.class);

    public static WebDriver getDriver(){
        return CONTEXT.get() == WEB
                ? WEB_DRIVER_THREAD_LOCAL.get()
                : MOBILE_DRIVER_THREAD_LOCAL.get();
    }

    public static void setDriver(WebDriver driver){
        if(isMobileDriver(driver)){
            MOBILE_DRIVER_THREAD_LOCAL.set(driver);
            DRIVER_MAP.put(MOBILE, MOBILE_DRIVER_THREAD_LOCAL);
            CONTEXT.set(MOBILE);
        } else {
            WEB_DRIVER_THREAD_LOCAL.set(driver);
            DRIVER_MAP.put(WEB, WEB_DRIVER_THREAD_LOCAL);
            CONTEXT.set(WEB);
        }

    }

    private static boolean isMobileDriver(WebDriver driver) {
        return driver instanceof AndroidDriver || driver instanceof IOSDriver;
    }

    //adding to fix memory leak issues of ThreadLocal suggested by Sonarlint
    public static void unload(){
        WEB_DRIVER_THREAD_LOCAL.remove();
        MOBILE_DRIVER_THREAD_LOCAL.remove();
        CONTEXT.remove();
    }


}
