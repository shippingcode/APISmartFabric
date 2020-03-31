package com.agys.jsonBuilder;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class EngineVariablesInternal {

    private String includeAttachmentData;
    private String includeCatalogData;
    private String processInstanceId;
    private String variables;
    private String taskId;

}
