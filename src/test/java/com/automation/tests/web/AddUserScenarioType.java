package com.automation.tests.web;

import br.com.six2six.fixturefactory.Fixture;
import com.automation.fixtures.addUsers.entity.UserData;
import com.automation.pages.components.systemuserspage.AddUserComponent;
import lombok.Getter;
import org.apache.poi.ss.formula.functions.T;

import java.util.function.BiPredicate;

@Getter
public enum AddUserScenarioType {

    VALID(AddUsersPredicateFactory.getPredicate("valid"), Fixture.from(UserData.class).gimme("valid")),
    JUST_EMPLOYEE_NAME(AddUsersPredicateFactory.getPredicate("just_employee_name"), Fixture.from(UserData.class).gimme("just_employee_name"));

    private final BiPredicate<UserData, AddUserComponent> predicate;
    private final UserData userData;


    AddUserScenarioType(BiPredicate<UserData, AddUserComponent> predicate, UserData userData) {
        this.predicate = predicate;
        this.userData = userData;

    }
}
