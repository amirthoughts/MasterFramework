package com.automation.tests;

import com.automation.config.ConfigFactory;
import com.automation.config.FrameworkConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigCache;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DemoTest {

    //local, remote(selenium-grid,selenide, browserstack) : chrome, firefox

    @Test
    public void testLogin() {
        System.out.println(ConfigFactory.getConfig().browser());

//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://google.com");
//        driver.quit();
    }
}
