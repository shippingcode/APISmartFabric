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
public class CatalogDataLoadDataInternal {

    private String includeAttachmentData;
    private String includeCatalogData;
    private String processInstanceId;
    private String versionId;
    private String processDefinitionId;
}
