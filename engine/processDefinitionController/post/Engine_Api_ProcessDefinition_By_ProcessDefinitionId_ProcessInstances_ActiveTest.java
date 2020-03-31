package com.agys.engine.processDefinitionController.post;


import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.enums.Environments;
import com.agys.jsonBuilder.EngineApiProcessDefinitionExternalStart;
import com.agys.jsonBuilder.EngineApiProcessDefinitionProcessInstancesActive;
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
public class Engine_Api_ProcessDefinition_By_ProcessDefinitionId_ProcessInstances_ActiveTest {

	private ObjectMapper mapper = new ObjectMapper();

	private String additionalProp1 = "APPROVE";
	private String additionalProp2="This is a comment";
	private String additionalProp3="08c2d3e5-5092-419a-bb37-f81d4df9ec95";
	private String processDefinitionId="730fff63-6ffe-42ba-b645-aa97b978be6f";
	private String activityIds="3c3fb853-10be-0b99-5220-c7658ec06146";

	EngineApiProcessDefinitionProcessInstancesActive engineApiProcessDefinitionProcessInstancesActive =
			EngineApiProcessDefinitionProcessInstancesActive.builder().activityIds(activityIds).additionalProp1(additionalProp1)
			.additionalProp2(additionalProp2).additionalProp3(additionalProp3).
		    build();

	@Test
	public void postEngineApiProcessDefinitionByProcessDefinitionIdProcessInstancesActive() throws JsonProcessingException {

		ValidatableResponse vr =
				given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
						.contentType(ContentType.JSON).body(mapper.writeValueAsString(engineApiProcessDefinitionProcessInstancesActive)).when()
						.post(CredentialsUtils.ENGINE + Endpoints.middleEngineApiProcessDefinitionExternalStart
								+ processDefinitionId + Endpoints.middleEngineApiProcessDefinitionExternalStart1)
						.then()
						.statusCode(201);

		String location = ((ValidatableResponseImpl) vr).originalResponse().header("Location");

		String response = given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(Factory.engineApiProcessDefinitionProcessInstancesActiveClass)).when()
				.get(location)
				.then()
				.contentType(ContentType.JSON).extract().response().asString();

		EngineApiProcessDefinitionProcessInstancesActive engineApiProcessDefinitionProcessInstancesActive=
				JsonHelper.readValue(response, EngineApiProcessDefinitionProcessInstancesActive.class);
		assertEquals(Factory.engineApiProcessDefinitionProcessInstancesActiveClass.getAdditionalProp1(),
				engineApiProcessDefinitionProcessInstancesActive.getAdditionalProp1(), "Additional prop1 are equals");
		assertEquals(Factory.engineApiProcessDefinitionProcessInstancesActiveClass.getAdditionalProp2(), engineApiProcessDefinitionProcessInstancesActive.getAdditionalProp2(), "Additional prop2 are equals");
		assertEquals(Factory.engineApiProcessDefinitionProcessInstancesActiveClass.getAdditionalProp3(), engineApiProcessDefinitionProcessInstancesActive.getAdditionalProp3(), "Additional prop3 are equals");

		Factory.engineApiProcessDefinitionProcessInstancesActiveClass.setAdditionalProp1(engineApiProcessDefinitionProcessInstancesActive.getAdditionalProp1());
		Factory.engineApiProcessDefinitionProcessInstancesActiveClass.setAdditionalProp2(engineApiProcessDefinitionProcessInstancesActive.getAdditionalProp2());
		Factory.engineApiProcessDefinitionProcessInstancesActiveClass.setAdditionalProp3(engineApiProcessDefinitionProcessInstancesActive.getAdditionalProp2());
	}

	@Test
	public void postEngineApiProcessDefinitionByProcessDefinitionIdProcessInstancesActiveMissingParameter() throws JsonProcessingException {


		EngineApiProcessDefinitionProcessInstancesActive engineApiProcessDefinitionProcessInstancesActive1 =
				EngineApiProcessDefinitionProcessInstancesActive.builder().additionalProp1(additionalProp1)
						.additionalProp2(additionalProp2).additionalProp3(additionalProp3).
						build();
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(engineApiProcessDefinitionProcessInstancesActive1)).when()
				.post(CredentialsUtils.ENGINE + Endpoints.middleEngineApiProcessDefinitionExternalStart
						+ processDefinitionId + Endpoints.middleEngineApiProcessDefinitionExternalStart1)
				.then()
				.statusCode(400);
	}

	@Test
	public void postEngineApiProcessDefinitionByProcessDefinitionIdProcessInstancesActiveWrongParameter() throws JsonProcessingException {

		EngineApiProcessDefinitionProcessInstancesActive engineApiProcessDefinitionProcessInstancesActive2 =
				EngineApiProcessDefinitionProcessInstancesActive.builder().activityIds(activityIds).additionalProp1(additionalProp1)
						.additionalProp2(additionalProp2).processDefinitionId(processDefinitionId).
						build();

		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(engineApiProcessDefinitionProcessInstancesActive2)).
		when()
				.post(CredentialsUtils.ENGINE + Endpoints.middleEngineApiProcessDefinitionExternalStart
						+ processDefinitionId + Endpoints.middleEngineApiProcessDefinitionExternalStart1)
				.then()
				.statusCode(404);
	}

	@Test
	public void postEngineApiProcessDefinitionByProcessDefinitionIdProcessInstancesActiveNoAuthentication() throws JsonProcessingException {

		given()
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(engineApiProcessDefinitionProcessInstancesActive)).when()
				.post(CredentialsUtils.ENGINE + Endpoints.middleEngineApiProcessDefinitionExternalStart
						+ processDefinitionId + Endpoints.middleEngineApiProcessDefinitionExternalStart1)
				.then()
				.statusCode(401);
	}
}
