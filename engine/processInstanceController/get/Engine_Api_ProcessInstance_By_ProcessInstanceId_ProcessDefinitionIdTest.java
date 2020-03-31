package com.agys.engine.processInstanceController.get;


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
public class Engine_Api_ProcessInstance_By_ProcessInstanceId_ProcessDefinitionIdTest {

	private String processInstanceId="21eca05d-7581-4f22-86e7-a6d7a403ab30";
	private String invalidProcessInstanceId="3c3567853-10be-ghj-6765757-56765";
   	private String nullProcessInstanceId="null";

	@Test
	public void getEngineApiProcessInstanceByProcessInstanceIdProcessDefinitionId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.ENGINE
						+ Endpoints.middleURLEngineApiProcessInstanceProcessDefinition +
						processInstanceId + Endpoints.middleURLEngineApiProcessInstanceProcessDefinition1)
					.then().assertThat().statusCode(200);
		log.info("Engine_Api_ProcessInstance_By_ProcessInstanceId_ProcessDefinitionId" + CredentialsUtils.ENGINE
				+ Endpoints.middleURLEngineApiProcessInstanceProcessDefinition +
				processInstanceId + Endpoints.middleURLEngineApiProcessInstanceProcessDefinition1);
	}


	@Test
	public void getEngineApiProcessInstanceByInvalidProcessInstanceIdProcessDefinitionId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.ENGINE
						+ Endpoints.middleURLEngineApiProcessInstanceProcessDefinition +
						invalidProcessInstanceId + Endpoints.middleURLEngineApiProcessInstanceProcessDefinition1)
				.then().assertThat().statusCode(404);
		log.info("Engine_Api_ProcessInstance_By_ProcessInstanceId_ProcessDefinitionId" + CredentialsUtils.ENGINE
				+ Endpoints.middleURLEngineApiProcessInstanceProcessDefinition +
				invalidProcessInstanceId + Endpoints.middleURLEngineApiProcessInstanceProcessDefinition1);
	}


	@Test
	public void getEngineApiProcessInstanceByNULLProcessInstanceIdProcessDefinitionId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.ENGINE
						+ Endpoints.middleURLEngineApiProcessInstanceProcessDefinition +
						nullProcessInstanceId + Endpoints.middleURLEngineApiProcessInstanceProcessDefinition1)
				.then().assertThat().statusCode(400);
		log.info("Catalog_Data_Catalogs_Definition_Version_By_VersionId_ProcessDefinitionId_By_ProcessDefinitionId" + CredentialsUtils.ENGINE
				+ Endpoints.middleURLEngineApiProcessInstanceProcessDefinition +
				nullProcessInstanceId + Endpoints.middleURLEngineApiProcessInstanceProcessDefinition1);
	}

	@Test
	public void getEngineApiProcessInstanceByProcessInstanceIdProcessDefinitionIdNoAuthentication() throws FileNotFoundException {
		given()
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.ENGINE
						+ Endpoints.middleURLEngineApiProcessInstanceProcessDefinition +
						processInstanceId + Endpoints.middleURLEngineApiProcessInstanceProcessDefinition1)
				.then().assertThat().statusCode(401);
		log.info("Catalog_Data_Catalogs_Definition_Version_By_VersionId_ProcessDefinitionId_By_ProcessDefinitionId" + CredentialsUtils.ENGINE
				+ Endpoints.middleURLEngineApiProcessInstanceProcessDefinition +
				processInstanceId + Endpoints.middleURLEngineApiProcessInstanceProcessDefinition1);
	}
}
