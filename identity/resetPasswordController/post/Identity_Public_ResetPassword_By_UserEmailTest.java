package com.agys.identity.resetPasswordController.post;

import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.jsonBuilder.PublicResetPassword;
import com.agys.jsonBuilder.TenantsUsers;
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

import java.util.UUID;

import static com.agys.Constants.PRINCIPAL_HEADER_NAME;
import static com.jayway.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

@Slf4j
public class Identity_Public_ResetPassword_By_UserEmailTest {

	private ObjectMapper mapper = new ObjectMapper();

	final String userEmail = "test_user@agys.ch";
	final String invalidUserEmail = "test_user@fabric.com";


	PublicResetPassword publicResetPassword = PublicResetPassword.builder().userEmail(userEmail).build();

	@Test
	public void postIdentityPublicResetPasswordByUserEmail() throws JsonProcessingException {

		ValidatableResponse vr =
				given()
						.contentType(ContentType.JSON).body(mapper.writeValueAsString(publicResetPassword)).when()
						.post(CredentialsUtils.IDENTITY + Endpoints.middleURLIdentityPublicResetPassword).then()
						.statusCode(201);

		String location = ((ValidatableResponseImpl) vr).originalResponse().header("Location");

		String response = given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(Factory.publicResetPasswordClass)).when()
				.get(location)
				.then()
				.contentType(ContentType.JSON).extract().response().asString();

		PublicResetPassword publicResetPassword = JsonHelper.readValue(response, PublicResetPassword.class);
		assertEquals(Factory.publicResetPasswordClass.getUserEmail(), publicResetPassword.getUserEmail(), "User emails are equals");

		Factory.publicResetPasswordClass.setUserEmail(publicResetPassword.getUserEmail());

	}

	@Test
	public void postIdentityPublicResetPasswordByInvalidUserEmail() throws JsonProcessingException {

		PublicResetPassword publicResetPassword1 = PublicResetPassword.builder().invalidUserEmail(invalidUserEmail).build();

		given()
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(publicResetPassword1)).when()
				.post(CredentialsUtils.IDENTITY +  Endpoints.middleURLIdentityPublicResetPassword).then()
				.statusCode(404);
	}


}
