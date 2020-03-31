package com.agys.enums;

/**
 * 
 * @author aila.bogasieru@agys.ch
 *
 */

public enum TenantDomainEnum {
	
	TENANT_DOMAIN_OK1("domain.18613"),
	TENANT_DOMAIN_OK2("domain.3670f"),
	TENANT_DOMAIN_OK3("domain.d6264"),
	TENANT_DOMAIN_OK4("domain.9914a"),
	TENANT_DOMAIN_OK5("domain.28e2c"),
	TENANT_DOMAIN_INVALID("domain.4777db"),
	TENANT_DOMAIN_NULL("null");
	
	private String id;
	
	TenantDomainEnum(String id) {
		this.id = id;
}
	
	public String getId() {
		return id;
	}
}
