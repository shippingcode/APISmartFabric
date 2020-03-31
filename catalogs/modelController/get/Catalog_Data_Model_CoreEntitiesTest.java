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
public class Catalog_Data_Model_CoreEntitiesTest {

	@Test
	public void getGUIControlList() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON).get(CredentialsUtils.CATALOGS
						+ Endpoints.middleURLDataModelCoreEntities)
					.then().assertThat().statusCode(200);
		log.info(" Catalog_Data_Model_CoreEntities" + CredentialsUtils.CATALOGS
		+ Endpoints.middleURLDataModelCoreEntities);
	}
	
	
	@Test
	public void getGUIControlListNoAuthentication() throws FileNotFoundException {
		given()	
		.when().contentType(ContentType.JSON).get(CredentialsUtils.CATALOGS
				+ Endpoints.middleURLDataModelCoreEntities)
		.then().assertThat().statusCode(401);
		log.info("Catalog_Data_Model_CoreEntities" + CredentialsUtils.CATALOGS
		+ Endpoints.middleURLDataModelCoreEntities);
	}
}
