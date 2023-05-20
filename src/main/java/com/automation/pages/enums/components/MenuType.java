package com.automation.pages.enums.components;


public enum MenuType {

    ADMIN("Admin"),
    PIM("PIM"),
    LEAVE("Leave"),
    TIME("Time"),
    RECRUITMENT("Recruitment"),
    MY_INFO("My Info"),
    PERFORMANCE("Performance"),
    DASHBOARD("Dashboard"),
    DIRECTORY("Directory"),
    MAINTENANCE("Maintenance"),
    BUZZ("Buzz");

    private final String name;

    public String getName() {
        return name;
    }

    MenuType(String name) {
        this.name = name;
    }
}
