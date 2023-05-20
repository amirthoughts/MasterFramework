package com.automation.config.converters;

import com.automation.enums.RunModeType;
import org.aeonbits.owner.Converter;

import java.lang.reflect.Method;
import java.util.Map;

public class StringToRunModeBrowserTypeConverter implements Converter<RunModeType> {

    @Override
    public RunModeType convert(Method method, String runMode) {

        return RunModeType.valueOf(runMode.toUpperCase());
    }
}
