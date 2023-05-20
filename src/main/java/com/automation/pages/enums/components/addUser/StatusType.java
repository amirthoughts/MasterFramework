package com.automation.pages.enums.components.addUser;


public enum StatusType {

    ENABLED("Enabled"),
    DISABLED("Disbabled"),;

    private final String name;

    public String getName() {
        return name;
    }

    StatusType(String name) {
        this.name = name;
    }
}
