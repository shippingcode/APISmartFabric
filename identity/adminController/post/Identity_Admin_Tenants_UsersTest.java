package com.agys.identity.adminController.post;


import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.enums.Environments;
import com.agys.jsonBuilder.AdminTenantsUsers;
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

@Slf4j
public class Identity_Admin_Tenants_UsersTest {

	private ObjectMapper mapper = new ObjectMapper();

	final String id = "3566";
	final String status = "ACTIVE";
	final String tenantId = "d634b20d-128e-4a57-97cf-7b7b01aeb901";
	final String userId = "cddef63d-5065-4b85-b685-0811c67b3b8a";

	AdminTenantsUsers adminTenantsUsersJson = AdminTenantsUsers.builder().id(id)
			.status(status).tenantId(tenantId).userId(userId).
					build();

	@Test
	public void postAdminTenantUser() throws JsonProcessingException {

		ValidatableResponse vr =
				given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
						.contentType(ContentType.JSON).body(mapper.writeValueAsString(adminTenantsUsersJson)).when()
						.post(CredentialsUtils.IDENTITY + Endpoints.middleURLAdminTenantsUsers).then()
						.statusCode(201);

		String location = ((ValidatableResponseImpl) vr).originalResponse().header("Location");

		String response = given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(Factory.adminGroupsUsers)).when()
				.get(location)
				.then()
				.contentType(ContentType.JSON).extract().response().asString();

		AdminTenantsUsers adminGroupsClass = JsonHelper.readValue(response, AdminTenantsUsers.class);
		assertEquals(Factory.adminTenantsUsers.getId(), adminGroupsClass.getId(), "Ids are equals");
		assertEquals(Factory.adminTenantsUsers.getStatus(), adminGroupsClass.getStatus(), "Statuses are equals");
		assertEquals(Factory.adminTenantsUsers.getTenantId(), adminGroupsClass.getTenantId(), "Tenant ids are equals");
		assertEquals(Factory.adminTenantsUsers.getUserId(), adminGroupsClass.getUserId(), "Types are equals");

		Factory.adminTenantsUsers.setId(adminGroupsClass.getId());
		Factory.adminTenantsUsers.setId(adminGroupsClass.getId());
		Factory.adminTenantsUsers.setStatus(adminGroupsClass.getStatus());
		Factory.adminTenantsUsers.setTenantId(adminGroupsClass.getTenantId());
		Factory.adminTenantsUsers.setUserId(adminGroupsClass.getUserId());
	}

	@Test
	public void postAdminTenantUserWrong() throws JsonProcessingException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(adminTenantsUsersJson)).when()
				.post(CredentialsUtils.IDENTITY + Endpoints.middleURLAdminTenantsUsers +1).then()
				.statusCode(404);
	}

	@Test
	public void postAdminTenantUserWithoutAuthentication() throws JsonProcessingException {
		given()
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(adminTenantsUsersJson)).when()
				.post(CredentialsUtils.IDENTITY +Endpoints.middleURLAdminTenantsUsers).then()
				.statusCode(401);
	}
}
