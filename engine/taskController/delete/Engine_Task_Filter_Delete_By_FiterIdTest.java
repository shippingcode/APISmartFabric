package com.agys.engine.taskController.delete;

import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.enums.Environments;
import com.agys.enums.GroupIdsEnum;
import com.agys.enums.UserIdsEnum;
import com.agys.utils.CredentialsUtils;
import com.jayway.restassured.http.ContentType;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static com.agys.Constants.PRINCIPAL_HEADER_NAME;
import static com.jayway.restassured.RestAssured.given;

/**
 * 
 * @author aila.bogasieru@agys.ch Removes Engine task filter by filter id
 */

public class Engine_Task_Filter_Delete_By_FiterIdTest {

	private String filterId="85767683-68f4-409a-b6d5-448d8133fb65";
	private String invalidFilterId="346546-43654654-456546-465465-456456";

	@Test
	public void deleteEngineTaskFilterDeleteByFilterId() {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON)
				.delete(CredentialsUtils.ENGINE
						+ Endpoints.middleEngineTaskFilterDelete + filterId)
				.then().statusCode(404);
	}

	@Test
	public void deleteEngineTaskFilterDeleteByInvalidFilterId() {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON)
				.delete(CredentialsUtils.ENGINE
						+ Endpoints.middleEngineTaskFilterDelete + invalidFilterId)
				.then().statusCode(200);
			
	}
	
	@Test
	public void deleteEngineTaskFilterDeleteByFilterIdNoAuthentication() {
		given().
		when().contentType(ContentType.JSON)
		.delete(CredentialsUtils.ENGINE
				+ Endpoints.middleEngineTaskFilterDelete + filterId)
				.then().statusCode(401);
	}
}
