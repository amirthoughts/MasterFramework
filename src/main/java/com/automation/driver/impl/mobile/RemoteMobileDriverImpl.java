package com.automation.driver.impl.mobile;

import com.automation.driver.IMobileDriver;
import com.automation.driver.entity.MobileDriverData;
import com.automation.driver.entity.WebDriverData;
import com.automation.driver.factory.mobile.remote.RemoteMobileDriverFactory;
import com.automation.driver.factory.web.remote.RemoteDriverFactory;
import org.openqa.selenium.WebDriver;

public class RemoteMobileDriverImpl implements IMobileDriver {
    @Override
    public WebDriver getDriver(MobileDriverData mobileDriverData) {
        return RemoteMobileDriverFactory.getDriver(mobileDriverData.getMobileRemoteModeType(), mobileDriverData.getMobilePlatformType());
    }
}
