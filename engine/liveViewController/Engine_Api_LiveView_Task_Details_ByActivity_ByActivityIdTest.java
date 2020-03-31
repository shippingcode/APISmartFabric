package com.agys.engine.liveViewController;


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
public class Engine_Api_LiveView_Task_Details_ByActivity_ByActivityIdTest {

	private String activityId="3c3fb853-10be-0b99-5220-c7658ec06146";
	private String invalidActivityId="3c3567853-10be-ghj-6765757-56765";
   	private String nullActivityId="null";

	@Test
	public void getEngineApiLiveViewTaskDetailsByActivityByActivityId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.ENGINE
						+ Endpoints.middleURLEngineApiLiveViewTaskDetails + activityId)
					.then().assertThat().statusCode(200);
		log.info("Engine_Api_LiveView_Task_Details_ByActivity_ByActivityId" + (CredentialsUtils.ENGINE
				+ Endpoints.middleURLEngineApiLiveViewTaskDetails + activityId));
	}


	@Test
	public void getEngineApiLiveViewTaskDetailsByActivityByInvalidActivityId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.ENGINE
						+ Endpoints.middleURLEngineApiLiveViewTaskDetails + invalidActivityId)
				.then().assertThat().statusCode(404);
		log.info("Engine_Api_LiveView_Task_Details_ByActivity_ByActivityId" + CredentialsUtils.ENGINE
				+ Endpoints.middleURLEngineApiLiveViewTaskDetails + invalidActivityId);
	}


	@Test
	public void getEngineApiLiveViewTaskDetailsByActivityByNULLActivityId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.ENGINE
						+ Endpoints.middleURLEngineApiLiveViewTaskDetails + nullActivityId)
				.then().assertThat().statusCode(400);
		log.info("Engine_Api_LiveView_Task_Details_ByActivity_ByActivityId" + CredentialsUtils.ENGINE
				+ Endpoints.middleURLEngineApiLiveViewTaskDetails + nullActivityId);
	}

	@Test
	public void getEngineApiLiveViewTaskDetailsByActivityByActivityIdNoAuthentication() throws FileNotFoundException {
		given()
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.ENGINE
						+ Endpoints.middleURLEngineApiLiveViewTaskDetails + activityId)
				.then().assertThat().statusCode(401);
		log.info("Engine_Api_LiveView_Task_Details_ByActivity_ByActivityId" + (CredentialsUtils.ENGINE
				+ Endpoints.middleURLEngineApiLiveViewTaskDetails + activityId));
	}
}
