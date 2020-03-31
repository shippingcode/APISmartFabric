package com.agys.enums;

/**
 * 
 * @author aila.bogasieru@agys.ch
 *
 */

public enum DocumentsIdsEnum {
	
	DOCUMENT_OK1("e34c14f6-b69e-ffb7-a78e-e364548d429d"),
	DOCUMENT_OK2("9d8adcb5-050e-34d2-c54f-0de2ecc52ef4"),
	DOCUMENT_OK3("b0d39202-6600-9e22-2da3-aff8bb745f90"),
	DOCUMENT_OK4("565b4d4e-7ec1-4ada-bbb7-3bb769a56bf6"),
	DOCUMENT_OK5("708b2cf1-bc2b-4d4e-8d1a-d5f85c4e8177"),
	DOCUMENT_INVALID("7456562cf1-bc2b-4d4f45555ghgfh-8d1a-d5f85345gfhe8177"),
	DOCUMENT_NULL("null");
	
	private String id;
	
	DocumentsIdsEnum(String id) {
		this.id = id;
}
	
	public String getId() {
		return id;
	}

}
