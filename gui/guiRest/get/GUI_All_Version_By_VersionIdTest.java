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
@author aila.bogasieru@agys.ch
 *
 */

@Slf4j
public class GUI_All_Version_By_VersionIdTest {
	
	private String versionId  ="e0216c9a-6f81-4d12-93f2-8b5f9bd2c2a6";
	private String invalidVersionId = "0";
	private  String nullVersionId ="null";

	@Test
	public void getGUIAllVersionByVersionId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE).
				when().contentType(ContentType.JSON).get(CredentialsUtils.GUI
						+ Endpoints.middleURLGUIAllVersion + versionId)
				.then().assertThat().statusCode(200);
		log.info("GUI_All_Version_By_Version Id" + CredentialsUtils.GUI
				+ Endpoints.middleURLGUIAllVersion + versionId);
	}
	
	@Test
	public void getGUIAllVersionByInvalidVersionId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE).when().contentType(ContentType.JSON).get(CredentialsUtils.GUI
				+ Endpoints.middleURLGUIAllVersion + invalidVersionId)
				.then().assertThat().statusCode(404);
		log.info("GUI_All_Version_By_Version Id" + CredentialsUtils.GUI
		+ CredentialsUtils.getProperty("middleURLGUIAllVersion") + invalidVersionId);
	}
	
	@Test
	public void getGUIAllVersionByNULLVersionId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE).when().contentType(ContentType.JSON).get(CredentialsUtils.GUI
				+ Endpoints.middleURLGUIAllVersion + nullVersionId)
		.then().assertThat().statusCode(400);
		log.info("GUI_All_Version_By_Version Id" + CredentialsUtils.GUI
		+ Endpoints.middleURLGUIAllVersion + nullVersionId);
	}

	
	@Test
	public void getGUIAllVersionByVersionIdNoAuthentication() throws FileNotFoundException {
		given()	
		.when().contentType(ContentType.JSON).get(CredentialsUtils.GUI
				+Endpoints.middleURLGUIAllVersion + versionId)
		.then().assertThat().statusCode(401);
		log.info("GUI_All_Version_By_Version Id" + CredentialsUtils.GUI
				+ Endpoints.middleURLGUIAllVersion + versionId);
	}
}
