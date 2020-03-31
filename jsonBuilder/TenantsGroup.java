package com.agys.jsonBuilder;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class TenantsGroup {
    private String code;
    private String id;
    private String name;
    private String tenanatId;
    private String type;
    private String groupId;
    private String groupsPermisId;
    private String permission;
    private String permissionType;
    private String targetId;
    private String groupIdUserGroup;
    private String idUserGroup;
    private String isManager;
    private String userId;
}
