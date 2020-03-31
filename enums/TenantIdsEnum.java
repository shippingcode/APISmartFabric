package com.agys.enums;

/**
 * 
 * @author aila.bogasieru@agys.ch
 *
 */

public enum TenantIdsEnum {
	
	TENANT_OK1("d634b20d-128e-4a57-97cf-7b7b01aeb901"),
	TENANT_OK2("aa1f20d6-21c7-42d3-afdd-9e6267ed874a"),
	TENANT_OK3("c33e30f4-12a9-460b-8e1e-3dd4195d7396"),
	TENANT_OK4("4ecc9ec0-16c8-48a2-a255-bb428a1ab2ce"),
	TENANT_OK5("844abbbf-9a09-4dfa-969c-dc65952c3db1"),
	TENANT_INVALID("dGH0d16-6f03-4dff-a485-8d456376cac0"),
	TENANT_NULL("null");
	
	private String id;
	
	TenantIdsEnum(String id) {
		this.id = id;
}
	
	public String getId() {
		return id;
	}
}
