package com.agys;

import com.agys.enums.Environments;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.agys.enums.UserIdsEnum;
import com.agys.utils.CredentialsUtils;

import static com.agys.Constants.PRINCIPAL_HEADER_NAME;
import static com.jayway.restassured.RestAssured.given;
import java.io.FileNotFoundException;

/**
 * 
 * @author aila.bogasieru@agys.ch
 *
 */

public class GETUserByIdTest {

	private UserIdsEnum USERS;

	@Test
	public void getUserById() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType("application/json").get(CredentialsUtils.getProperty("baseURL")
						+ Endpoints.middleURLUser + USERS.USER_OK1.getId())
				.then().assertThat().statusCode(200);
	}

	@Test
	public void getUserByIdWithoutAuthentication() throws FileNotFoundException {
		given().when().contentType("application/json").get(CredentialsUtils.getProperty("baseURL")
				+ Endpoints.middleURLUser + USERS.USER_OK1.getId()).then().assertThat()
				.statusCode(401);
	}

	@Test
	public void getUserByInvalidId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType("application/json").get(CredentialsUtils.getProperty("baseURL")
						+ Endpoints.middleURLUser + USERS.USER_INVALID.getId())
				.then().assertThat().statusCode(404);
	}

	@Test
	public void getUserByNullId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType("application/json").get(CredentialsUtils.getProperty("baseURL")
						+ Endpoints.middleURLUser + USERS.USER_NULL.getId())
				.then().assertThat().statusCode(400);
	}
}
