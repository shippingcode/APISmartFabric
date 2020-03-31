package com.agys.engine.taskController.post;


import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.enums.Environments;
import com.agys.jsonBuilder.EngineTaskFilterCreate;
import com.agys.jsonBuilder.EngineTaskList;
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
public class Engine_Task_ListTest {

	private ObjectMapper mapper = new ObjectMapper();

	private String activeTasks ="true";
	private String isTeam="true";
	private String page="1";
	private String searchTerm="string";
	private String size="23";
	private String sortDirection="ASC";
	private String sortField="1";
	private String dueIn="1";
	private String priorities="Completed";
	private String taskName="In progress";
	private String taskStatus="In progress";
	private String ownerId="3e420496-344b-4702-a11d-72e024774bac";


	EngineTaskList engineTaskList =
			EngineTaskList.builder().activeTasks(activeTasks).isTeam(isTeam)
			.page(page).searchTerm(searchTerm).size(size).sortDirection(sortDirection).sortField(sortField).dueIn(dueIn).priorities(priorities).
					taskName(taskName).taskStatus(taskStatus).build();

	@Test
	public void postEngine_Task_List() throws JsonProcessingException {

		ValidatableResponse vr =
				given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
						.contentType(ContentType.JSON).body(mapper.writeValueAsString(engineTaskList)).when()
						.post(CredentialsUtils.ENGINE + Endpoints.middleEngineTaskList)
						.then()
						.statusCode(201);

		String location = ((ValidatableResponseImpl) vr).originalResponse().header("Location");

		String response = given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(Factory.engineTaskListClass)).when()
				.get(location)
				.then()
				.contentType(ContentType.JSON).extract().response().asString();

		EngineTaskList engineTaskList=
				JsonHelper.readValue(response, EngineTaskList.class);
		assertEquals(Factory.engineTaskListClass.getPriorities(), engineTaskList.getPriorities(), "Priorities are equals");
		assertEquals(Factory.engineTaskListClass.getTaskName(), engineTaskList.getTaskName(), "Tasks names are equals");
		assertEquals(Factory.engineTaskListClass.getTaskStatus(), engineTaskList.getTaskStatus(), "Task statuses are equals");

		Factory.engineTaskListClass.setPriorities(engineTaskList.getPriorities());
		Factory.engineTaskListClass.setTaskName(engineTaskList.getTaskName());
		Factory.engineTaskListClass.setTaskStatus(engineTaskList.getTaskStatus());
	}

	@Test
	public void postEngine_Task_ListMissingParameter() throws JsonProcessingException {

		EngineTaskList engineTaskList1 =
				EngineTaskList.builder().activeTasks(activeTasks).isTeam(isTeam)
						.page(page).searchTerm(searchTerm).size(size).sortDirection(sortDirection).sortField(sortField).dueIn(dueIn).priorities(priorities).
						taskStatus(taskStatus).build();


		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(engineTaskList1)).when()
				.post(CredentialsUtils.ENGINE + Endpoints.middleEngineTaskList)
				.then()
				.statusCode(400);
	}

	@Test
	public void postEngine_Task_ListWrongParameter() throws JsonProcessingException {

		EngineTaskList engineTaskList2 =
				EngineTaskList.builder().activeTasks(activeTasks).isTeam(isTeam)
						.page(page).searchTerm(searchTerm).size(size).sortDirection(sortDirection).sortField(sortField).dueIn(dueIn).priorities(priorities).
						taskName(taskName).ownerId(ownerId).build();

		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(engineTaskList2)).
		when()
				.post(CredentialsUtils.ENGINE + Endpoints.middleEngineTaskList)
				.then()
				.statusCode(404);
	}

	@Test
	public void postEngine_Task_ListNoAuthentication() throws JsonProcessingException {

		given()
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(engineTaskList)).when()
				.post(CredentialsUtils.ENGINE + Endpoints.middleEngineTaskList)
				.then()
				.statusCode(401);
	}
}
