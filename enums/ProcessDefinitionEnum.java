package com.agys.enums;

/**
 * 
 * @author aila.bogasieru@agys.ch
 *
 */

public enum ProcessDefinitionEnum {

	PROCESS_DEFINITION_OK1("508b2cf1-bc2b-4d4e-8d1a-d5f85c4e8177"),
	PROCESS_DEFINITION_OK2("5d62145f-8c4e-4b93-a037-8ae05ecae071"),
	PROCESS_DEFINITION_OK3("5d62145f-8c4e-4b93-a037-8ae05ecae071"),
	PROCESS_DEFINITION_OK4("7f38a4f9-94d5-4f96-a545-4c43f5c2b097"),
	PROCESS_DEFINITION_OK5("508b2cf1-bc2b-4d4e-8d1a-d5f85c4e8177"),
	PROCESS_DEFINITION_INVALID("sadfsd345436-DFG-4d4e-6hgghg-57hgfhgfhfghf"),
	PROCESS_DEFINITION_NULL("null");

	private String id;

	ProcessDefinitionEnum(String id) {
		this.id = id;
}
	
	public String getId() {
		return id;
	}
}
