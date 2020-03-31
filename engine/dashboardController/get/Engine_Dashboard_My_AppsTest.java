package com.agys.engine.dashboardController.get;


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
public class Engine_Dashboard_My_AppsTest {

	private String active="true";
	private String blockchainEnabled="true";
	private String blockchainType="type567";
	private String canManage="true";
	private String canStart="true";
	private String canView ="true";
	private String code ="3546456";
	private String description="This is a description";
	private String id="2a9af83e-ed85-4e76-babb-78e3686c909d";
	private String imageId="45645645";
	private String imageUrl ="https://server/image.png";
	private String idInterfaces="34534654656";
	private String nameInterfaces="Interface's name";
	private String iteration="0";
	private String modifiedOn="2019-02-06T10:31:47.974Z";
	private String name="MyNameApp";
	private String ownerId="";
	private String type="type";
	private String versionid="508b2cf1-bc2b-4d4e-8d1a-d5f85c4e8177";


	@Test
	public void getEngineDashboardMyApps() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.body("{\"active\":\"" + active + "\",\n" + "\"blockchainEnabled\":\"" + blockchainEnabled + "\", \n"
						+ "\"blockchainType\":\"" + blockchainType + "\", \n"
						+ "\"canManage\":\"" + canManage  + "\", \n"
						+ "\"canStart\":\"" + canStart  + "\", \n"
						+ "\"canView\":\"" + canView  + "\", \n"
						+ "\"code\":\"" + code  + "\", \n"
						+ "\"description\":\"" + description  + "\", \n"
						+ "\"id\":\"" + id  + "\", \n"
						+ "\"imageId\":\"" + imageId  + "\", \n"
						+ "\"imageUrl\":\"" + imageUrl  + "\", \n"
						+ "\"idInterfaces\":\"" + idInterfaces  + "\", \n"
						+ "\"nameInterfaces\":\"" + nameInterfaces  + "\", \n"
						+ "\"iteration\":\"" + iteration  + "\", \n"
						+ "\"modifiedOn\":\"" + modifiedOn  + "\", \n"
						+ "\"name\":\"" + name  + "\", \n"
						+ "\"ownerId\":\"" + ownerId  + "\", \n"
						+ "\"type\":\"" + type  + "\", \n"
						+ "\"versionid\":\"" + versionid  + "\" }")
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.ENGINE
						+ Endpoints.middleURLEngineDashboardMyApps)
					.then().assertThat().statusCode(200);
		log.info("Catalog_Data_Catalogs_Definition_Version_By_VersionId_ProcessDefinitionId_By_ProcessDefinitionId" + CredentialsUtils.ENGINE
				+ Endpoints.middleURLEngineDashboardMyApps);
	}

	@Test
	public void getEngineDashboardMyAppsNoAuthentication() throws FileNotFoundException {
		given()
				.body("{\"active\":\"" + active + "\",\n" + "\"blockchainEnabled\":\"" + blockchainEnabled + "\", \n"
						+ "\"blockchainType\":\"" + blockchainType + "\", \n"
						+ "\"canManage\":\"" + canManage  + "\", \n"
						+ "\"canStart\":\"" + canStart  + "\", \n"
						+ "\"canView\":\"" + canView  + "\", \n"
						+ "\"code\":\"" + code  + "\", \n"
						+ "\"description\":\"" + description  + "\", \n"
						+ "\"id\":\"" + id  + "\", \n"
						+ "\"imageId\":\"" + imageId  + "\", \n"
						+ "\"imageUrl\":\"" + imageUrl  + "\", \n"
						+ "\"idInterfaces\":\"" + idInterfaces  + "\", \n"
						+ "\"nameInterfaces\":\"" + nameInterfaces  + "\", \n"
						+ "\"iteration\":\"" + iteration  + "\", \n"
						+ "\"modifiedOn\":\"" + modifiedOn  + "\", \n"
						+ "\"name\":\"" + name  + "\", \n"
						+ "\"ownerId\":\"" + ownerId  + "\", \n"
						+ "\"type\":\"" + type  + "\", \n"
						+ "\"versionid\":\"" + versionid  + "\" }")
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.ENGINE
						+ Endpoints.middleURLEngineDashboardMyApps)
				.then().assertThat().statusCode(201);
		log.info("Catalog_Data_Catalogs_Definition_Version_By_VersionId_ProcessDefinitionId_By_ProcessDefinitionId" + CredentialsUtils.ENGINE
				+ Endpoints.middleURLEngineDashboardMyApps);
	}


	@Test
	public void getEngineDashboardMyAppsMissingParameters() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.body("{\"active\":\"" + active + "\",\n" + "\"blockchainEnabled\":\"" + blockchainEnabled + "\", \n"
						+ "\"blockchainType\":\"" + blockchainType + "\", \n"
						+ "\"canManage\":\"" + canManage  + "\", \n"
						+ "\"canStart\":\"" + canStart  + "\", \n"
						+ "\"canView\":\"" + canView  + "\", \n"
					    + "\"description\":\"" + description  + "\", \n"
						+ "\"id\":\"" + id  + "\", \n"
						+ "\"imageId\":\"" + imageId  + "\", \n"
						+ "\"imageUrl\":\"" + imageUrl  + "\", \n"
						+ "\"idInterfaces\":\"" + idInterfaces  + "\", \n"
						+ "\"nameInterfaces\":\"" + nameInterfaces  + "\", \n"
						+ "\"iteration\":\"" + iteration  + "\", \n"
						+ "\"name\":\"" + name  + "\", \n"
						+ "\"ownerId\":\"" + ownerId  + "\", \n"
						+ "\"type\":\"" + type  + "\" }")
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.ENGINE
						+ Endpoints.middleURLEngineDashboardMyApps)
				.then().assertThat().statusCode(404);
		log.info("Catalog_Data_Catalogs_Definition_Version_By_VersionId_ProcessDefinitionId_By_ProcessDefinitionId" + CredentialsUtils.ENGINE
				+ Endpoints.middleURLEngineDashboardMyApps);
	}
}
