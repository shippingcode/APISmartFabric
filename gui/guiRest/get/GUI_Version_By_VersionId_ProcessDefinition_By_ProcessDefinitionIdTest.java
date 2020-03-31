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
public class GUI_Version_By_VersionId_ProcessDefinition_By_ProcessDefinitionIdTest {

	private String versionId = "e0216c9a-6f81-4d12-93f2-8b5f9bd2c2a6";
	private String processDefinitionId = "19d9b35f-7541-4861-85dd-3388331f1d5e";
	private String invalidversionId = "0";
	private String invalidProcessDefinition = "0";
	private String nullVersionId = "null";
	private String nullprocessDefinitionId = "null";


	@Test
	public void getGUIVersionByVersionIdProcessDefinitionByProcessDefinitionId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE).when().contentType(ContentType.JSON)
				.get(CredentialsUtils.GUI
						+ Endpoints.middleURLGUIVersionProcessDefinition + versionId
						+ Endpoints.middleURLGUIVersionProcessDefinition1 + processDefinitionId)
				.then().assertThat().statusCode(200);
		log.info("GUI_Version_By_VersionId_ProcessDefinition_By_ProcessDefinitionId"
				+ CredentialsUtils.GUI
				+ Endpoints.middleURLGUIVersionProcessDefinition + versionId
				+ Endpoints.middleURLGUIVersionProcessDefinition1 + processDefinitionId);
	}

	@Test
	public void getGUIVersionByNULLVersionIdProcessDefinitionByNULLProcessDefinitionId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE).when().contentType(ContentType.JSON)
				.get(CredentialsUtils.GUI
						+ Endpoints.middleURLGUIVersionProcessDefinition + nullVersionId
						+ Endpoints.middleURLGUIVersionProcessDefinition1
						+ nullprocessDefinitionId)
				.then().assertThat().statusCode(400);
		log.info("GUI_Version_By_VersionId_ProcessDefinition_By_ProcessDefinitionId"
				+ CredentialsUtils.GUI
				+ Endpoints.middleURLGUIVersionProcessDefinition + nullVersionId
				+ Endpoints.middleURLGUIVersionProcessDefinition1
				+ nullprocessDefinitionId);
	}

	@Test
	public void getGUIVersionByInvalidVersionIdProcessDefinitionByInvalidProcessDefinitionId()
			throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE).when().contentType(ContentType.JSON)
				.get(CredentialsUtils.GUI
						+ Endpoints.middleURLGUIVersionProcessDefinition + invalidversionId
						+ Endpoints.middleURLGUIVersionProcessDefinition1
						+ invalidProcessDefinition)
				.then().assertThat().statusCode(404);
		log.info("GUI_Version_By_VersionId_ProcessDefinition_By_ProcessDefinitionId"
				+ CredentialsUtils.GUI
				+ Endpoints.middleURLGUIVersionProcessDefinition + invalidversionId
				+ Endpoints.middleURLGUIVersionProcessDefinition1
				+ invalidProcessDefinition);
	}

	@Test
	public void getGUIUsedProcessByProcessDefinitionIdNoAuthentication() throws FileNotFoundException {
		given().when().contentType(ContentType.JSON)
				.get(CredentialsUtils.GUI +
						Endpoints.middleURLGUIVersionProcessDefinition + versionId
						+ Endpoints.middleURLGUIVersionProcessDefinition1 + processDefinitionId)
				.then().assertThat().statusCode(401);
		log.info("GUI_Version_By_VersionId_ProcessDefinition_By_ProcessDefinitionId"
				+ CredentialsUtils.GUI
				+ Endpoints.middleURLGUIVersionProcessDefinition + versionId
				+ Endpoints.middleURLGUIVersionProcessDefinition1 + processDefinitionId);
	}

	@Test
	public void getGUIVersionByInvalidVersionIdProcessDefinitionByProcessDefinitionId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE).when().contentType(ContentType.JSON)
				.get(CredentialsUtils.GUI
						+ Endpoints.middleURLGUIVersionProcessDefinition + invalidversionId
						+ Endpoints.middleURLGUIVersionProcessDefinition1
						+ invalidProcessDefinition)
				.then().assertThat().statusCode(404);
		log.info("GUI_Version_By_VersionId_ProcessDefinition_By_ProcessDefinitionId"
				+ CredentialsUtils.GUI
				+ Endpoints.middleURLGUIVersionProcessDefinition + invalidversionId
				+ Endpoints.middleURLGUIVersionProcessDefinition1
				+ invalidProcessDefinition);
	}

	@Test
	public void getGUIVersionByVersionIdProcessDefinitionByInvalidProcessDefinitionId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE).when().contentType(ContentType.JSON)
				.get(CredentialsUtils.GUI
						+ Endpoints.middleURLGUIVersionProcessDefinition + invalidversionId
						+ Endpoints.middleURLGUIVersionProcessDefinition1 + processDefinitionId)
				.then().assertThat().statusCode(404);
		log.info("GUI_Version_By_VersionId_ProcessDefinition_By_ProcessDefinitionId"
				+ CredentialsUtils.GUI
				+ Endpoints.middleURLGUIVersionProcessDefinition + invalidversionId
				+ Endpoints.middleURLGUIVersionProcessDefinition1 + processDefinitionId);
	}
}
