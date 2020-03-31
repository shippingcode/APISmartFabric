package com.agys.jsonBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author aila.bogasieru@agys.ch
 */

@Getter
@Setter
@AllArgsConstructor
@Builder
public class GuiControlRevisionSave {

    private String code;
    private String config;
    private String fileName;
    private String fileType;
    private String fileUUID;
    private String guiControlId;
    private String guiControlRevisionId;
    private String revision;
}
