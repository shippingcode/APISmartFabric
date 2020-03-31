package com.agys.gui.guiRest.delete;

import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.enums.Environments;
import com.agys.utils.CredentialsUtils;
import com.jayway.restassured.http.ContentType;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static com.agys.Constants.PRINCIPAL_HEADER_NAME;
import static com.jayway.restassured.RestAssured.given;

/**
 * 
 * @author aila.bogasieru@agys.ch Removes GUI Id
 */

public class GUI_By_IdTest {
	
	private String id="eb87f0c9-227e-9e90-3276-2d9980f1e03b";
	private String invalidId="4364";
	private String nullId="null";

	@Test
	public void deleteGUIByInvalidId() {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON)
				.delete(CredentialsUtils.GUI
						+ Endpoints.middleURLGUI + invalidId)
				.then().statusCode(404);
	}

	@Test
	public void deleteGUIById() {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON)
				.delete(CredentialsUtils.GUI
						+  Endpoints.middleURLGUI +id)
				.then().statusCode(200);
			
	}
	
	@Test
	public void deleteGUIByNULLId() {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON)
				.delete(CredentialsUtils.GUI
						+  Endpoints.middleURLGUI +nullId)
				.then().statusCode(404);
			
	}
	
	@Test
	public void deleteGUIByIddNoAuthentication() {
		given().
		when().contentType(ContentType.JSON)
		.delete(CredentialsUtils.GUI
				+  Endpoints.middleURLGUI
				+id)
				.then().statusCode(401);
	}
}
