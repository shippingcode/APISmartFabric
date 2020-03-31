package com.agys.gui.guiRest.get;


import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.enums.Environments;
import com.agys.utils.CredentialsUtils;
import com.jayway.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

import static com.agys.Constants.PRINCIPAL_HEADER_NAME;
import static com.jayway.restassured.RestAssured.given;

/**
 * 
 * @author aila.bogasieru@agys.ch
 *
 */
@Slf4j
public class GUI_By_IdTest {

	private String id = "8f719613-979c-0f9d-c0bd-d28621d7d53c";
	private String invalidId = "34564645";
	private String nullId = "null";

	@Test
	public void getGUIById() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.GUI + Endpoints.middleURLGUI + id)
				.then().assertThat().statusCode(200);
		log.info("GUI_By_Id" + CredentialsUtils.GUI + Endpoints.middleURLGUI
				+ id);
	}

	@Test
	public void getGUIByInvalidId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE).when().contentType(ContentType.JSON).get(CredentialsUtils.GUI
						+ Endpoints.middleURLGUI + invalidId)
				.then().assertThat().statusCode(404);
		log.info("GUI_By_Id" + CredentialsUtils.GUI + Endpoints.middleURLGUI
				+ invalidId);
	}

	@Test
	public void getGUIByNULLId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE).when().contentType(ContentType.JSON)
				.get(CredentialsUtils.GUI + Endpoints.middleURLGUI + nullId)
				.then().assertThat().statusCode(400);
		log.info("GUI_By_Id" + CredentialsUtils.GUI + Endpoints.middleURLGUI
				+ nullId);
	}

	@Test
	public void getGUIByInvalidIdNoAuthentication() throws FileNotFoundException {
		given().when().contentType(ContentType.JSON)
				.get(CredentialsUtils.GUI + Endpoints.middleURLGUI + id)
				.then().assertThat().statusCode(401);
		log.info("GUI_By_Id" + CredentialsUtils.GUI + Endpoints.middleURLGUI
				+ id);
	}
}
