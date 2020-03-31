package com.agys.jsonBuilder;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class AdminUsers {

    private String code;
    private String department;
    private String email;
    private String firstName;
    private String gender;
    private String id;
    private String language;
    private String lastName;
    private String password;
    private String passwordLastUpdate;
    private String phone;
    private String position;
    private String reportsTo;
    private String status;
    private String title;
    private String token;
    private String tokenExpiry;
    private String username;



}
