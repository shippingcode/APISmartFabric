package com.agys.identity.authenticationController.post;

import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.model.Factory;
import com.agys.utils.JsonHelper;
import com.jayway.restassured.internal.ValidatableResponseImpl;
import com.jayway.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;
import com.agys.jsonBuilder.Login;
import com.agys.utils.CredentialsUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;
import static com.agys.Constants.PRINCIPAL_HEADER_NAME;
import static com.jayway.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

/**
 * @author aila.bogasieru@agys.ch
 */



@Slf4j
public class Identity_Auth_TenantUserLoginTest {

	private ObjectMapper mapper = new ObjectMapper();


	@Test
	public void postLogin() throws JsonProcessingException {
		final String tenantId = "d634b20d-128e-4a57-97cf-7b7b01aeb901";
		final String tenantDomain = "default";
		final String userEmail = "testuser@fabric.ch";
		final String userPassword = "passw0rd";

		Login loginJson = Login.builder().tenantDomain(tenantDomain)
				.userEmail(userEmail).userPassword(userPassword).build();

					given().contentType(ContentType.JSON).body(mapper.writeValueAsString(loginJson)).when()
						.post(CredentialsUtils.IDENTITY + Endpoints.middleURLLogin).then()
						.statusCode(200);

	}

	@Test
	public void postWrongLogin() throws JsonProcessingException {
		final String tenantId = "d634b20d-128e-4a57-97cf-7b7b01aeb901";
		final String userEmail = "test_user@agys.ch";

		Login loginJson = Login.builder().tenantId(tenantId)
				.userEmail(userEmail).build();

		given().contentType(ContentType.JSON).body(mapper.writeValueAsString(loginJson)).when()
				.post(CredentialsUtils.IDENTITY + Endpoints.middleURLLogin).then()
				.statusCode(404);
	}
}
