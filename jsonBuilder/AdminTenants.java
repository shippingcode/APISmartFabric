package com.agys.jsonBuilder;


import lombok.*;

@Getter
@Setter @NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdminTenants {

    private String id;
    private String defaultUserEmail;
    private String defaultUserPassword;
    private String domain;
    private String name;
    private String status;

}
