package com.agys.jsonBuilder;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class TenantsUsersProfileNotification {
    private String appNot;
    private String diagramModifiedNot;
    private String email;
    private String inApp;
    private String interfaceModifiedNot;
    private String interfaceNot;
    private String sms;
    private String taskNot;
    private String taskRoleNot;
    private String userId;

 }
