package com.agys.engine.taskController.post;


import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.enums.Environments;
import com.agys.jsonBuilder.EngineApiProcessDefinitionInsert;
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
public class Engine_Task_Caim_By_TaskIdTest {

	private String taskId="08c2d3e5-5092-419a-bb37-f81d4df9ec95";
	private String invalidTaskId="5654654-6546-419a-6546-f81d4df9ec95";


	@Test
	public void postEngineTaskCaimByTaskId() throws JsonProcessingException {

		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).when()
				.post(CredentialsUtils.ENGINE + Endpoints.middleEngineTaskClaim +taskId)
				.then()
				.statusCode(201);
	}

	@Test
	public void postEngineTaskCaimByTaskIdMissingParameter() throws JsonProcessingException {


		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).when()
				.post(CredentialsUtils.ENGINE+ Endpoints. middleEngineTaskClaim)
				.then()
				.statusCode(400);
	}

	@Test
	public void postEngineTaskCaimByTaskIdWrongParameter() throws JsonProcessingException {


		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).when()
				.post(CredentialsUtils.ENGINE+ Endpoints.middleEngineTaskClaim + invalidTaskId)
				.then()
				.statusCode(404);
	}

	@Test
	public void postEngineTaskCaimByTaskIdNoAuthentication() throws JsonProcessingException {

		given()
				.contentType(ContentType.JSON).when()
				.post(CredentialsUtils.ENGINE + Endpoints.middleEngineTaskClaim +taskId)
				.then()
				.statusCode(401);
	}
}
