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
public class DataCatalogsContentImportVersion {

    private String overwriteExisting;
    private String inactiveOther;
    private String attachment;
    private String catalogs;
    private String processDefinitionId;
    private String versionId;
}
