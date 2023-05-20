package com.automation.config;

import com.automation.config.converters.StringToURLConverter;
import org.aeonbits.owner.Config;

import java.net.URL;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "file:${user.dir}/src/test/resources/browser-stack.properties" //If above two are not specified, it will use this location
})
public interface BrowserStackConfig extends Config {

    @Key("username")
    String userName();

    @Key("key")
    String key();

    @DefaultValue("https://${username}:${key}@hub-cloud.browserstack.com/wd/hub")
    @ConverterClass(StringToURLConverter.class)
    URL BrowserStackURL();
}
