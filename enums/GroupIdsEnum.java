package com.agys.enums;

/**
 * 
 * @author aila.bogasieru@agys.ch
 *
 */

public enum GroupIdsEnum {
	
	GROUP_OK1("00000000-0000-0000-0000-000000000001"),
	GROUP_OK2("686ffb15-5158-4724-85db-7fe7aa98e0f9"),
	GROUP_OK3("c0ff43cb-7d20-48a2-9302-98bba05b849f"),
	GROUP_OK4("da26c865-4ef0-4e33-87fe-54fdec501ec5"),
	GROUP_OK5("998034d9-e3b4-4b42-af79-c804a90471d6"),
	GROUP_INVALID("27hj8f22-845b-4ghd-a473-ce4f66ab83"),
	GROUP_NULL("null");
	
	private String id;
	
	GroupIdsEnum(String id) {
		this.id = id;
}
	
	public String getId() {
		return id;
	}

}
