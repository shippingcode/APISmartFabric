package com.agys.jsonBuilder;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class EngineApiProcessInstanceBlockchainResult {

    private String processInstanceId;
    private String invalidProcessInstanceId;

}
