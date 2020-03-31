package com.agys.enums;

/**
 * 
 * @author aila.bogasieru@agys.ch
 *
 */

public enum UsersGroupsIdsEnum {
	
	USERSGROUPS_OK1("e1bf7e32-6846-473c-88df-0b59b4dd5870"),
	USERSGROUPS_OK2("f13f18aa-1b13-48bb-bf5d-ba0417ff43e5"),
	USERSGROUPS_OK3("cd141342-224a-4c3f-a37a-1f8f6a112e5a"),
	USERSGROUPS_OK4("3060ae3e-fd8e-4614-8fea-083a4cde5695"),
	USERSGROUPS_OK5("5d1f37c1-80f9-493c-b6cc-eec48f0f87fb"),
	USERSGROUPS_INVALID("a8fghj412625c-75677-4bc4-8b65-f9ajk894631"),
	USERSGROUPS_NULL("null");
	
	private String id;
	
	UsersGroupsIdsEnum(String id) {
		this.id = id;
}
	
	public String getId() {
		return id;
	}

}
