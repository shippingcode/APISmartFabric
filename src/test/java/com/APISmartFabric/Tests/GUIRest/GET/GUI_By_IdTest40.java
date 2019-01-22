package com.APISmartFabric.Tests.GUIRest.GET;


import org.testng.annotations.Test;
import com.APISmartFabric.Utils.CredentialsUtils;
import com.jayway.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;
import static com.jayway.restassured.RestAssured.given;
import java.io.FileNotFoundException;

/**
 * 
 * @author aila.bogasieru@agys.ch
 *
 */
@Slf4j
public class GUI_By_IdTest40 {

	private String id = "8f719613-979c-0f9d-c0bd-d28621d7d53c";
	private String invalidId = "34564645";
	private String nullId = "null";

	@Test
	public void getGUIById() throws FileNotFoundException {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.getProperty("baseURLGUI") + CredentialsUtils.getProperty("middleURLGUI") + id)
				.then().assertThat().statusCode(200);
		log.info("GUI_By_Id" + CredentialsUtils.getProperty("baseURL") + CredentialsUtils.getProperty("middleURLGUI")
				+ id);
	}

	@Test
	public void getGUIByInvalidId() throws FileNotFoundException {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.when().contentType(ContentType.JSON).get(CredentialsUtils.getProperty("baseURLGUI")
						+ CredentialsUtils.getProperty("middleURLGUI") + invalidId)
				.then().assertThat().statusCode(404);
		log.info("GUI_By_Id" + CredentialsUtils.getProperty("baseURL") + CredentialsUtils.getProperty("middleURLGUI")
				+ invalidId);
	}

	@Test
	public void getGUIByNULLId() throws FileNotFoundException {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.getProperty("baseURLGUI") + CredentialsUtils.getProperty("middleURLGUI") + nullId)
				.then().assertThat().statusCode(404);
		log.info("GUI_By_Id" + CredentialsUtils.getProperty("baseURL") + CredentialsUtils.getProperty("middleURLGUI")
				+ nullId);
	}

	@Test
	public void getGUIByInvalidIdNoAuthentication() throws FileNotFoundException {
		given().when().contentType(ContentType.JSON)
				.get(CredentialsUtils.getProperty("baseURLGUI") + CredentialsUtils.getProperty("middleURLGUI") + id)
				.then().assertThat().statusCode(403);
		log.info("GUI_By_Id" + CredentialsUtils.getProperty("baseURL") + CredentialsUtils.getProperty("middleURLGUI")
				+ id);
	}
}
