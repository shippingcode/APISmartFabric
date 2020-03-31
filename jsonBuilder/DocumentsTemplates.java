package com.agys.jsonBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class DocumentsTemplates {
	private String description;
	private String h;
	private String id;
	private String isActive;
	private String isAdvanced;
	private String iteration;
	private String name;
	private String ownerId;
	private String processDefinitionId;
	private String template;
	private String usedAttributes;
	private String versionId;
	private String w;
}
