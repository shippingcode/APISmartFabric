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
public class Catalog_Data_Model_Versions_By_VersionIdTest {

	private String versionId="1f8a0de9-a639-428b-9921-641898475a9b";
	private String invalidVersionId="sfsd34654-sdf34654-w35t4356-sdgfdg";
	private String nullVersionId="null";


	@Test
	public void getCatalog_Data_Model_Versions_By_VersionId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON).get(CredentialsUtils.CATALOGS
						+ Endpoints.middleURLDataModelVersions)
					.then().assertThat().statusCode(200);
		log.info("Catalog_Data_Model_Versions_By_VersionId" + CredentialsUtils.CATALOGS
		+ Endpoints.middleURLDataModelVersions + versionId);
	}

	@Test
	public void getCatalog_Data_Model_Versions_By_InvalidVersionId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON).get(CredentialsUtils.CATALOGS
				+ Endpoints.middleURLDataModelVersions)
				.then().assertThat().statusCode(404);
		log.info("Catalog_Data_Model_Versions_By_VersionId" + CredentialsUtils.CATALOGS
				+ Endpoints.middleURLDataModelVersions + invalidVersionId);
	}

	@Test
	public void getCatalog_Data_Model_Versions_By_NULLVersionId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON).get(CredentialsUtils.CATALOGS
				+ Endpoints.middleURLDataModelVersions)
				.then().assertThat().statusCode(400);
		log.info("Catalog_Data_Model_Versions_By_VersionId" + CredentialsUtils.CATALOGS
				+ Endpoints.middleURLDataModelVersions + nullVersionId);
	}
	
	
	@Test
	public void Catalog_Data_Model_Versions_By_VersionIdNoAuthentication() throws FileNotFoundException {
		given()	
		.when().contentType(ContentType.JSON).get(CredentialsUtils.CATALOGS
				+ Endpoints.middleURLDataModelVersions)
		.then().assertThat().statusCode(401);
		log.info("Catalog_Data_Model_Versions_By_VersionId" + CredentialsUtils.CATALOGS
		+ Endpoints.middleURLDataModelVersions + versionId);
	}
}
