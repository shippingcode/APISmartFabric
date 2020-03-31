package com.agys.engine.variableController.post;


import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.enums.Environments;
import com.agys.jsonBuilder.EngineApiFlowApprovalSubmit;
import com.agys.jsonBuilder.EngineVariablesInternal;
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
public class Engine_Api_Variables_InternalTest {

	private ObjectMapper mapper = new ObjectMapper();

	private String includeAttachmentData = "true";
	private String includeCatalogData="true";
	private String processInstanceId="21eca05d-7581-4f22-86e7-a6d7a403ab30";
	private String taskId="65456546-43654654-4645654-346456y4";
	private String variables="a";


	EngineVariablesInternal engineApiVariablesInternal = EngineVariablesInternal.builder().includeAttachmentData(includeAttachmentData)
			.includeCatalogData(includeCatalogData).processInstanceId(processInstanceId).variables(variables).
		    build();

	@Test
	public void postEngineApiFlowApprovalSubmit() throws JsonProcessingException {

		ValidatableResponse vr =
				given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
						.contentType(ContentType.JSON).body(mapper.writeValueAsString(engineApiVariablesInternal)).when()
						.post(CredentialsUtils.ENGINE + Endpoints.middleEngineApiVariablesInternal)
						.then()
						.statusCode(201);

		String location = ((ValidatableResponseImpl) vr).originalResponse().header("Location");

		String response = given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(Factory.engineApiVariablesInternalClass)).when()
				.get(location)
				.then()
				.contentType(ContentType.JSON).extract().response().asString();

		EngineVariablesInternal engineApiVariablesInternal= JsonHelper.readValue(response, EngineVariablesInternal.class);
		assertEquals(Factory.engineApiVariablesInternalClass.getProcessInstanceId(), engineApiVariablesInternal.getProcessInstanceId(), "Process instances are equals");

		Factory.engineApiVariablesInternalClass.setProcessInstanceId(engineApiVariablesInternal.getProcessInstanceId());
	}

	@Test
	public void postEngineApiFlowApprovalSubmitMissingParameter() throws JsonProcessingException {


		EngineVariablesInternal engineApiVariablesInternal1 = EngineVariablesInternal.builder().includeAttachmentData(includeAttachmentData)
				.includeCatalogData(includeCatalogData).processInstanceId(processInstanceId).
						build();
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(engineApiVariablesInternal1)).when()
				.post(CredentialsUtils.ENGINE + Endpoints.middleEngineApiVariablesInternal)
				.then()
				.statusCode(400);
	}

	@Test
	public void postEngineApiFlowApprovalSubmitWrongParameter() throws JsonProcessingException {

		EngineVariablesInternal engineApiVariablesInternal2 = EngineVariablesInternal.builder().includeAttachmentData(includeAttachmentData)
				.includeCatalogData(includeCatalogData).processInstanceId(processInstanceId).variables(variables).taskId(taskId).
						build();

		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(engineApiVariablesInternal2)).when()
				.post(CredentialsUtils.ENGINE + Endpoints.middleEngineApiVariablesInternal)
				.then()
				.statusCode(404);
	}

	@Test
	public void postEngineApiFlowApprovalSubmitNoAuthentication() throws JsonProcessingException {

		given()
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(engineApiVariablesInternal)).when()
				.post(CredentialsUtils.ENGINE + Endpoints.middleEngineApiVariablesInternal)
				.then()
				.statusCode(401);
	}
}
