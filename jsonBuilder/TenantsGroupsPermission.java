package com.agys.jsonBuilder;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class TenantsGroupsPermission {

    private String groupId;
    private String id;
    private String permission;
    private String permissionType;
    private String targetId;

}
