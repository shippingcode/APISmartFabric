package com.APISmartFabric.Tests.GUIRest.DELETE;

import org.testng.annotations.Test;
import com.APISmartFabric.Utils.CredentialsUtils;
import com.jayway.restassured.http.ContentType;
import static com.jayway.restassured.RestAssured.given;

/**
 * 
 * @author aila.bogasieru@agys.ch Removes GUI Id
 */

public class GUI_By_IdTest41 {
	
	private String id="8b157cb6-4fc8-9026-2527-aca1c48feae0";
	private String invalidId="4364";
	private String nullId="null";


	@Test
	public void deleteGroupIdInvalid() {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.when().contentType(ContentType.JSON)
				.delete(CredentialsUtils.getProperty("baseURL")
						+ CredentialsUtils.getProperty("middleURLTenantsUserGroups") + invalidId)
				.then().statusCode(404);
	}

	@Test
	public void deleteGroupIdValid() {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.when().contentType(ContentType.JSON)
				.delete(CredentialsUtils.getProperty("baseURL")
						+ CredentialsUtils.getProperty("middleURLTenantsUserGroups") +id)
				.then().statusCode(200);
			
	}
	
	@Test
	public void deleteGroupNULLId() {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.when().contentType(ContentType.JSON)
				.delete(CredentialsUtils.getProperty("baseURL")
						+ CredentialsUtils.getProperty("middleURLTenantsUserGroups") +nullId)
				.then().statusCode(404);
			
	}
	
	@Test
	public void deleteGroupIdValidNoAuthentication() {
		given().
		when().contentType(ContentType.JSON)
		.delete(CredentialsUtils.getProperty("baseURL")
				+ CredentialsUtils.getProperty("middleURLTenantsUserGroups")
				+id)
				.then().statusCode(403);
	}
}
