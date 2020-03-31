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
public class DataCatalogsContentSaveVersion {

    private String active;
    private String code;
    private String columns;
    private String name;
    private String nameTranslations;
    private String  additionalProp1;
    private String  additionalProp2;
    private String  additionalProp3;
    private String type;
}
