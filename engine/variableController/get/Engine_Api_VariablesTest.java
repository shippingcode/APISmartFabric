package com.agys.engine.variableController.get;


import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.utils.CredentialsUtils;
import com.jayway.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

import static com.agys.Constants.PRINCIPAL_HEADER_NAME;
import static com.jayway.restassured.RestAssured.given;

/**
 * 
 * @author aila.bogasieru@agys.ch
 *
 */

@Slf4j
public class Engine_Api_VariablesTest {


	@Test
	public void getEngineApiVariables() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.ENGINE
						+ Endpoints.middleEngineApiVariables)
					.then().assertThat().statusCode(200);
		log.info("Engine Api Variables" + CredentialsUtils.ENGINE
				+ Endpoints.middleEngineApiVariables);
	}


	@Test
	public void getEngineApiVariablesNoAuthentication() throws FileNotFoundException {
		given()
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.ENGINE
						+ Endpoints.middleEngineApiVariables)
				.then().assertThat().statusCode(401);
		log.info("Engine Api Variables" + CredentialsUtils.ENGINE
				+ Endpoints.middleEngineApiVariables);
	}
}
