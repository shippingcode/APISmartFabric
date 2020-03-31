package com.agys.engine.processDefinitionController.get;


import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.enums.Environments;
import com.agys.utils.CredentialsUtils;
import com.jayway.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;
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
public class Engine_Api_ProcessDefinition_Activities_By_ProcessDefinitionIdTest {

	private String processDefinitionId="730fff63-6ffe-42ba-b645-aa97b978be6f";
	private String invalidProcessDefinitionId="3c3567853-10be-ghj-6765757-56765";
   	private String nullProcessDefinitionId="null";

	
	@Test
	public void getEngineApiProcessDefinitionByProcessDefinitionIdStart() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.ENGINE
						+ Endpoints.middleURLEngineApiProcessDefinitionActivities + processDefinitionId)
					.then().assertThat().statusCode(200);
		log.info("Engine_Api_ProcessDefinition_Activities_By_ProcessDefinitionId" + CredentialsUtils.ENGINE
				+ Endpoints.middleURLEngineApiProcessDefinitionActivities + processDefinitionId);
	}


	@Test
	public void getEngineApiProcessDefinitionByInvalidProcessDefinitionIdStart() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.ENGINE
						+ Endpoints.middleURLEngineApiProcessDefinitionActivities + invalidProcessDefinitionId)
				.then().assertThat().statusCode(404);
		log.info("Engine_Api_ProcessDefinition_Activities_By_ProcessDefinitionId" + CredentialsUtils.ENGINE
				+ Endpoints.middleURLEngineApiProcessDefinitionActivities + invalidProcessDefinitionId);
	}


	@Test
	public void getEngineApiProcessDefinitionByNULLProcessDefinitionIdStart() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.ENGINE
						+ Endpoints.middleURLEngineApiProcessDefinitionActivities + nullProcessDefinitionId)
				.then().assertThat().statusCode(400);
		log.info("Engine_Api_ProcessDefinition_Activities_By_ProcessDefinitionId" + (CredentialsUtils.ENGINE
				+ Endpoints.middleURLEngineApiProcessDefinitionActivities + nullProcessDefinitionId));
	}

	@Test
	public void getEngineApiProcessDefinitionByProcessDefinitionIdStartNoAuthentication() throws FileNotFoundException {
		given()
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.ENGINE
						+ Endpoints.middleURLEngineApiProcessDefinitionActivities + processDefinitionId)
				.then().assertThat().statusCode(401);
		log.info("Engine_Api_ProcessDefinition_Activities_By_ProcessDefinitionId" + CredentialsUtils.ENGINE
				+ Endpoints.middleURLEngineApiProcessDefinitionActivities + processDefinitionId);
	}
}
