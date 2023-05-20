package com.automation.driver.entity;

import com.automation.enums.BrowserRemoteModeType;
import com.automation.enums.BrowserType;
import com.automation.enums.RunModeType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class WebDriverData {
    private BrowserType browserType;
    private BrowserRemoteModeType browserRemoteModeType;
}
