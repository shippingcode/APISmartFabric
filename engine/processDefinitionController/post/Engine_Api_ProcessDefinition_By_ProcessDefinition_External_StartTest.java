package com.agys.engine.processDefinitionController.post;


import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.enums.Environments;
import com.agys.jsonBuilder.EngineApiFlowApprovalSubmit;
import com.agys.jsonBuilder.EngineApiProcessDefinitionExternalStart;
import com.agys.model.Factory;
import com.agys.utils.CredentialsUtils;
import com.agys.utils.JsonHelper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.internal.ValidatableResponseImpl;
import com.jayway.restassured.response.ValidatableResponse;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static com.agys.Constants.PRINCIPAL_HEADER_NAME;
import static com.jayway.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

@Slf4j
public class Engine_Api_ProcessDefinition_By_ProcessDefinition_External_StartTest {

	private ObjectMapper mapper = new ObjectMapper();

	private String additionalProp1 = "APPROVE";
	private String additionalProp2="This is a comment";
	private String additionalProp3="08c2d3e5-5092-419a-bb37-f81d4df9ec95";
	private String processDefinitionId="730fff63-6ffe-42ba-b645-aa97b978be6f";


	EngineApiProcessDefinitionExternalStart engineApiProcessDefinitionExternalStart =
			EngineApiProcessDefinitionExternalStart.builder().additionalProp1(additionalProp1)
			.additionalProp2(additionalProp2).additionalProp3(additionalProp3).
		    build();

	@Test
	public void postEngineApiProcessDefinitionByProcessDefinitionExternalStart() throws JsonProcessingException {

		ValidatableResponse vr =
				given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
						.contentType(ContentType.JSON).body(mapper.writeValueAsString(engineApiProcessDefinitionExternalStart)).when()
						.post(CredentialsUtils.ENGINE + Endpoints.middleEngineApiProcessDefinitionExternalStart
								+ processDefinitionId + Endpoints.middleEngineApiProcessDefinitionExternalStart1)
						.then()
						.statusCode(201);

		String location = ((ValidatableResponseImpl) vr).originalResponse().header("Location");

		String response = given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(Factory.engineApiProcessDefinitionExternalStartClass)).when()
				.get(location)
				.then()
				.contentType(ContentType.JSON).extract().response().asString();

		EngineApiProcessDefinitionExternalStart engineApiProcessDefinitionExternalStart=
				JsonHelper.readValue(response, EngineApiProcessDefinitionExternalStart.class);
		assertEquals(Factory.engineApiProcessDefinitionExternalStartClass.getAdditionalProp1(),
				engineApiProcessDefinitionExternalStart.getAdditionalProp1(), "Additional prop1 are equals");
		assertEquals(Factory.engineApiProcessDefinitionExternalStartClass.getAdditionalProp2(), engineApiProcessDefinitionExternalStart.getAdditionalProp2(), "Additional prop2 are equals");
		assertEquals(Factory.engineApiProcessDefinitionExternalStartClass.getAdditionalProp3(), engineApiProcessDefinitionExternalStart.getAdditionalProp3(), "Additional prop3 are equals");

		Factory.engineApiProcessDefinitionExternalStartClass.setAdditionalProp1(engineApiProcessDefinitionExternalStart.getAdditionalProp1());
		Factory.engineApiProcessDefinitionExternalStartClass.setAdditionalProp2(engineApiProcessDefinitionExternalStart.getAdditionalProp2());
		Factory.engineApiProcessDefinitionExternalStartClass.setAdditionalProp3(engineApiProcessDefinitionExternalStart.getAdditionalProp2());
	}

	@Test
	public void postEngineApiProcessDefinitionByProcessDefinitionExternalStartMissingParameter() throws JsonProcessingException {


		EngineApiProcessDefinitionExternalStart engineApiProcessDefinitionExternalStart1 = EngineApiProcessDefinitionExternalStart.builder().additionalProp1(additionalProp1)
				.additionalProp2(additionalProp2).build();
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(engineApiProcessDefinitionExternalStart1)).when()
				.post(CredentialsUtils.ENGINE + Endpoints.middleEngineApiProcessDefinitionExternalStart
						+ processDefinitionId + Endpoints.middleEngineApiProcessDefinitionExternalStart1)
				.then()
				.statusCode(400);
	}

	@Test
	public void postEngineApiProcessDefinitionByProcessDefinitionExternalStartWrongParameter() throws JsonProcessingException {

		EngineApiProcessDefinitionExternalStart engineApiProcessDefinitionExternalStart2 = EngineApiProcessDefinitionExternalStart.builder().additionalProp1(additionalProp1)
				.processDefinitionId(processDefinitionId).build();

		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(engineApiProcessDefinitionExternalStart2)).when()
				.post(CredentialsUtils.ENGINE + Endpoints.middleEngineApiProcessDefinitionExternalStart
						+ processDefinitionId + Endpoints.middleEngineApiProcessDefinitionExternalStart1)
				.then()
				.statusCode(404);
	}

	@Test
	public void postEngineApiProcessDefinitionByProcessDefinitionExternalStartNoAuthentication() throws JsonProcessingException {

		given()
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(engineApiProcessDefinitionExternalStart)).when()
				.post(CredentialsUtils.ENGINE + Endpoints.middleEngineApiProcessDefinitionExternalStart
						+ processDefinitionId + Endpoints.middleEngineApiProcessDefinitionExternalStart1)
				.then()
				.statusCode(401);
	}
}
