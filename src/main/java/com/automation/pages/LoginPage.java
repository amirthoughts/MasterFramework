package com.automation.pages;

import org.openqa.selenium.By;

import static com.automation.utils.PageActions.*;

public class LoginPage {


    private static final By USER_NAME_FIELD = By.xpath("//input[@placeholder='Username']");
    private static final By PASSWORD_FIELD = By.name("password");
    private static final By LOGIN_BUTTON = By.xpath("//button[contains(@class,'orangehrm-login-button')]");


    private LoginPage setUsernameField(String username) {
        waitAndSendKeys(USER_NAME_FIELD, username);
        return this;
    }

    private LoginPage setPasswordField(String password) {
        waitAndSendKeys(PASSWORD_FIELD, password);
        return this;
    }

    private HomePage setLoginButton() {
        waitAndClick(LOGIN_BUTTON);
        return new HomePage();
    }

    public HomePage login(String username, String password) {
      return  setUsernameField(username)
                .setPasswordField(password)
                .setLoginButton();
    }
}
