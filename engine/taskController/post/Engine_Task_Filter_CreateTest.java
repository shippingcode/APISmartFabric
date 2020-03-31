package com.agys.engine.taskController.post;


import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.enums.Environments;
import com.agys.jsonBuilder.EngineApiProcessDefinitionProcessInstancesActive;
import com.agys.jsonBuilder.EngineTaskFilterCreate;
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
public class Engine_Task_Filter_CreateTest {

	private ObjectMapper mapper = new ObjectMapper();

	private String id = "e4fc3642-dba2-41aa-bf1a-56bd5ebc4b9d";
	private String isDefault="true";
	private String name="Task13.02.2019";
	private String ownerId="3e420496-344b-4702-a11d-72e024774bac";
	private String application="My Apps";
	private String dueIn="2";
	private String priorities="1";
	private String taskName="Task13022019";
	private String taskStatus="Completed";
	private String taskStatus1="In progress";

	EngineTaskFilterCreate engineTaskFilterCreate =
			EngineTaskFilterCreate.builder().id(id).isDefault(isDefault)
			.name(name).ownerId(ownerId).application(application).dueIn(dueIn).priorities(priorities).taskName(taskName).taskStatus(taskStatus).
		    build();

	@Test
	public void postEngineTaskFilterCreate() throws JsonProcessingException {

		ValidatableResponse vr =
				given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
						.contentType(ContentType.JSON).body(mapper.writeValueAsString(engineTaskFilterCreate)).when()
						.post(CredentialsUtils.ENGINE + Endpoints.middleEngineTaskFilterCreate)
						.then()
						.statusCode(201);

		String location = ((ValidatableResponseImpl) vr).originalResponse().header("Location");

		String response = given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(Factory.engineTaskFilterCreateClass)).when()
				.get(location)
				.then()
				.contentType(ContentType.JSON).extract().response().asString();

		EngineTaskFilterCreate engineTaskFilterCreate=
				JsonHelper.readValue(response, EngineTaskFilterCreate.class);
		assertEquals(Factory.engineTaskFilterCreateClass.getId(), engineTaskFilterCreate.getId(), "Ids are equals");
		assertEquals(Factory.engineTaskFilterCreateClass.getName(), engineTaskFilterCreate.getName(), "Names are equals");
		assertEquals(Factory.engineTaskFilterCreateClass.getOwnerId(), engineTaskFilterCreate.getOwnerId(), "Owner Ids are equals");
		assertEquals(Factory.engineTaskFilterCreateClass.getTaskName(), engineTaskFilterCreate.getTaskName(), "Task Names are equals");
		assertEquals(Factory.engineTaskFilterCreateClass.getTaskStatus(), engineTaskFilterCreate.getTaskStatus(), "Task statuses are equals");

		Factory.engineTaskFilterCreateClass.setId(engineTaskFilterCreate.getId());
		Factory.engineTaskFilterCreateClass.setName(engineTaskFilterCreate.getName());
		Factory.engineTaskFilterCreateClass.setOwnerId(engineTaskFilterCreate.getOwnerId());
		Factory.engineTaskFilterCreateClass.setTaskName(engineTaskFilterCreate.getTaskName());
		Factory.engineTaskFilterCreateClass.setTaskStatus(engineTaskFilterCreate.getTaskStatus());
	}

	@Test
	public void postEngineTaskFilterCreateMissingParameter() throws JsonProcessingException {


		EngineTaskFilterCreate engineTaskFilterCreate1 =
				EngineTaskFilterCreate.builder().id(id).isDefault(isDefault)
						.name(name).ownerId(ownerId).application(application).dueIn(dueIn).priorities(priorities).taskName(taskName).build();
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(engineTaskFilterCreate1)).when()
				.post(CredentialsUtils.ENGINE + Endpoints.middleEngineTaskFilterCreate)
				.then()
				.statusCode(400);
	}

	@Test
	public void EngineTaskFilterCreateWrongParameter() throws JsonProcessingException {

		EngineTaskFilterCreate engineTaskFilterCreate2 =
				EngineTaskFilterCreate.builder().id(id).isDefault(isDefault)
						.name(name).ownerId(ownerId).application(application).dueIn(dueIn).priorities(priorities).taskName(taskName).taskStatus1(taskStatus1).
						build();

		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(engineTaskFilterCreate2)).
		when()
				.post(CredentialsUtils.ENGINE + Endpoints.middleEngineTaskFilterCreate)
				.then()
				.statusCode(404);
	}

	@Test
	public void EngineTaskFilterCreateNoAuthentication() throws JsonProcessingException {

		given()
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(engineTaskFilterCreate)).when()
				.post(CredentialsUtils.ENGINE + Endpoints.middleEngineTaskFilterCreate)
				.then()
				.statusCode(401);
	}
}
