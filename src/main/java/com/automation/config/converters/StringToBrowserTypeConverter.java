package com.automation.config.converters;

import com.automation.enums.BrowserType;
import org.aeonbits.owner.Converter;

import java.lang.reflect.Method;
import java.util.Locale;
import java.util.Map;

public class StringToBrowserTypeConverter implements Converter<BrowserType> {


    @Override
    public BrowserType convert(Method method, String browserName) {

        Map<String, BrowserType> browserTypeMap = Map.of("CHROME", BrowserType.CHROME,
                "FIREFOX", BrowserType.FIREFOX);
        //If browser is invalid, run it on default browser as Chrome(2nd parmater of below function getorDefault)
        return browserTypeMap.getOrDefault(browserName.toUpperCase(), BrowserType.CHROME);
    }
}
