package com.agys.engine.processDefinitionController.post;


import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.enums.Environments;
import com.agys.jsonBuilder.EngineApiProcessDefinitionExternalStart;
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
public class Engine_Api_Process_Definition_InsertTest {

	private ObjectMapper mapper = new ObjectMapper();

	private String image = "C://Downloads/img.gif";
	private String processDefinitionModel="{\"id\":null,\"versionId\":\"e0216c9a-6f81-4d12-93f2-8b5f9bd2c2a6\",\"type\":null,\"active\":true,\"name\":\"apiProcessDefModel\",\"blockchainEnabled\":false,\"code\":\"4d66caed-6d5a-14b5-5e10-12be50811f5f\",\"description\":null,\"iteration\":0,\"blockchainType\":\"STANDARD\"}";
	private String taskId="34534564-fddgdfg-345345";

	EngineApiProcessDefinitionInsert engineApiProcessDefinitionInsert =
			EngineApiProcessDefinitionInsert.builder().image(image)
			.processDefinitionModel(processDefinitionModel).build();

	@Test
	public void postEngineApiProcessDefinitionInsert() throws JsonProcessingException {

		ValidatableResponse vr =
				given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
						.contentType(ContentType.JSON).body(mapper.writeValueAsString(engineApiProcessDefinitionInsert)).when()
						.post(CredentialsUtils.ENGINE + Endpoints.middleEngineApiProcessDefinitionInsert	)
						.then()
						.statusCode(201);

		String location = ((ValidatableResponseImpl) vr).originalResponse().header("Location");

		String response = given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(Factory.engineApiProcessDefinitionInsertClass)).when()
				.get(location)
				.then()
				.contentType(ContentType.JSON).extract().response().asString();

		EngineApiProcessDefinitionInsert engineApiProcessDefinitionInsert=
				JsonHelper.readValue(response, EngineApiProcessDefinitionInsert.class);
		assertEquals(Factory.engineApiProcessDefinitionInsertClass.getImage(),
				engineApiProcessDefinitionInsert.getImage(), "Images are the same");
		assertEquals(Factory.engineApiProcessDefinitionInsertClass.getProcessDefinitionModel(), engineApiProcessDefinitionInsert.getProcessDefinitionModel(), "Process definition models  are equals");


		Factory.engineApiProcessDefinitionInsertClass.setProcessDefinitionModel(engineApiProcessDefinitionInsert.getProcessDefinitionModel());
	}

	@Test
	public void postEngineApiProcessDefinitionInsertMissingParameter() throws JsonProcessingException {

		EngineApiProcessDefinitionInsert engineApiProcessDefinitionInsert1 =
				EngineApiProcessDefinitionInsert.builder().processDefinitionModel(processDefinitionModel).build();
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(engineApiProcessDefinitionInsert1)).when()
				.post(CredentialsUtils.ENGINE + Endpoints. middleEngineApiProcessDefinitionInsert)
				.then()
				.statusCode(400);
	}

	@Test
	public void postEngineApiProcessDefinitionInsertWrongParameter() throws JsonProcessingException {

		EngineApiProcessDefinitionInsert engineApiProcessDefinitionInsert2 =
				EngineApiProcessDefinitionInsert.builder().image(image)
						.processDefinitionModel(processDefinitionModel).
						taskId(taskId).build();

		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(engineApiProcessDefinitionInsert2)).when()
				.post(CredentialsUtils.ENGINE + Endpoints.middleEngineApiProcessDefinitionInsert)
				.then()
				.statusCode(404);
	}

	@Test
	public void postEngineApiProcessDefinitionInsertNoAuthentication() throws JsonProcessingException {

		given()
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(engineApiProcessDefinitionInsert)).when()
				.post(CredentialsUtils.ENGINE + Endpoints.middleEngineApiProcessDefinitionInsert)
				.then()
				.statusCode(401);
	}
}
