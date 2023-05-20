package com.automation.tests.web;

import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import com.automation.fixtures.addUsers.entity.UserData;
import com.automation.pages.LoginPage;

import com.automation.pages.components.systemuserspage.AddUserComponent;
import com.automation.tests.web.base.WebBase;
import io.github.sskorol.core.DataSupplier;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.function.BiPredicate;
import java.util.stream.Stream;

public class AddUsersTest extends WebBase {


//    @DataSupplier
//    public Stream<UserData> getData() {
//        UserData userData =
//                new UserData(UserRoleType.ADMIN.getName(), "Test User 1", "testusername", StatusType.ENABLED.getName(), "testpassword");
//        return Stream.of(userData);
//
//    }

/*
    @DataSupplier
    public Stream<UserData> getData() {
        FixtureFactoryLoader.loadTemplates("com.automation.fixtures");

        UserData valid = Fixture.from(UserData.class).gimme("valid");

         return Stream.of(valid);
    }
*/


    //Below two predicates are now moved to separate Predicate class -> AddUsersPredicateFactory

    /*BiPredicate<UserData, AddUserComponent> justEmployeeNamePredicate = (userData, addUserComponent) -> {
        addUserComponent.setEmployeeNameField(userData.getEmployeeName(), "No Records Found", "invalid");
        return addUserComponent.isErrorMessageDisplayedForEmployeeName();
    };

    BiPredicate<UserData, AddUserComponent> validPredicate = (userData, addUserComponent) -> {
        addUserComponent.setUserRoleDropDown(UserRoleType.ADMIN)
            .setEmployeeNameField(userData.getEmployeeName(), "", "valid")
            .setStatusDropDown(StatusType.ENABLED)
            .setUsernameField(userData.getUsername())
            .setPasswordField(userData.getPassword())
            .setConfirmPasswordField(userData.getPassword())
            .setSaveButton();
        addUserComponent.setSaveButton();
        return addUserComponent.isSuccessMessageDisplayed();

    };*/

    @DataSupplier
    public Stream<AddUserScenarioType> getData() {
        FixtureFactoryLoader.loadTemplates("com.automation.fixtures");
        return Stream.of(AddUserScenarioType.values());
    };


/*    @Test(dataProvider = "getData")
    public void testAddUsers(UserData userData, BiPredicate<UserData, AddUserComponent> predicate) {
        boolean isMessageDisplayed = new LoginPage()
                .login("Admin", "admin123")
                .navigateToAddUsersPage()
                .getAddUserComponent()
                .setAddButton()
                .fillDetails(userData, predicate);

        Assertions.assertThat(isMessageDisplayed)
                .withFailMessage(userData::getMessage)
                .isTrue();

    }*/

    @Test(dataProvider = "getData")
    public void testAddUsers(AddUserScenarioType addUserScenarioType) {
        boolean isMessageDisplayed = new LoginPage()
                .login("Admin", "admin123")
                .navigateToAddUsersPage()
                .getAddUserComponent()
                .setAddButton()
                .fillDetails(addUserScenarioType.getUserData(), addUserScenarioType.getPredicate());


        Assertions.assertThat(isMessageDisplayed)
                .withFailMessage(addUserScenarioType.getUserData()::getMessage)
                .isTrue();

    }

}
