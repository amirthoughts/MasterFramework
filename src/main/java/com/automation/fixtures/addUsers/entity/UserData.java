package com.automation.fixtures.addUsers.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@Builder
public class UserData {

    private String userRole;
    private String employeeName;
    private String username;
    private String status;
    private String password;
    private String message;
}
