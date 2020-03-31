package com.agys.jsonBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder

public class SystemLogin {
    private String tenantId;
    private String userEmail;
    private String userPassword;
}


