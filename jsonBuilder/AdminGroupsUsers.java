package com.agys.jsonBuilder;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class AdminGroupsUsers {

    private String groupId;
    private String id;
    private String isManager;
    private String userId;



}
