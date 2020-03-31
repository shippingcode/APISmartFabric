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
public class DataCatalogsDefinitionVersion {

    private String description;
    private String idFields;
    private String nameFields;
    private String type;
    private String idDescription;
    private String nameDescription;
    private String removed;
}
