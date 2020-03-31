package com.agys.jsonBuilder;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class PermissionsUserPermissions {

    private String userId;
    private String permission;
    private String permissionType;
    private String targetId;
    private String id;

}
