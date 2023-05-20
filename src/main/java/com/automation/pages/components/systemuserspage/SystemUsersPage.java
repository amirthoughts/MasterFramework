package com.automation.pages.components.systemuserspage;

public class SystemUsersPage {

    private final SearchComponent searchComponent;
    private final AddUserComponent addUserComponent;

    public SystemUsersPage(){
        this.searchComponent = new SearchComponent();
        this.addUserComponent = new AddUserComponent();
    }

    public AddUserComponent getAddUserComponent() {
        return addUserComponent;
    }
}
