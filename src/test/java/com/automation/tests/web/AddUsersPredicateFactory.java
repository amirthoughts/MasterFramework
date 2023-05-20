package com.automation.tests.web;

import com.automation.fixtures.addUsers.entity.UserData;
import com.automation.pages.components.systemuserspage.AddUserComponent;
import com.automation.pages.enums.components.addUser.StatusType;
import com.automation.pages.enums.components.addUser.UserRoleType;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiPredicate;
import java.util.function.Supplier;

public class AddUsersPredicateFactory {

    private static final Map<String, Supplier<BiPredicate<UserData, AddUserComponent>>> MAP = new HashMap<>();

    private static final BiPredicate<UserData, AddUserComponent> VALID_PREDICATE = (userData, addUserComponent) -> {

        addUserComponent.setUserRoleDropDown(UserRoleType.ADMIN)
                .setEmployeeNameField(userData.getEmployeeName(), "", "valid")
                .setStatusDropDown(StatusType.ENABLED)
                .setUsernameField(userData.getUsername())
                .setPasswordField(userData.getPassword())
                .setConfirmPasswordField(userData.getPassword())
                .setSaveButton();
        addUserComponent.setSaveButton();
        return addUserComponent.isSuccessMessageDisplayed();
    };

    private static final BiPredicate<UserData, AddUserComponent> JUST_EMPLOYEE_NAME_PREDICATE = (userData, addUserComponent) -> {
        addUserComponent.setEmployeeNameField(userData.getEmployeeName(), "No Records Found", "invalid");
        return addUserComponent.isErrorMessageDisplayedForEmployeeName();
    };

    static {
        MAP.put("valid", ()->VALID_PREDICATE);
        MAP.put("just_employee_name", ()->JUST_EMPLOYEE_NAME_PREDICATE);
    }

    public static BiPredicate<UserData, AddUserComponent> getPredicate(String value){
        return MAP.get(value).get();
    }

}
