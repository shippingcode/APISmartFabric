package com.agys.jsonBuilder;


import lombok.*;

@Getter
@Setter @NoArgsConstructor
@AllArgsConstructor
@Builder
public class EngineApiFlowGuiSubmit {

    private String actionId;
    private String comment;
    private String taskId;
    private String wrongTaskId;
    private String wrongActionId;
}
