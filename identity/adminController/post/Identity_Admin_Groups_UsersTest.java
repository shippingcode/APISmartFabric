package com.agys.identity.adminController.post;

import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.enums.Environments;
import com.agys.jsonBuilder.AdminGroupsUsers;
import com.agys.model.Factory;
import com.agys.utils.JsonHelper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.internal.ValidatableResponseImpl;
import com.jayway.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.agys.utils.CredentialsUtils;
import com.jayway.restassured.http.ContentType;

import lombok.extern.slf4j.Slf4j;

import static com.agys.Constants.PRINCIPAL_HEADER_NAME;
import static com.jayway.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

/**
 * 
 * @author aila.bogasieru@agys.ch
 *
 */
@Slf4j
public class Identity_Admin_Groups_UsersTest {

	private ObjectMapper mapper = new ObjectMapper();

	final String groupId = "e3f72af2-cc56-4353-abaf-54af2ba47936";
	final String id = "ee8e633a-f482-411f-96a5-e3ea154ed504";
	final String isManager = "true";
	final String userId = "d6259540-7004-40ac-b926-d972c4389dec";

    AdminGroupsUsers adminGroupsUsersJson = AdminGroupsUsers.builder().groupId(groupId)
            .id(id).isManager(isManager).userId(userId).build();

	@Test
	public void postAdminGroupsUsers() throws JsonProcessingException {

		ValidatableResponse vr =
				given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
						.contentType(ContentType.JSON).body(mapper.writeValueAsString(adminGroupsUsersJson)).when()
						.post(CredentialsUtils.IDENTITY + Endpoints.middleURLAdminGroupsUsers).then()
						.statusCode(201);

		String location = ((ValidatableResponseImpl) vr).originalResponse().header("Location");

		String response = given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(Factory.catalogContentExportJson)).when()
				.get(location)
				.then()
				.contentType(ContentType.JSON).extract().response().asString();

		AdminGroupsUsers adminGroupsUsersClass = JsonHelper.readValue(response, AdminGroupsUsers.class);
		assertEquals(Factory.adminGroupsUsers.getGroupId(), adminGroupsUsersClass.getGroupId(), "Group Ids equals");
		assertEquals(Factory.adminGroupsUsers.getId(), adminGroupsUsersClass.getId(), "Ids are equals");
		assertEquals(Factory.adminGroupsUsers.getUserId(), adminGroupsUsersClass.getUserId(), "User Ids are equals");

		Factory.adminGroupsUsers.setGroupId(adminGroupsUsersClass.getGroupId());
		Factory.adminGroupsUsers.setId(adminGroupsUsersClass.getId());
		Factory.adminGroupsUsers.setUserId(adminGroupsUsersClass.getUserId());
	}

	@Test
	public void postWrongAdminGroupsUsers() throws JsonProcessingException {

        given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(adminGroupsUsersJson)).when()
				.post(CredentialsUtils.IDENTITY + Endpoints.middleURLAdminGroupsUsers).then()
				.statusCode(404);
	}

	@Test
	public void postAdminGroupsUsersNoAuthentication() throws JsonProcessingException {

		given()
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(adminGroupsUsersJson)).when()
				.post(CredentialsUtils.IDENTITY + Endpoints.middleURLAdminGroupsUsers).then()
				.statusCode(401);
	}
}
