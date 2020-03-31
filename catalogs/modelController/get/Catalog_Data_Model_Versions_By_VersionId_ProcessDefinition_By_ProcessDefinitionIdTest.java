package com.agys.catalogs.modelController.get;


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
@author aila.bogasieru@agys.ch
 *
 */

@Slf4j
public class Catalog_Data_Model_Versions_By_VersionId_ProcessDefinition_By_ProcessDefinitionIdTest {

	private String processDefinitionId="1f8a0de9-a639-428b-9921-641898475a9b";
	private String versionId="1f8a0de9-a639-428b-9921-641898475a9b";
	private String invalidProcessDefinitionId="1f8a0sdfs9-a639-sdfsdfsdf-9921-64189sdefsda9b";
	private String invalidVersionId="1f8a0de9-a639-5435wsedfdsf-sdfdsfds34543-64189e3575a9b";


@Test
	public void getCatalog_Data_Model_Versions_By_VersionId_ProcessDefinition_By_ProcessDefinitionId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON).get(CredentialsUtils.CATALOGS
				+ Endpoints.middleURLDataModelVersionByVersionId + versionId +
				Endpoints.middleURLDataCatalogsDefinitionVersion2 + processDefinitionId)
					.then().assertThat().statusCode(200);
		log.info("Catalog_Data_Model_Versions_By_VersionId_ProcessDefinition_By_ProcessDefinitionId" + CredentialsUtils.CATALOGS
		+ Endpoints.middleURLDataModelVersionByVersionId + versionId +
				Endpoints.middleURLDataCatalogsDefinitionVersion2 + processDefinitionId);
	}

	@Test
	public void Catalog_Data_Model_Versions_By_InvalidVersionId_ProcessDefinition_By_ProcessDefinitionId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON).get(CredentialsUtils.CATALOGS
				+ Endpoints.middleURLDataModelVersionByVersionId + invalidVersionId +
				Endpoints.middleURLDataCatalogsDefinitionVersion2 + processDefinitionId)
				.then().assertThat().statusCode(404);
		log.info("Catalog_Data_Model_Versions_By_VersionId_ProcessDefinition_By_ProcessDefinitionId" + CredentialsUtils.CATALOGS
				+ Endpoints.middleURLDataModelVersionByVersionId + invalidVersionId +
				Endpoints.middleURLDataCatalogsDefinitionVersion2 + processDefinitionId);
	}

	@Test
	public void Catalog_Data_Model_Versions_By_VersionId_ProcessDefinition_By_InvalidProcessDefinitionId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON).get(CredentialsUtils.CATALOGS
				+ Endpoints.middleURLDataModelVersionByVersionId + versionId +
				Endpoints.middleURLDataCatalogsDefinitionVersion2 + invalidProcessDefinitionId)
				.then().assertThat().statusCode(404);
		log.info("Catalog_Data_Model_Versions_By_VersionId_ProcessDefinition_By_ProcessDefinitionId" + CredentialsUtils.CATALOGS
				+ CredentialsUtils.getProperty("middleURLDataModelVersionByVersionId") + versionId +
				CredentialsUtils.getProperty("middleURLDataCatalogsDefinitionVersion2") + invalidProcessDefinitionId);
	}

	@Test
	public void Catalog_Data_Model_Versions_By_InvalidVersionId_ProcessDefinition_By_InvalidProcessDefinitionId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON).get(CredentialsUtils.CATALOGS
				+ Endpoints.middleURLDataModelVersionByVersionId + invalidVersionId +
				Endpoints.middleURLDataCatalogsDefinitionVersion2 + invalidProcessDefinitionId)
				.then().assertThat().statusCode(404);
		log.info("Catalog_Data_Model_Versions_By_VersionId_ProcessDefinition_By_ProcessDefinitionId" + CredentialsUtils.CATALOGS
				+ Endpoints.middleURLDataModelVersionByVersionId + invalidVersionId +
				Endpoints.middleURLDataCatalogsDefinitionVersion2 + invalidProcessDefinitionId);
	}
	
	
	@Test
	public void Catalog_Data_Model_Versions_By_VersionIdNoAuthentication() throws FileNotFoundException {
		given()	
		.when().contentType(ContentType.JSON).get(CredentialsUtils.CATALOGS
				+ Endpoints.middleURLDataModelVersionByVersionId + versionId +
				Endpoints.middleURLDataCatalogsDefinitionVersion2 + processDefinitionId)
		.then().assertThat().statusCode(401);
		log.info("Catalog_Data_Model_Versions_By_VersionId_ProcessDefinition_By_ProcessDefinitionId" + CredentialsUtils.CATALOGS
				+ Endpoints.middleURLDataModelVersionByVersionId + versionId +
				Endpoints.middleURLDataCatalogsDefinitionVersion2 + processDefinitionId);
	}
}
