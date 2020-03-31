package com.agys.identity.permissionController.post;

import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.jsonBuilder.AdminGroupsUsers;
import com.agys.jsonBuilder.PermissionsGroupPermissions;
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

/**
 * 
 * @author aila.bogasieru@agys.ch
 *
 */
@Slf4j
public class Identity_Permisisons_GroupPermisisonsTest {

	private ObjectMapper mapper = new ObjectMapper();

	final String groupId = "e3f72af2-cc56-4353-abaf-54af2ba47936";
	final String id = "ee8e633a-f482-411f-96a5-e3ea154ed504";
	final String permission = "Admin";
	final String permissionType = "type";
	final String targetId="64645-346546546";
	final String userId="64645-346546546-3454354";

    PermissionsGroupPermissions permissionsGroupPermissions = PermissionsGroupPermissions.builder().groupId(groupId)
            .id(id).permission(permission).permissionType(permissionType).targetId(targetId).build();

	@Test
	public void postIdentityPermisisonsGroupPermisisons() throws JsonProcessingException {

		ValidatableResponse vr =
				given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
						.contentType(ContentType.JSON).body(mapper.writeValueAsString(permissionsGroupPermissions)).when()
						.post(CredentialsUtils.IDENTITY + Endpoints.middleURLIdentityPermissionsGroupPermissions).then()
						.statusCode(201);

		String location = ((ValidatableResponseImpl) vr).originalResponse().header("Location");

		String response = given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(Factory.permissionsGroupPermissionsClass)).when()
				.get(location)
				.then()
				.contentType(ContentType.JSON).extract().response().asString();

		PermissionsGroupPermissions permissionsGroupPermissions = JsonHelper.readValue(response, PermissionsGroupPermissions.class);
		assertEquals(Factory.permissionsGroupPermissionsClass.getGroupId(), permissionsGroupPermissions.getGroupId(), "Group Ids equals");
		assertEquals(Factory.permissionsGroupPermissionsClass.getId(), permissionsGroupPermissions.getId(), "Ids are equals");
		assertEquals(Factory.permissionsGroupPermissionsClass.getPermission(), permissionsGroupPermissions.getPermission(), "permissions are equals");

		Factory.permissionsGroupPermissionsClass.setGroupId(permissionsGroupPermissions.getGroupId());
		Factory.permissionsGroupPermissionsClass.setId(permissionsGroupPermissions.getId());
		Factory.permissionsGroupPermissionsClass.setPermission(permissionsGroupPermissions.getPermission());
	}

	@Test
	public void postWrongIdentityPermisisonsGroupPermisisons() throws JsonProcessingException {

		PermissionsGroupPermissions permissionsGroupPermissions1 = PermissionsGroupPermissions.builder().groupId(groupId)
				.id(id).permission(permission).permissionType(permissionType).userId(userId).build();

        given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(permissionsGroupPermissions1)).when()
				.post(CredentialsUtils.IDENTITY + Endpoints.middleURLIdentityPermissionsGroupPermissions).then()
				.statusCode(404);
	}

	@Test
	public void postIdentityPermisisonsGroupPermisisonsNoAuthentication() throws JsonProcessingException {

		given()
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(permissionsGroupPermissions)).when()
				.post(CredentialsUtils.IDENTITY + Endpoints.middleURLIdentityPermissionsGroupPermissions).then()
				.statusCode(401);
	}
}
