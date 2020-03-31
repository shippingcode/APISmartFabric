package com.agys.engine.appfileTransferController.get;


import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.enums.Environments;
import com.agys.enums.ProcessDefinitionEnum;
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
public class Engine_Api_App_Files_By_FileUUID_By_TypeTest {

	private String fileUUID="c3f294aa-f749-4a3b-a5ee-7dd965b6cb9b";
	private String typeImage="image";
	private String typeProcessdiag="processdiag";
	private String invalidFileUUID="fghfgh-fghg-4a3666b-a5ee-fghgffgh";
	private String invalidType="none";
	private String nullFileUUID="null";
	private String nullType="null";

	@Test
	public void getEngineApiAppFilesByFileUUIDByType() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.ENGINE
						+ Endpoints.middleURLEngineApiAppFiles + fileUUID + typeImage)
					.then().assertThat().statusCode(200);
		log.info("Engine_Api_App_Files_By_FileUUID_By_Type" + CredentialsUtils.ENGINE
				+ Endpoints.middleURLEngineApiAppFiles + fileUUID + typeImage);
	}


	@Test
	public void getEngineApiAppFilesByFileUUIDByDifferentType() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.ENGINE
						+ Endpoints.middleURLEngineApiAppFiles + fileUUID + typeProcessdiag)
				.then().assertThat().statusCode(200);
		log.info("Engine_Api_App_Files_By_FileUUID_By_Type" + CredentialsUtils.ENGINE
				+ Endpoints.middleURLEngineApiAppFiles + fileUUID + typeProcessdiag);
	}


	@Test
	public void getEngineApiAppFilesByFileInvalidUUIDByType() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.ENGINE
						+ Endpoints.middleURLEngineApiAppFiles + invalidFileUUID + typeImage)
				.then().assertThat().statusCode(404);
		log.info("Engine_Api_App_Files_By_FileUUID_By_Type" + CredentialsUtils.ENGINE
				+ Endpoints.middleURLEngineApiAppFiles + invalidFileUUID + typeImage);
	}

	@Test
	public void getEngineApiAppFilesByFileNullUUIDByType() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.ENGINE
						+ Endpoints.middleURLEngineApiAppFiles + nullFileUUID + typeImage)
				.then().assertThat().statusCode(400);
		log.info("Engine_Api_App_Files_By_FileUUID_By_Type" + CredentialsUtils.ENGINE
				+ Endpoints.middleURLEngineApiAppFiles + nullFileUUID + typeImage);
	}

	@Test
	public void getEngineApiAppFilesByFileUUIDByInvalidType() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.ENGINE
						+ Endpoints.middleURLEngineApiAppFiles + fileUUID + invalidType)
				.then().assertThat().statusCode(404);
		log.info("Engine_Api_App_Files_By_FileUUID_By_Type" + (CredentialsUtils.ENGINE
				+ Endpoints.middleURLEngineApiAppFiles + fileUUID + invalidType));
	}

	@Test
	public void getEngineApiAppFilesByFileUUIDByNullType() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.ENGINE
						+ Endpoints.middleURLEngineApiAppFiles + fileUUID + nullType)
				.then().assertThat().statusCode(400);
		log.info("Engine_Api_App_Files_By_FileUUID_By_Type" + (CredentialsUtils.ENGINE
				+ Endpoints.middleURLEngineApiAppFiles + fileUUID + nullType));
	}

	@Test
	public void getEngineApiAppFilesByFileInvalidUUIDByInvalidType() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.getProperty("baseURLEngine")
						+ Endpoints.middleURLEngineApiAppFiles + invalidFileUUID + invalidType)
				.then().assertThat().statusCode(404);
		log.info("Engine_Api_App_Files_By_FileUUID_By_Type" + (CredentialsUtils.getProperty("baseURLEngine")
				+ Endpoints.middleURLEngineApiAppFiles + invalidFileUUID + invalidType));
	}

	@Test
	public void getEngineApiAppFilesByFileNullUUIDByNullType() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.ENGINE
						+ Endpoints.middleURLEngineApiAppFiles + nullFileUUID + nullType)
				.then().assertThat().statusCode(400);
		log.info("Engine_Api_App_Files_By_FileUUID_By_Type" + (CredentialsUtils.ENGINE)
				+ Endpoints.middleURLEngineApiAppFiles + nullFileUUID + nullType);
	}

	@Test
	public void getgetEngineApiAppFilesByFileUUIDByTypedNoAuthentication() throws FileNotFoundException {
		given()
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.ENGINE
				+ Endpoints.middleURLEngineApiAppFiles + fileUUID + typeImage)
				.then().assertThat().statusCode(401);
		log.info("Engine_Api_App_Files_By_FileUUID_By_Type" + (CredentialsUtils.ENGINE
				+ Endpoints.middleURLEngineApiAppFiles + fileUUID + typeImage));
	}
}
