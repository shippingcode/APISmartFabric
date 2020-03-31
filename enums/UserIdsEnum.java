package com.agys.enums;

/**
 * 
 * @author aila.bogasieru@agys.ch
 *
 */

public enum UserIdsEnum {
	
	USER_OK1("00000000-0000-0000-0000-000000000001"),
	USER_OK2("78c38837-8af3-438a-8560-0d73d8915ceb"),
	USER_OK3("533ab97d-c5dc-4a17-8990-afd9c15ec210"),
	USER_OK4("97a62e19-bbf2-4edc-932a-31a1d2507659"),
	USER_OK5("87c93d66-8fda-492b-ab8a-e278d7270a33"),
	USER_OK6("0c36ad53-0ebb-42cc-8ba8-3207e3dbb820"),
	USER_INVALID("d634b20d-128e-4a57-78cf-7b7c01aeb001"),
	USER_NULL("null");
	
	private String id;
	
	UserIdsEnum(String id) {
		this.id = id;
}
	
	public String getId() {
		return id;
	}

}
