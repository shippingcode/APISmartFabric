package com.agys.engine.processDefinitionController.get;


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
public class Engine_Api_ProcessDefinition_All_ProcessesTest {

	@Test
	public void getEngineApiProcessDefinitionAllProcesses() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.ENGINE
						+ Endpoints.middleURLEngineApiProcessDefinitionAllprocesses)
					.then().assertThat().statusCode(200);
		log.info("Engine_Api_ProcessDefinition_All_Processes" + CredentialsUtils.ENGINE
				+ Endpoints.middleURLEngineApiProcessDefinitionAllprocesses);
	}


	@Test
	public void getEngineApiProcessDefinitionAllProcessesNoAuthentication() throws FileNotFoundException {
		given()
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.ENGINE
						+ Endpoints.middleURLEngineApiProcessDefinitionAllprocesses)
				.then().assertThat().statusCode(401);
		log.info("Engine_Api_ProcessDefinition_All_Processes" + (CredentialsUtils.ENGINE
				+ Endpoints.middleURLEngineApiProcessDefinitionAllprocesses));
	}
}
