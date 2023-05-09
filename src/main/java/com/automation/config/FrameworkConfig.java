package com.automation.config;

import com.automation.config.converters.StringToBrowserTypeConverter;
import com.automation.enums.BrowserType;
import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties", // When browser is passed as maven system properties /system properties
        "system:env",// When browser is passed as environment
        "file:${user.dir}/src/test/resources/config.properties" //If above two are not specified, it will use this location

})
public interface FrameworkConfig extends Config {

    //If nothing of above sources are specified, then use default browser
    @DefaultValue("CHROME")
    @ConverterClass(StringToBrowserTypeConverter.class)
    BrowserType browser();

}
