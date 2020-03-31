package com.agys.engine.genericFlowController.post;


import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.enums.Environments;
import com.agys.jsonBuilder.DataCatalogsContentVersion;
import com.agys.jsonBuilder.EngineApiFlowApprovalSubmit;
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
public class Engine_Api_Flow_ApprovalSubmitTest {

	private ObjectMapper mapper = new ObjectMapper();

	private String actionCode = "APPROVE";
	private String comment="This is a comment";
	private String taskId="08c2d3e5-5092-419a-bb37-f81d4df9ec95";
	private String wrongTaskId="08c2d3e5-sdfdfg-46gdr-bb37-d45ytry";


	EngineApiFlowApprovalSubmit engineApiFlowApprovalSubmit = EngineApiFlowApprovalSubmit.builder().actionCode(actionCode)
			.comment(comment).taskId(taskId).
		    build();

	@Test
	public void postEngineApiFlowApprovalSubmit() throws JsonProcessingException {

		ValidatableResponse vr =
				given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
						.contentType(ContentType.JSON).body(mapper.writeValueAsString(engineApiFlowApprovalSubmit)).when()
						.post(CredentialsUtils.ENGINE + Endpoints.middleURLEngineApiFlowApprovalSubmit)
						.then()
						.statusCode(201);

		String location = ((ValidatableResponseImpl) vr).originalResponse().header("Location");

		String response = given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(Factory.engineApiFlowApprovalSubmitClass)).when()
				.get(location)
				.then()
				.contentType(ContentType.JSON).extract().response().asString();

		EngineApiFlowApprovalSubmit engineApiFlowApprovalSubmit= JsonHelper.readValue(response, EngineApiFlowApprovalSubmit.class);
		assertEquals(Factory.engineApiFlowApprovalSubmitClass.getActionCode(), engineApiFlowApprovalSubmit.getActionCode(), "Actions code are equals");
		assertEquals(Factory.engineApiFlowApprovalSubmitClass.getComment(), engineApiFlowApprovalSubmit.getComment(), "Comments are equals");
		assertEquals(Factory.engineApiFlowApprovalSubmitClass.getTaskId(), engineApiFlowApprovalSubmit.getTaskId(), "Task ids are equals");

		Factory.engineApiFlowApprovalSubmitClass.setActionCode(engineApiFlowApprovalSubmit.getActionCode());
		Factory.engineApiFlowApprovalSubmitClass.setComment(engineApiFlowApprovalSubmit.getComment());
		Factory.engineApiFlowApprovalSubmitClass.setTaskId(engineApiFlowApprovalSubmit.getTaskId());
	}

	@Test
	public void postEngineApiFlowApprovalSubmitMissingParameter() throws JsonProcessingException {


		EngineApiFlowApprovalSubmit engineApiFlowApprovalSubmit1 = EngineApiFlowApprovalSubmit.builder().actionCode(actionCode)
				.comment(comment).build();
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(engineApiFlowApprovalSubmit1)).when()
				.post(CredentialsUtils.ENGINE + Endpoints.middleURLEngineApiFlowApprovalSubmit)
				.then()
				.statusCode(400);
	}

	@Test
	public void postEngineApiFlowApprovalSubmitWrongParameter() throws JsonProcessingException {

		EngineApiFlowApprovalSubmit engineApiFlowApprovalSubmitWrong = EngineApiFlowApprovalSubmit.builder().actionCode(actionCode)
				.comment(comment).wrongTaskId(wrongTaskId).
						build();

		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(engineApiFlowApprovalSubmitWrong)).when()
				.post(CredentialsUtils.ENGINE + Endpoints.middleURLEngineApiFlowApprovalSubmit)
				.then()
				.statusCode(404);
	}

	@Test
	public void postEngineApiFlowApprovalSubmitNoAuthentication() throws JsonProcessingException {

		given()
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(engineApiFlowApprovalSubmit)).when()
				.post(CredentialsUtils.ENGINE + Endpoints.middleURLEngineApiFlowApprovalSubmit)
				.then()
				.statusCode(401);
	}
}
