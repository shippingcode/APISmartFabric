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
public class GUI_Used_Process_By_ProcessDefinitionIdTest {

	private String processDefinitionId = "e53b8c55-76f5-4e55-81f6-306a2dae2017";
	private String nullprocessDefinitionId = "null";
	private String invalidprocessDefinitionId = "123456";

	@Test
	public void getGUIUsedProcessByProcessDefinitionId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE).when().contentType(ContentType.JSON)
				.get(CredentialsUtils.GUI
						+ Endpoints.middleURLGUIUsedProcess + processDefinitionId)
				.then().assertThat().statusCode(200);
		log.info("GUI_Used_Process_By_ProcessDefinition Id" + CredentialsUtils.GUI
				+ Endpoints.middleURLGUIUsedProcess + processDefinitionId);
	}

	@Test
	public void getGUIUsedProcessByInvalidProcessDefinitionId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE).when().contentType(ContentType.JSON)
				.get(CredentialsUtils.GUI
						+ Endpoints.middleURLGUIUsedProcess + invalidprocessDefinitionId)
				.then().assertThat().statusCode(404);
		log.info("GUI_Used_Process_By_ProcessDefinition Id" + CredentialsUtils.GUI
				+ Endpoints.middleURLGUIUsedProcess + invalidprocessDefinitionId);
	}

	@Test
	public void getGUIUsedProcessByNULLProcessDefinitionId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE).when().contentType(ContentType.JSON)
				.get(CredentialsUtils.GUI
						+ Endpoints.middleURLGUIUsedProcess + nullprocessDefinitionId)
				.then().assertThat().statusCode(400);
		log.info("GUI_Used_Process_By_ProcessDefinition Id" + CredentialsUtils.GUI
				+ Endpoints.middleURLGUIUsedProcess + nullprocessDefinitionId);
	}

	@Test
	public void getGUIUsedProcessByProcessDefinitionIdNoAuthentication() throws FileNotFoundException {
		given().when().contentType(ContentType.JSON)
				.get(CredentialsUtils.GUI
						+ Endpoints.middleURLGUIUsedProcess + processDefinitionId)
				.then().assertThat().statusCode(401);
		log.info("GUI_Used_Process_By_ProcessDefinition Id" + CredentialsUtils.GUI
				+ Endpoints.middleURLGUIUsedProcess + processDefinitionId);
	}
}
