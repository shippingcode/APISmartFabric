package com.agys.identity.permissionController.post;

import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.jsonBuilder.PermissionsGroupPermissions;
import com.agys.jsonBuilder.PermissionsUserPermissions;
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
public class Identity_Permisisons_UserPermisisonsTest {

	private ObjectMapper mapper = new ObjectMapper();


	final String userId ="00000000-0000-0000-0000-000000000001";
	final String permission = "Admin";
	final String permissionType = "type";
	final String targetId="64645-346546546";
	final String id="64645-346546546-645645645-34654";

    PermissionsUserPermissions permissionsUserPermissions = PermissionsUserPermissions.builder().userId(userId).
			permission(permission).permissionType(permissionType).targetId(targetId).build();

	@Test
	public void postIdentityPermisisonsUserPermisisons() throws JsonProcessingException {

		ValidatableResponse vr =
				given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
						.contentType(ContentType.JSON).body(mapper.writeValueAsString(permissionsUserPermissions)).when()
						.post(CredentialsUtils.IDENTITY + Endpoints.middleURLIdentityPermissionsUserPermissions).then()
						.statusCode(201);

		String location = ((ValidatableResponseImpl) vr).originalResponse().header("Location");

		String response = given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(Factory.permissionsUserPermissionsClass)).when()
				.get(location)
				.then()
				.contentType(ContentType.JSON).extract().response().asString();

		PermissionsUserPermissions permissionsUserPermissions = JsonHelper.readValue(response, PermissionsUserPermissions.class);
		assertEquals(Factory.permissionsUserPermissionsClass.getUserId(), permissionsUserPermissions.getUserId(), "User Ids equals");
		assertEquals(Factory.permissionsUserPermissionsClass.getPermission(), permissionsUserPermissions.getPermission(), "Permissions are equals");

		Factory.permissionsUserPermissionsClass.setUserId(permissionsUserPermissions.getUserId());
		Factory.permissionsUserPermissionsClass.setPermission(permissionsUserPermissions.getPermission());
	}

	@Test
	public void postWrongIdentityPermisisonsUserPermisisons() throws JsonProcessingException {

		PermissionsUserPermissions permissionsUserPermissions1 = PermissionsUserPermissions.builder().userId(userId).
				permission(permission).permissionType(permissionType).id(id).build();

        given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(permissionsUserPermissions1)).when()
				.post(CredentialsUtils.IDENTITY + Endpoints.middleURLIdentityPermissionsUserPermissions).then()
				.statusCode(404);
	}

	@Test
	public void postIdentityPermisisonsUserPermisisonsNoAuthentication() throws JsonProcessingException {

		given()
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(permissionsUserPermissions)).when()
				.post(CredentialsUtils.IDENTITY + Endpoints.middleURLIdentityPermissionsUserPermissions).then()
				.statusCode(401);
	}
}
