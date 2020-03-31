package com.agys.engine.genericFlowController.post;


import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.enums.Environments;
import com.agys.jsonBuilder.EngineApiFlowApprovalSubmit;
import com.agys.jsonBuilder.EngineApiFlowGuiSubmit;
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
public class Engine_Api_Flow_GuiSubmitTest {

	private ObjectMapper mapper = new ObjectMapper();

	private String actionId = "9c524b76-146e-65f9-bce4-0b87194bb4f1";
	private String comment="This is a comment";
	private String taskId="08c2d3e5-5092-419a-bb37-f81d4df9ec95";
	private String wrongTaskId="08c2d3e5-5092-419a-bb37-f81d4df9ec95";
	private String wrongActionId="08c555d3e5-sd55fdfg-788dr-bb37-d55ytry";

	EngineApiFlowGuiSubmit engineApiFlowGuiSubmit = EngineApiFlowGuiSubmit.builder().actionId(actionId)
			.comment(comment).taskId(taskId).
		    build();

	@Test
	public void postEngineApiFlowApprovalSubmit() throws JsonProcessingException {

		ValidatableResponse vr =
				given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
						.contentType(ContentType.JSON).body(mapper.writeValueAsString(engineApiFlowGuiSubmit)).when()
						.post(CredentialsUtils.ENGINE + Endpoints.middleURLEngineApiGuiSubmit)
						.then()
						.statusCode(201);

		String location = ((ValidatableResponseImpl) vr).originalResponse().header("Location");

		String response = given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(Factory.createEngineApiFlowGuiSubmit)).when()
				.get(location)
				.then()
				.contentType(ContentType.JSON).extract().response().asString();

		EngineApiFlowGuiSubmit engineApiFlowGuiSubmitJson= JsonHelper.readValue(response, EngineApiFlowGuiSubmit.class);
		assertEquals(Factory.createEngineApiFlowGuiSubmit.getActionId(), engineApiFlowGuiSubmitJson.getActionId(), "Action Ids are equals");
		assertEquals(Factory.createEngineApiFlowGuiSubmit.getComment(), engineApiFlowGuiSubmitJson.getComment(), "Comments are equals");
		assertEquals(Factory.createEngineApiFlowGuiSubmit.getTaskId(), engineApiFlowGuiSubmitJson.getTaskId(), "Task ids are equals");

		Factory.createEngineApiFlowGuiSubmit.setActionId(engineApiFlowGuiSubmitJson.getActionId());
		Factory.createEngineApiFlowGuiSubmit.setComment(engineApiFlowGuiSubmitJson.getComment());
		Factory.createEngineApiFlowGuiSubmit.setTaskId(engineApiFlowGuiSubmitJson.getTaskId());
	}

	@Test
	public void postEngineApiFlowApprovalSubmitMissingParameter() throws JsonProcessingException {


		EngineApiFlowGuiSubmit engineApiFlowGuiSubmit1 = EngineApiFlowGuiSubmit.builder().actionId(actionId)
				.comment(comment).build();
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(engineApiFlowGuiSubmit1)).when()
				.post(CredentialsUtils.ENGINE + Endpoints.middleURLEngineApiGuiSubmit)
				.then()
				.statusCode(400);
	}

	@Test
	public void postEngineApiFlowApprovalSubmitWrongActionId() throws JsonProcessingException {

		EngineApiFlowGuiSubmit engineApiFlowGuiSubmitWrong = EngineApiFlowGuiSubmit.builder().actionId(actionId)
				.comment(comment).wrongActionId(wrongActionId).
						build();

		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(engineApiFlowGuiSubmitWrong)).when()
				.post(CredentialsUtils.ENGINE + Endpoints.middleURLEngineApiGuiSubmit)
				.then()
				.statusCode(404);
	}

	@Test
	public void postEngineApiFlowApprovalSubmitWrongTaskId() throws JsonProcessingException {

		EngineApiFlowGuiSubmit engineApiFlowGuiSubmitWrong = EngineApiFlowGuiSubmit.builder().actionId(actionId)
				.comment(comment).wrongTaskId(wrongTaskId).
						build();

		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(engineApiFlowGuiSubmitWrong)).when()
				.post(CredentialsUtils.ENGINE + Endpoints.middleURLEngineApiGuiSubmit)
				.then()
				.statusCode(404);
	}

	@Test
	public void postEngineApiFlowApprovalSubmitNoAuthentication() throws JsonProcessingException {

		given()
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(engineApiFlowGuiSubmit)).when()
				.post(CredentialsUtils.ENGINE + Endpoints.middleURLEngineApiGuiSubmit)
				.then()
				.statusCode(401);
	}
}
