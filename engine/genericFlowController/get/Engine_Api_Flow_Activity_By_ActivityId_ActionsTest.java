package com.agys.engine.genericFlowController.get;


import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.enums.Environments;
import com.agys.utils.CredentialsUtils;
import com.jayway.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
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
public class Engine_Api_Flow_Activity_By_ActivityId_ActionsTest {

	private String activityId="3c3fb853-10be-0b99-5220-c7658ec06146";
    private String invalidActivityId="fhfgh-10be-r5ytr-5220-frtytrfyrt";
	private String nullActivity="null";

	@Test
	public void getEngineApiFlowActivityByActivityIdActions() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.ENGINE
						+ Endpoints.middleURLEngineApiFlowActivity + activityId +  Endpoints.middleURLEngineApiFlowActivity1)
					.then().assertThat().statusCode(200);
		log.info("Engine_Api_Flow_Activity_By_ActivityId_Actions" + CredentialsUtils.ENGINE
				+ Endpoints.middleURLEngineApiFlowActivity + activityId +  Endpoints.middleURLEngineApiFlowActivity1);
	}


	@Test
	public void getEngineApiFlowActivityByInvalidActivityIdActions() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.ENGINE
						+ Endpoints.middleURLEngineApiFlowActivity + invalidActivityId +  Endpoints.middleURLEngineApiFlowActivity1)
				.then().assertThat().statusCode(200);
		log.info("Engine_Api_Flow_Activity_By_ActivityId_Actions" + CredentialsUtils.ENGINE
				+Endpoints.middleURLEngineApiFlowActivity + invalidActivityId +  Endpoints.middleURLEngineApiFlowActivity1);
	}


	@Test
	public void getEngineApiFlowActivityByNullActivityIdActions() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.ENGINE
						+ Endpoints.middleURLEngineApiFlowActivity + nullActivity +  Endpoints.middleURLEngineApiFlowActivity1)
				.then().assertThat().statusCode(404);
		log.info("Engine_Api_Flow_Activity_By_ActivityId_Actions" + CredentialsUtils.ENGINE
				+ Endpoints.middleURLEngineApiFlowActivity + nullActivity +  Endpoints.middleURLEngineApiFlowActivity1);
	}

	@Test
	public void getEngineApiFlowActivityByActivityIdActionsNoAuthentication() throws FileNotFoundException {
		given()
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.ENGINE
						+ Endpoints.middleURLEngineApiFlowActivity + activityId +  Endpoints.middleURLEngineApiFlowActivity1)
				.then().assertThat().statusCode(200);
		log.info("Engine_Api_Flow_Activity_By_ActivityId_Actions" + CredentialsUtils.ENGINE
				+ Endpoints.middleURLEngineApiFlowActivity + activityId +  Endpoints.middleURLEngineApiFlowActivity1);
	}
}
