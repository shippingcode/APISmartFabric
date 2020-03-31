package com.agys.jsonBuilder;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class TenantsUser {
    private String avatarPath;
    private String code;
    private String department;
    private String email;
    private String firstName;
    private String gender;
    private String id ;
    private String language;
    private String lastName;
    private String password;
    private String passwordLastUpdate;
    private String phone;
    private String position;
    private String reportsTo;
    private String status;
    private String title;
    private String username;
    private String groupId;
    private String userGroupId;
    private String isManager;
    private String userId;
    private String userTenantPermissionId;
    private String permission;
    private String permissionType;
    private String targetId;
    private String userTenantId;
}
