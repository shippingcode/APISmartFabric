package com.agys.engine.taskController.get;


import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.enums.Environments;
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
public class Engine_Task_Filter_By_FilterIdTest {

	private String filterId="85767683-68f4-409a-b6d5-448d8133fb65";
	private String invalidFilterId="dsgfdgdf-10dfgfdgbe-gh45657657j-456546-56765";
   	private String nullFilterId="null";

	@Test
	public void getEngineTaskFilterByFilterId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.ENGINE
						+ Endpoints.middleEngineTaskFilter + filterId)
					.then().assertThat().statusCode(200);
		log.info("Engine Task Filter By Filter Id" + CredentialsUtils.ENGINE
				+ Endpoints.middleEngineTaskFilter + filterId);
	}


	@Test
	public void getEngineTaskFilterByInvalidFilterId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.ENGINE
						+ Endpoints.middleEngineTaskFilter + invalidFilterId)
				.then().assertThat().statusCode(404);
		log.info("Engine Task Filter By Filter Id" + CredentialsUtils.ENGINE
				+ Endpoints.middleEngineTaskFilter + invalidFilterId);
	}


	@Test
	public void getEngineTaskFilterByNULLFilterId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.ENGINE
						+ Endpoints.middleEngineTaskFilter + nullFilterId)
				.then().assertThat().statusCode(400);
		log.info("Engine Task Filter By Filter Id" + CredentialsUtils.ENGINE
				+ Endpoints.middleEngineTaskFilter + nullFilterId);
	}

	@Test
	public void getEngineTaskFilterByFilterIdNoAuthentication() throws FileNotFoundException {
		given()
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.ENGINE
						+ Endpoints.middleEngineTaskFilter + filterId)
				.then().assertThat().statusCode(401);
		log.info("Engine Task Filter By Filter Id" + CredentialsUtils.ENGINE
				+ Endpoints.middleEngineTaskFilter + filterId);
	}
}
