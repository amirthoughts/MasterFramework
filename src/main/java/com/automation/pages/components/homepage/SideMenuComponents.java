package com.automation.pages.components.homepage;

import com.automation.pages.enums.components.MenuType;
import com.automation.pages.enums.components.SubMenuType;
import com.automation.utils.PageActions;
import org.openqa.selenium.By;

public class SideMenuComponents {

    private static final String MENU = "//span[text()='%s']/parent::a";
    private static final String SUB_MENU_USER_MANAGEMENT = "//span[contains(text(),'%s')]/parent::li";
    private static final String SUB_MENU_USERS = "//a[contains(text(),'%s')]/parent::li";

    public SideMenuComponents clickMenuItem(MenuType menuType){
        String xpath = String.format(MENU, menuType.getName());
        PageActions.waitAndClick(By.xpath(xpath));
        return this;
    }

    public SideMenuComponents clickSubMenuUserManagement(SubMenuType subMenuType){
        String xpath = String.format(SUB_MENU_USER_MANAGEMENT, subMenuType.getName());
        PageActions.waitAndClick(By.xpath(xpath));
        return this;
    }

    public SideMenuComponents clickSubMenuUsers(SubMenuType subMenuType){
        String xpath = String.format(SUB_MENU_USERS, subMenuType.getName());
        PageActions.waitAndClick(By.xpath(xpath));
        return this;
    }

}
