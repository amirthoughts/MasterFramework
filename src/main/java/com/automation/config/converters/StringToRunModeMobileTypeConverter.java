package com.automation.config.converters;

import com.automation.enums.RunModeMobileType;
import org.aeonbits.owner.Converter;

import java.lang.reflect.Method;

public class StringToRunModeMobileTypeConverter implements Converter<RunModeMobileType> {


    @Override
    public RunModeMobileType convert(Method method, String runMode) {

        return RunModeMobileType.valueOf(runMode.toUpperCase());
    }
}
