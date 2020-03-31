package com.agys.engine.processInstanceController.post;


import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.enums.Environments;
import com.agys.jsonBuilder.EngineApiProcessDefinitionInsert;
import com.agys.jsonBuilder.EngineApiProcessInstanceBlockchainResult;
import com.agys.model.Factory;
import com.agys.utils.CredentialsUtils;
import com.agys.utils.JsonHelper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.internal.ValidatableResponseImpl;
import com.jayway.restassured.response.ValidatableResponse;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import static com.agys.Constants.PRINCIPAL_HEADER_NAME;
import static com.jayway.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

@Slf4j
public class Engine_Api_ProcessInstance_By_ProcessInstanceId_Blockchain_ResultTest {

	private ObjectMapper mapper = new ObjectMapper();

	private String processInstanceId="730fff63-6ffe-42ba-b645-aa97b978be6f";
	private String invalidProcessInstanceId="dsfgdsfd-dfgfdfg-dfgdfg-fgdfg-dfgfdgf";

	EngineApiProcessInstanceBlockchainResult engineApiProcessInstanceByProcessInstanceIdBlockchainResult =
			EngineApiProcessInstanceBlockchainResult.builder().processInstanceId(processInstanceId).build();

	@Test
	public void postEngineApiProcessInstanceByProcessInstanceIdBlockchainResult() throws JsonProcessingException {

		ValidatableResponse vr =
				given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
						.contentType(ContentType.JSON).body(mapper.writeValueAsString(engineApiProcessInstanceByProcessInstanceIdBlockchainResult)).when()
						.post(CredentialsUtils.ENGINE + Endpoints.middleEngineApiProcessInstanceBlockchainResult
								+ processInstanceId +Endpoints.middleEngineApiProcessInstanceBlockchainResult1)
						.then()
						.statusCode(201);

		String location = ((ValidatableResponseImpl) vr).originalResponse().header("Location");

		String response = given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(Factory.engineApiProcessDefinitionInsertClass)).when()
				.get(location)
				.then()
				.contentType(ContentType.JSON).extract().response().asString();

		EngineApiProcessInstanceBlockchainResult engineApiProcessInstanceBlockchainResult=
				JsonHelper.readValue(response, EngineApiProcessInstanceBlockchainResult.class);
		assertEquals(Factory.engineApiProcessInstanceBlockchainResultClass.getProcessInstanceId(),
				engineApiProcessInstanceBlockchainResult.getProcessInstanceId(), "Process instance ids are equals");

		Factory.engineApiProcessInstanceBlockchainResultClass.setProcessInstanceId(engineApiProcessInstanceBlockchainResult.getProcessInstanceId());
	}

	@Test
	public void postEngineApiProcessInstanceByProcessInstanceIdBlockchainResultMissingParameter() throws JsonProcessingException {

		EngineApiProcessInstanceBlockchainResult engineApiProcessInstanceByProcessInstanceIdBlockchainResult1 =
				EngineApiProcessInstanceBlockchainResult.builder().build();
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(engineApiProcessInstanceByProcessInstanceIdBlockchainResult1)).when()
				.post(CredentialsUtils.ENGINE+ Endpoints.middleEngineApiProcessInstanceBlockchainResult
						+ processInstanceId +Endpoints.middleEngineApiProcessInstanceBlockchainResult1)
				.then()
				.statusCode(400);
	}

	@Test
	public void postEngineApiProcessInstanceByProcessInstanceIdBlockchainResultWrongParameter() throws JsonProcessingException {

		EngineApiProcessInstanceBlockchainResult engineApiProcessInstanceByProcessInstanceIdBlockchainResult2 =
				EngineApiProcessInstanceBlockchainResult.builder().invalidProcessInstanceId(invalidProcessInstanceId).
				build();

		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(engineApiProcessInstanceByProcessInstanceIdBlockchainResult2)).when()
				.post(CredentialsUtils.ENGINE + Endpoints.middleEngineApiProcessInstanceBlockchainResult
						+ processInstanceId +Endpoints.middleEngineApiProcessInstanceBlockchainResult1)
				.then()
				.statusCode(404);
	}

	@Test
	public void postEngineApiProcessInstanceByProcessInstanceIdBlockchainResultNoAuthentication() throws JsonProcessingException {

		given()
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(engineApiProcessInstanceByProcessInstanceIdBlockchainResult)).when()
				.post(CredentialsUtils.ENGINE + Endpoints.middleEngineApiProcessInstanceBlockchainResult
						+ processInstanceId + Endpoints.middleEngineApiProcessInstanceBlockchainResult1)
				.then()
				.statusCode(401);
	}
}
