package com.agys.jsonBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@Builder
public class DataModelDefinitionVersion {
/**
* @author aila.bogasieru@agys.ch
 */
    private String diagram;
    private String fieldsId;
    private String fieldsBCReady;
    private String fieldsEmbeded;
    private String fieldsIndexable;
    private String fieldsList;
    private String fieldName;
    private String fieldType;
    private String id;
    private String isBCReady;
    private String name;
    private String type;
}
