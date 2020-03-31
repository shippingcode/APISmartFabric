package com.agys.identity.resetPasswordController.post;

import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.jsonBuilder.PublicResetPassword;
import com.agys.jsonBuilder.PublicSetPassword;
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
public class Identity_Public_SetPassswordTest {

	private ObjectMapper mapper = new ObjectMapper();

	final String password = "pass0rd";
	final String repeatPassword = "pass0rd";
	final String token ="345456-34645645645-3534543";
	final String invalidPassword = "balabla";


	PublicSetPassword publicSetPassword = PublicSetPassword.builder().password(password).repeatPassword(repeatPassword).
			token(token).build();

	@Test
	public void postIdentityPublicResetPasswordByUserEmail() throws JsonProcessingException {

		ValidatableResponse vr =
				given()
						.contentType(ContentType.JSON).body(mapper.writeValueAsString(publicSetPassword)).when()
						.post(CredentialsUtils.IDENTITY + Endpoints.middleURLIdentityPublicSetPassword).then()
						.statusCode(201);

		String location = ((ValidatableResponseImpl) vr).originalResponse().header("Location");

		String response = given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(Factory.publicSetPasswordClass)).when()
				.get(location)
				.then()
				.contentType(ContentType.JSON).extract().response().asString();

		PublicSetPassword publicSetPassword = JsonHelper.readValue(response, PublicSetPassword.class);
		assertEquals(Factory.publicSetPasswordClass.getToken(), publicSetPassword.getToken(), "Tokens are equals");

		Factory.publicSetPasswordClass.setToken(publicSetPassword.getToken());

	}

	@Test
	public void postIdentityPublicResetPasswordByInvalidUserEmail() throws JsonProcessingException {

		PublicSetPassword publicSetPassword1 = PublicSetPassword.builder().invalidPassword(invalidPassword).repeatPassword(repeatPassword).
				token(token).build();

		given()
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(publicSetPassword1)).when()
				.post(CredentialsUtils.IDENTITY +  Endpoints.middleURLIdentityPublicSetPassword).then()
				.statusCode(404);
	}

}
