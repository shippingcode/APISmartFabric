package com.agys.jsonBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class DocumentsGenerate {
	private String processInstanceId;
	private String invalidProcessInstanceId;
	private String documentTemplateId;
	private String fileName;
	private String savePath;
}
