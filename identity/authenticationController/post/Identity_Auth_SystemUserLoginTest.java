package com.agys.identity.authenticationController.post;


import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.enums.Environments;
import com.agys.jsonBuilder.SystemLogin;
import com.agys.model.Factory;
import com.agys.utils.JsonHelper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.internal.ValidatableResponseImpl;
import com.jayway.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.agys.utils.CredentialsUtils;
import lombok.extern.slf4j.Slf4j;

/**
 * @author aila.bogasieru@agys.ch
 */

import static com.agys.Constants.PRINCIPAL_HEADER_NAME;
import static com.jayway.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

@Slf4j

public class Identity_Auth_SystemUserLoginTest {

	private ObjectMapper mapper = new ObjectMapper();

	@Test
	public void postSystemLogin() throws JsonProcessingException {
		final String tenantId = "dacb0d16-6f03-4dff-a485-8d123376cac0";
		final String userEmail = "fabric_user@agys.ch";
		final String userPassword = "dfkhfgh94";

		SystemLogin systemJsonj = SystemLogin.builder().tenantId(tenantId)
				.userEmail(userEmail).userPassword(userPassword).build();

		ValidatableResponse vr =
				given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
						.contentType(ContentType.JSON).body(mapper.writeValueAsString(systemJsonj)).when()
						.post(CredentialsUtils.IDENTITY + Endpoints.middleURLSystem).then()
						.statusCode(201);

		String location = ((ValidatableResponseImpl) vr).originalResponse().header("Location");

		String response = given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(Factory.systemJson)).when()
				.get(location)
				.then()
				.contentType(ContentType.JSON).extract().response().asString();

		SystemLogin systemLogin = JsonHelper.readValue(response, SystemLogin.class);
		assertEquals(Factory.systemJson.getTenantId(), systemLogin.getTenantId(), "Tenant Ids equals");
		assertEquals(Factory.systemJson.getUserEmail(), systemLogin.getUserEmail(), "User emails are equals");

		Factory.systemJson.setTenantId(systemLogin.getTenantId());
		Factory.systemJson.setUserEmail(systemLogin.getUserEmail());
	}

	@Test
	public void postWrongSystemLogin() throws JsonProcessingException {
		final String tenantId = "d634b20d-128e-4a57-97cf-7b7b01aeb901";
		final String userEmail = "test.user@gmail.com";
		final String userPassword = null;
		SystemLogin systemJson = SystemLogin.builder().tenantId(tenantId)
				.userEmail(userEmail).userPassword(userPassword).build();

		given().contentType(ContentType.JSON).body(mapper.writeValueAsString(systemJson)).when()
				.post(CredentialsUtils.IDENTITY + Endpoints.middleURLSystem).then()
				.statusCode(404);
	}
}
