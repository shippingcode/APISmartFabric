package com.agys.gui.get;


import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.enums.Environments;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.agys.utils.CredentialsUtils;
import com.jayway.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;

import static com.agys.Constants.PRINCIPAL_HEADER_NAME;
import static com.jayway.restassured.RestAssured.given;
import java.io.FileNotFoundException;

/**
 * 
@author aila.bogasieru@agys.ch
 *
 */

@Slf4j
public class GUI_Control_Id_By_IdTest {
	
	private String id  ="d8ebe677-3b25-68d3-d61c-c62e06eb0d0b";
	private String invalidId ="35346546";
	private String nullId ="null";

	@Test
	public void getGUIControlIdById() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON).get(CredentialsUtils.GUI
						+ Endpoints.middleURLGUIControlId + id)
				.then().assertThat().statusCode(200);
		log.info("GUI_Control_Id_By_Id" + CredentialsUtils.GUI
				+ Endpoints.middleURLGUIControlId + id);
	}
	
	@Test
	public void getGUIControlIdByInvalidId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE).when().contentType(ContentType.JSON).get(CredentialsUtils.GUI
						+ Endpoints.middleURLGUIControlId + invalidId)
				.then().assertThat().statusCode(404);
		log.info("GUI_Control_Id_By_Id" + CredentialsUtils.GUI
		+ Endpoints.middleURLGUIControlId + invalidId);
	}
	
	@Test
	public void getGUIControlIdByNULLId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE).when().contentType(ContentType.JSON).get(CredentialsUtils.GUI
				+ Endpoints.middleURLGUIControlId + nullId)
		.then().assertThat().statusCode(400);
		log.info("GUI_Control_Id_By_Id" + CredentialsUtils.GUI
		+ Endpoints.middleURLGUIControlId + nullId);
	}


	
	@Test
	public void getGUIControlIdByIdNoAuthentication() throws FileNotFoundException {
		given()	
		.when().contentType(ContentType.JSON).get(CredentialsUtils.GUI
				+ Endpoints.middleURLGUIControlId + id)
		.then().assertThat().statusCode(401);
		log.info("GUI_Control_Id_By_Id" + CredentialsUtils.GUI
		+ Endpoints.middleURLGUIControlId + id);
	}
}
