package com.automation.pages;

import com.automation.pages.components.systemuserspage.SystemUsersPage;
import com.automation.pages.components.homepage.SideMenuComponents;
import com.automation.pages.enums.components.MenuType;
import com.automation.pages.enums.components.SubMenuType;

public class HomePage {

    private SideMenuComponents sideMenuComponents;

    public HomePage(){
        this.sideMenuComponents = new SideMenuComponents();
    }

    public SideMenuComponents getSideMenuComponents() {
        return sideMenuComponents;
    }

    public SystemUsersPage navigateToAddUsersPage(){
        sideMenuComponents.clickMenuItem(MenuType.ADMIN)
                .clickSubMenuUserManagement(SubMenuType.USER_MANAGEMENT)
                .clickSubMenuUsers(SubMenuType.USERS);
        return new SystemUsersPage();
    }
}
