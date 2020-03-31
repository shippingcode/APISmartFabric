package com.agys.jsonBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder

public class EngineTaskList {

    private String activeTasks;
    private String isTeam;
    private String page;
    private String searchTerm;
    private String size;
    private String sortDirection;
    private String sortField;
    private String dueIn;
    private String priorities;
    private String taskName;
    private String taskStatus;
    private String ownerId;
}
