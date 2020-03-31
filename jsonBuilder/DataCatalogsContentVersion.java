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
public class DataCatalogsContentVersion {

    private String filters;
    private String options;
    private String all_languages;
    private String ascending;
    private String sort_by;
    private String type;
}
