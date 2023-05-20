package com.automation.pages.components.systemuserspage;

import com.automation.driver.DriverManager;
import com.automation.fixtures.addUsers.entity.UserData;
import com.automation.pages.enums.components.addUser.StatusType;
import com.automation.pages.enums.components.addUser.UserRoleType;
import com.automation.utils.PageActions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.slf4j.ILoggerFactory;

import java.util.function.BiPredicate;

public class AddUserComponent {

    private static final By ADD_BUTTON = By.xpath("//div[@class='orangehrm-header-container']//button");
    private static final By USER_ROLE_DROP_DOWN = By.xpath("//label[normalize-space()='User Role']/../..//div[contains(text(),'-- Select --')]");
    private static final By EMPLOYEE_NAME_FIELD = By.xpath("//input[@placeholder='Type for hints...']");
    private static final By STATUS_DROP_DOWN = By.xpath("//label[normalize-space()='Status']//following::div[@class='oxd-select-text-input'][normalize-space()='-- Select --']");
    private static final By USERNAME_FIELD= By.xpath("//label[normalize-space()='Username']/../..//input[contains(@class,'oxd-input')]");
    private static final By PASSWORD_FIELD = By.xpath("//div[@class='oxd-grid-item oxd-grid-item--gutters user-password-cell']//div[@class='oxd-input-group__label-wrapper']/..//input[@type='password']");
    private static final By CONFIRM_PASSWORD_FIELD = By.xpath("//label[normalize-space()='Confirm Password']//following::input[@type='password']");
    private static final By SAVE_BUTTON = By.xpath("//button[normalize-space()='Save']");
    private static final By EMPLOYEE_ERROR_MESSAGE = By.xpath("//span[contains(@class,'oxd-input-field-error-message')]");
    private static final By SUCCESS_TOAST_MESSAGE = By.xpath("//div[contains(@id,'oxd-toaster')]//p[contains(@class,'toast-title')]");


    //Dropdown values

    private static final String DROPDOWN_VALUE = "//span[contains(text(),'%s')]/..";
    private static final String NO_RECORDS_FOUND = "//div[@class='oxd-autocomplete-option']";

    //return this -->>> means retun the same page and for new page, we use return new Page();

    public AddUserComponent setAddButton() {
        PageActions.waitAndClick(ADD_BUTTON);
        return this;
    }

    public AddUserComponent setUserRoleDropDown(UserRoleType userRoleType) {
        PageActions.waitAndClick(USER_ROLE_DROP_DOWN);
        String xpath = String.format(DROPDOWN_VALUE, userRoleType.getName());
        PageActions.waitAndClick(By.xpath(xpath));
        return this;
    }

    public AddUserComponent setEmployeeNameField(String employeeName, String noRecordsMessage, String type) {
        PageActions.waitAndClick(EMPLOYEE_NAME_FIELD);
        PageActions.waitAndSendKeys(EMPLOYEE_NAME_FIELD, employeeName);
        if(type.equals("valid")){
            selectValidSearchResult(employeeName);
        } else {
            selectInvalidSearchResult(noRecordsMessage);
        }

        return this;
    }

    public AddUserComponent setStatusDropDown(StatusType statusType) {
        PageActions.waitAndClick(STATUS_DROP_DOWN);
        String xpath = String.format(DROPDOWN_VALUE, statusType.getName());
        PageActions.waitAndClick(By.xpath(xpath));
        return this;
    }

    public AddUserComponent setUsernameField(String username) {
        PageActions.waitAndClick(USERNAME_FIELD);
        PageActions.waitAndSendKeys(USERNAME_FIELD, username);
        return this;
    }

    public AddUserComponent setPasswordField(String password) {
        PageActions.waitAndClick(PASSWORD_FIELD);
        PageActions.waitAndSendKeys(PASSWORD_FIELD, password);
        return this;
    }

    public AddUserComponent setConfirmPasswordField(String password) {
        PageActions.waitAndClick(CONFIRM_PASSWORD_FIELD);
        PageActions.waitAndSendKeys(CONFIRM_PASSWORD_FIELD, password);
        return this;
    }

    public AddUserComponent setSaveButton() {
        PageActions.waitAndClick(SAVE_BUTTON);
        return this;
    }


    public boolean isSuccessMessageDisplayed() {
        PageActions.waitAndSee(SUCCESS_TOAST_MESSAGE);
        String message =  PageActions.getText(SUCCESS_TOAST_MESSAGE);
        return message.equalsIgnoreCase("Success");
    }

//    public AddUserComponent fillDetails(UserData userData, BiPredicate<UserData, AddUserComponent> predicate){
//
//        setUserRoleDropDown(UserRoleType.ADMIN)
//                .setEmployeeNameField(userData.getEmployeeName())
//                .setStatusDropDown(StatusType.ENABLED)
//                .setUsernameField(userData.getUsername())
//                .setPasswordField(userData.getPassword())
//                .setConfirmPasswordField(userData.getPassword())
//                .setSaveButton();
//        return this;
//    }

        public boolean fillDetails(UserData userData, BiPredicate<UserData, AddUserComponent> predicate){

        return  predicate.test(userData, new AddUserComponent());
    }
//    public boolean fillDetails(UserData userData, BiPredicate<UserData, AddUserComponent> predicate){
//        return predicate.test(userData, new AddUserComponent());
//    }

    public boolean isErrorMessageDisplayedForEmployeeName() {
        PageActions.waitAndSee(EMPLOYEE_ERROR_MESSAGE);
        String message =  PageActions.getText(EMPLOYEE_ERROR_MESSAGE);
        if (message.equalsIgnoreCase("No Records Found")) {
            PageActions.pressKey(Keys.TAB);
        }
        return message.equalsIgnoreCase("Invalid");
    }

    public AddUserComponent selectValidSearchResult(String employeeName){
        String xpath = String.format(DROPDOWN_VALUE, employeeName);
        PageActions.waitAndClick(By.xpath(xpath));
        return this;
    }

    public AddUserComponent selectInvalidSearchResult(String noRecordsMessage){
        String xpath = String.format(NO_RECORDS_FOUND, noRecordsMessage);
        PageActions.waitAndSee(By.xpath(xpath));
        PageActions.pressKey(Keys.TAB);
        return this;
    }

}
