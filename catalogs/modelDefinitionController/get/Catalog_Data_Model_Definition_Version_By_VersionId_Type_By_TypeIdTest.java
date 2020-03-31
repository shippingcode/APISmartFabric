package com.agys.catalogs.modelDefinitionController.get;


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
public class Catalog_Data_Model_Definition_Version_By_VersionId_Type_By_TypeIdTest {

	public static final String versionId ="7f38a4f9-94d5-4f96-a545-4c43f5c2b097";
	public static final String invalidVersionId ="dxfgdfg5e4654-4565456-dfghfhf-4645654-fyhj56547";
	public static final String nullVersionId ="null";
	public static final String type ="type";


	@Test
	public void getCatalogDataModelDefinitionVersionByVersionIdTypeByTypeId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON).get(CredentialsUtils.CATALOGS
						+ Endpoints.middleURLDataModelDefinitionVersionType + versionId +
				Endpoints.middleURLDataModelDefinitionVersionProcessDefinitionType3 + type)
					.then().assertThat().statusCode(200);
		log.info("Catalog_Data_Model_Definition_Version_By_VersionId_Type_By_TypeId" + CredentialsUtils.CATALOGS
		+ Endpoints.middleURLDataModelDefinitionVersionType + versionId +
				Endpoints.middleURLDataModelDefinitionVersionProcessDefinitionType3 + type);
	}

	@Test
	public void getCatalogDataModelDefinitionVersionByInvalidVersionIdTypeByTypeId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON).get(CredentialsUtils.CATALOGS
				+ Endpoints.middleURLDataModelDefinitionVersionType + invalidVersionId +
				Endpoints.middleURLDataModelDefinitionVersionProcessDefinitionType3 + type)
				.then().assertThat().statusCode(404);
		log.info("Catalog_Data_Model_Definition_Version_By_VersionId_Type_By_TypeId" + CredentialsUtils.CATALOGS
				+ Endpoints.middleURLDataModelDefinitionVersionType + versionId +
				Endpoints.middleURLDataModelDefinitionVersionProcessDefinitionType3 + type);
	}

	@Test
	public void getCatalogDataModelDefinitionVersionByNULLVersionIdTypeByTypeId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON).get(CredentialsUtils.CATALOGS
				+ Endpoints.middleURLDataModelDefinitionVersionType + nullVersionId +
				Endpoints.middleURLDataModelDefinitionVersionProcessDefinitionType3 + type)
				.then().assertThat().statusCode(400);
		log.info("Catalog_Data_Model_Definition_Version_By_VersionId_Type_By_TypeId" + CredentialsUtils.CATALOGS
				+ Endpoints.middleURLDataModelDefinitionVersionType + nullVersionId +
				Endpoints.middleURLDataModelDefinitionVersionProcessDefinitionType3 + type);
	}
	
	
	@Test
	public void getCatalogDataModelDefinitionVersionByVersionIdTypeByTypeIdNoAuthentication() throws FileNotFoundException {
		given()	
		.when().contentType(ContentType.JSON).get(CredentialsUtils.CATALOGS
				+ Endpoints.middleURLDataModelDefinitionVersionType + versionId +
				Endpoints.middleURLDataModelDefinitionVersionProcessDefinitionType3 + type)
		.then().assertThat().statusCode(401);
		log.info("Catalog_Data_Model_Definition_Version_By_VersionId_Type_By_TypeId" + CredentialsUtils.CATALOGS
				+ Endpoints.middleURLDataModelDefinitionVersionType + versionId +
				Endpoints.middleURLDataModelDefinitionVersionProcessDefinitionType3 + type);
	}
}
