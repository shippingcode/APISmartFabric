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
public class Engine_Api_ProcessDefinition_By_ProcessDefinitionIdProcessInstancesFinishedTest {

	private String processDefinitionId="730fff63-6ffe-42ba-b645-aa97b978be6f";
	private String invalidProcessDefinitionId="3c3567853-10be-ghj-6765757-56765";
   	private String nullProcessDefinitionId="null";

	
	@Test
	public void getEngineApiProcessDefinitionByProcessDefinitionIdProcessInstancesFinished() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.ENGINE
						+ Endpoints.middleURLEngineApiProcessDefinition + processDefinitionId +  Endpoints.middleURLEngineApiProcessDefinition3)
					.then().assertThat().statusCode(200);
		log.info("Engine_Api_ProcessDefinition_By_ProcessDefinitionIdProcessInstancesFinished" + CredentialsUtils.ENGINE
				+ Endpoints.middleURLEngineApiProcessDefinition + processDefinitionId +  Endpoints.middleURLEngineApiProcessDefinition3);
	}


	@Test
	public void getEngineApiProcessDefinitionByInvalidProcessDefinitionIdProcessInstancesFinished() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.ENGINE
						+ Endpoints.middleURLEngineApiProcessDefinition + invalidProcessDefinitionId +  Endpoints.middleURLEngineApiProcessDefinition3)
				.then().assertThat().statusCode(404);
		log.info("Engine_Api_ProcessDefinition_By_ProcessDefinitionIdProcessInstancesFinished" + CredentialsUtils.ENGINE
				+ Endpoints.middleURLEngineApiProcessDefinition + invalidProcessDefinitionId +  Endpoints.middleURLEngineApiProcessDefinition3);
	}


	@Test
	public void getEngineApiProcessDefinitionByNULLProcessDefinitionIdProcessInstancesFinished() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.ENGINE
						+ Endpoints.middleURLEngineApiProcessDefinition + nullProcessDefinitionId +  Endpoints.middleURLEngineApiProcessDefinition3)
				.then().assertThat().statusCode(400);
		log.info("Engine_Api_ProcessDefinition_By_ProcessDefinitionIdProcessInstancesFinished" + CredentialsUtils.ENGINE
				+ Endpoints.middleURLEngineApiProcessDefinition + nullProcessDefinitionId +  Endpoints.middleURLEngineApiProcessDefinition3);
	}

	@Test
	public void getEngineApiProcessDefinitionByProcessDefinitionIdProcessInstancesFinishedNoAuthentication() throws FileNotFoundException {
		given()
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.ENGINE
						+ Endpoints.middleURLEngineApiProcessDefinition + processDefinitionId +  Endpoints.middleURLEngineApiProcessDefinition3)
				.then().assertThat().statusCode(401);
		log.info("Engine_Api_ProcessDefinition_By_ProcessDefinitionIdProcessInstancesFinished" + CredentialsUtils.ENGINE
				+ Endpoints.middleURLEngineApiProcessDefinition + processDefinitionId +  Endpoints.middleURLEngineApiProcessDefinition3);
	}
}
