package com.agys.gui.guiRest.get;


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
public class GUI_Activity_By_ActivityIdTest {

	private String activityId = "1242456434";
	private String invalidActivityId = "34564565464645";
	private String nullActivityId = "null";


	@Test
	public void getGUIActivityByActivityId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE).
				when().contentType(ContentType.JSON).get(CredentialsUtils.GUI
						+ Endpoints.middleURLGUIActivity + activityId)
				.then().assertThat().statusCode(200);
		log.info("GUI_Activity_By_Activity Id" + CredentialsUtils.GUI
				+  Endpoints.middleURLGUIActivity + activityId);
	}

	@Test
	public void getGUIActivityByActivityInvalidId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE).when().contentType(ContentType.JSON).get(CredentialsUtils.GUI
						+ CredentialsUtils.getProperty("middleURLGUIActivity") + invalidActivityId)
				.then().assertThat().statusCode(404);
		log.info("GUI_Activity_By_Activity Id" + CredentialsUtils.GUI
				+  Endpoints.middleURLGUIActivity + invalidActivityId);
	}

	@Test
	public void getGUIActivityByActivityNULLId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE).when().contentType(ContentType.JSON).get(CredentialsUtils.GUI
						+ CredentialsUtils.getProperty("middleURLGUIActivity") + nullActivityId)
				.then().assertThat().statusCode(400);
		log.info("GUI_Activity_By_Activity Id" + CredentialsUtils.GUI
				+  Endpoints.middleURLGUIActivity + nullActivityId);
	}

	@Test
	public void getGUIActivityByActivityIdNoAuthentication() throws FileNotFoundException {
		given().when().contentType(ContentType.JSON).get(CredentialsUtils.GUI
				+  Endpoints.middleURLGUIActivity + activityId).then().assertThat()
				.statusCode(401);
		log.info("GUI_Activity_By_Activity Id" + CredentialsUtils.GUI +
				Endpoints.middleURLGUIActivity + activityId);
	}
}
