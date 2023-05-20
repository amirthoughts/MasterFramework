package com.automation.driver.entity;

import com.automation.enums.MobilePlatformType;
import com.automation.enums.MobileRemoteModeType;
import com.automation.enums.RunModeType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MobileDriverData {
    private MobilePlatformType mobilePlatformType;
    private MobileRemoteModeType mobileRemoteModeType;
}
