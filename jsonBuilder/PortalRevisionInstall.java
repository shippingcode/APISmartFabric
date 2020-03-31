package com.agys.jsonBuilder;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class PortalRevisionInstall {
    private String active;
    private String guiControlId;
    private String installedGUIControlRevisionId;
    private String instanceId;
    private String toBeInstalledGUIControlRevisionId;
}
