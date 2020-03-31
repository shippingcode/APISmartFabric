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
public class Catalog_Data_Model_Definition_Version_By_VersionIdTest {

	public static final String versionId ="7f38a4f9-94d5-4f96-a545-4c43f5c2b097";

	@Test
	public void getCatalogDataModelDefinitionVersionByVersionId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON).get(CredentialsUtils.CATALOGS
						+ Endpoints.middleURLDataModelCoreEntities + versionId)
					.then().assertThat().statusCode(200);
		log.info("Catalog_Data_Model_Definition_Version_By_VersionId" + CredentialsUtils.CATALOGS
		+ Endpoints.middleURLDataModelDefinitionVersion);
	}
	
	
	@Test
	public void getCatalogDataModelDefinitionVersionByVersionIdNoAuthentication() throws FileNotFoundException {
		given()	
		.when().contentType(ContentType.JSON).get(CredentialsUtils.CATALOGS
				+ Endpoints.middleURLDataModelCoreEntities)
		.then().assertThat().statusCode(401);
		log.info("Catalog_Data_Model_Definition_Version_By_VersionId" + CredentialsUtils.CATALOGS
		+ Endpoints.middleURLDataModelDefinitionVersion+ versionId);
	}
}
