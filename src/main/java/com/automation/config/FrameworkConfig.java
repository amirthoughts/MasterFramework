package com.automation.config;

import com.automation.config.converters.*;
import com.automation.enums.*;
import org.aeonbits.owner.Config;

import java.net.URL;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties", // When browser is passed as maven system properties /system properties
        "system:env",// When browser is passed as environment
        "file:${user.dir}/src/test/resources/config.properties",//If above two are not specified, it will use this location
        "file:${user.dir}/src/test/resources/qa-config.properties",
        "file:${user.dir}/src/test/resources/stage-config.properties",
})


public interface FrameworkConfig extends Config {

    @DefaultValue("qa")
    String environment();

    @Key("${environment}.webUrl")
    String webUrl();

    //If nothing of above sources are specified, then use default browser
    @DefaultValue("CHROME")
    @ConverterClass(StringToBrowserTypeConverter.class)
    BrowserType browser();

    @Key("run.mode.browser")
    @ConverterClass(StringToRunModeBrowserTypeConverter.class)
    RunModeType browserRunMode();

    @Key("browser.remote.mode")
    @ConverterClass(StringToRemoteModeBrowserTypeConverter.class)
    BrowserRemoteModeType browserRemoteMode();

    @Key("mobile.remote.mode")
    @ConverterClass(StringToMobileRemoteModeTypeConverter.class)
    MobileRemoteModeType mobileRemoteMode();

    @Key("run.mode.mobile")
    @ConverterClass(StringToRunModeBrowserTypeConverter.class)
    RunModeType mobileRunMode();

    @ConverterClass(StringToURLConverter.class)
    @Key("selenium.grid.url")
    URL seleniumGridURL();

    @ConverterClass(StringToURLConverter.class)
    @Key("selenoid.url")
    URL selenoidURL();


    @ConverterClass(StringToURLConverter.class)
    @DefaultValue("http://127.0.0.1:4723/wd/hub")
    URL localAppiumServerURL();



}
