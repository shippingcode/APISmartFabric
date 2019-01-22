package com.APISmartFabric.Tests.GUIControlRest.GET;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import com.APISmartFabric.Utils.CredentialsUtils;
import static com.jayway.restassured.RestAssured.given;
import java.io.FileNotFoundException;

/**
 * 
@author aila.bogasieru@agys.ch
 *
 */


public class GUI_Control_Revision_SaveTest39 {
	private static final Logger logger = LoggerFactory.getLogger(GUI_Control_Revision_SaveTest39.class);

	@Test
	public void getGUIControlRevisionSave() throws FileNotFoundException {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch�(test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.when().contentType("application/json").get(CredentialsUtils.getProperty("baseURLGUI")
						+ CredentialsUtils.getProperty("middleURLGUIControlRevisionSave"))
					.then().assertThat().statusCode(200);
		logger.info("GUI_Control_Revision_Save" + CredentialsUtils.getProperty("baseURL")
		+ CredentialsUtils.getProperty("middleURLGUIControlRevisionSave"));
	}
	
	
	@Test
	public void getGUIControlRevisionSaveNoAuthentication() throws FileNotFoundException {
		given()	
		.when().contentType("application/json").get(CredentialsUtils.getProperty("baseURLGUI")
				+ CredentialsUtils.getProperty("middleURLGUIControlRevisionSave"))
		.then().assertThat().statusCode(403);
		logger.info("GUI_Control_Revision_Save" + CredentialsUtils.getProperty("baseURL")
		+ CredentialsUtils.getProperty("middleURLGUIControlRevisionSave"));
	}
}