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
public class Engine_Api_ProcessInstance_By_ProcessInstanceIdVersioningTest {

	private String processInstanceId="730fff63-6ffe-42ba-b645-aa97b978be6f";
	private String invalidProcessInstanceId="dsfgdsfd-dfgfdfg-dfgdfg-fgdfg-dfgfdgf";
	private String nullProcessInstanceId="null";

	@Test
	public void getEngineApiProcessInstanceByProcessInstanceIdVersionId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.ENGINE
						+ Endpoints.middleURLEngineApiProcessInstanceVersioning + processInstanceId  + Endpoints.middleURLEngineApiProcessInstanceVersioning1)
				.then().assertThat().statusCode(200);
		log.info("Engine_Api_ProcessInstance_By_ProcessInstanceIdVersioning" + CredentialsUtils.ENGINE
				+ Endpoints.middleURLEngineApiProcessInstanceVersioning + processInstanceId  + Endpoints.middleURLEngineApiProcessInstanceVersioning1);
	}

	@Test
	public void getEngineApiProcessInstanceByInvalidProcessInstanceIdVersionId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.ENGINE
						+ Endpoints.middleURLEngineApiProcessInstanceVersioning + invalidProcessInstanceId  + Endpoints.middleURLEngineApiProcessInstanceVersioning1)
				.then().assertThat().statusCode(404);
		log.info("Engine_Api_ProcessInstance_By_ProcessInstanceIdVersioning" + CredentialsUtils.ENGINE
				+ Endpoints.middleURLEngineApiProcessInstanceVersioning + invalidProcessInstanceId  + Endpoints.middleURLEngineApiProcessInstanceVersioning1);
	}

	@Test
	public void getEngineApiProcessInstanceByProcessInstanceIdNULLversionId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.ENGINE
						+ Endpoints.middleURLEngineApiProcessInstanceVersioning + nullProcessInstanceId  + Endpoints.middleURLEngineApiProcessInstanceVersioning1)
				.then().assertThat().statusCode(400);
		log.info("Engine_Api_ProcessInstance_By_ProcessInstanceIdVersioning" + CredentialsUtils.ENGINE
				+ Endpoints.middleURLEngineApiProcessInstanceVersioning + nullProcessInstanceId  + Endpoints.middleURLEngineApiProcessInstanceVersioning1);
	}


	@Test
	public void getEngineDashboardAppStatisticsNoAuthentication() throws FileNotFoundException {
		given()
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.ENGINE
						+ Endpoints.middleURLEngineApiProcessInstanceVersioning + processInstanceId  + Endpoints.middleURLEngineApiProcessInstanceVersioning1)
				.then().assertThat().statusCode(401);
		log.info("Engine_Api_ProcessInstance_By_ProcessInstanceIdVersioning" + CredentialsUtils.ENGINE
				+ Endpoints.middleURLEngineApiProcessInstanceVersioning + processInstanceId  + Endpoints.middleURLEngineApiProcessInstanceVersioning1);
	}
}
