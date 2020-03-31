package com.agys.jsonBuilder;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class EngineTaskFilterCreate {

    private String id;
    private String isDefault;
    private String name;
    private String ownerId;
    private String application;
    private String dueIn;
    private String priorities;
    private String taskName;
    private String taskStatus;
    private String taskStatus1;
}
