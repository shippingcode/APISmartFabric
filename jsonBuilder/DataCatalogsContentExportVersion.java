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
public class DataCatalogsContentExportVersion {

    private String catalogs;
    private String processDefinitionId;
    private String versionId;
}
