package com.agys.jsonBuilder;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class EngineApiProcessDefinitionExternalStart {

    private String additionalProp1;
    private String additionalProp2;
    private String additionalProp3;
    private String processDefinitionId;
}
