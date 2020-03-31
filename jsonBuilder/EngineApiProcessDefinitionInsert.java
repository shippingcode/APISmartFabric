package com.agys.jsonBuilder;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class EngineApiProcessDefinitionInsert {

    private String image;
    private String processDefinitionModel;
    private String taskId;
}
