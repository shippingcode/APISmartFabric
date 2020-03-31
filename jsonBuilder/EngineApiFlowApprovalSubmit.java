package com.agys.jsonBuilder;


import lombok.*;

@Getter
@Setter @NoArgsConstructor
@AllArgsConstructor
@Builder
public class EngineApiFlowApprovalSubmit {

    private String actionCode;
    private String comment;
    private String taskId;
    private String wrongTaskId;
}
