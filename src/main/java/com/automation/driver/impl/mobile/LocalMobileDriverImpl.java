package com.automation.driver.impl.mobile;

import com.automation.driver.IMobileDriver;
import com.automation.driver.entity.MobileDriverData;
import com.automation.driver.entity.WebDriverData;
import com.automation.driver.factory.mobile.local.LocalMobileDriverFactory;
import com.automation.driver.factory.web.local.LocalDriverFactory;
import org.openqa.selenium.WebDriver;

public class LocalMobileDriverImpl implements IMobileDriver {

    @Override
    public WebDriver getDriver(MobileDriverData mobileDriverData) {
        return LocalMobileDriverFactory.getDriver(mobileDriverData.getMobilePlatformType());
    }
}
