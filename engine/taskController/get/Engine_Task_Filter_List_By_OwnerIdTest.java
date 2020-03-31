package com.agys.engine.taskController.get;


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
public class Engine_Task_Filter_List_By_OwnerIdTest {

	private String ownerId="3e420496-344b-4702-a11d-72e024774bac";
	private String invalidOwnerId="546756765-57567-5676576-567657-567657";
   	private String nullOwnerId="null";


	@Test
	public void getEngineTaskFilterListByOwnerId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.ENGINE
						+ Endpoints.middleEngineTaskFilterList + ownerId)
					.then().assertThat().statusCode(200);
		log.info("Engine Task Filter List By Owner Id" + CredentialsUtils.ENGINE
				+ Endpoints.middleEngineTaskFilterList + ownerId);
	}


	@Test
	public void getEngineTaskFilterListByInvalidOwnerId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.ENGINE
						+ Endpoints.middleEngineTaskFilterList + invalidOwnerId)
				.then().assertThat().statusCode(404);
		log.info("Engine Task Filter List By Owner Id" + CredentialsUtils.ENGINE
				+ Endpoints.middleEngineTaskFilterList + invalidOwnerId);
	}


	@Test
	public void getEngineTaskFilterListByNULLOwnerId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.ENGINE
						+ Endpoints.middleEngineTaskFilterList + nullOwnerId)
				.then().assertThat().statusCode(400);
		log.info("Engine Task Filter List By Owner Id" + CredentialsUtils.ENGINE
				+ Endpoints.middleEngineTaskFilterList + nullOwnerId);
	}

	@Test
	public void getEngineTaskFilterListByOwnerIdNoAuthentication() throws FileNotFoundException {
		given()
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.ENGINE
						+ Endpoints.middleEngineTaskFilterList + ownerId)
				.then().assertThat().statusCode(401);
		log.info("Engine Task Filter List By Owner Id" + CredentialsUtils.ENGINE
				+ Endpoints.middleEngineTaskFilterList + ownerId);
	}
}
