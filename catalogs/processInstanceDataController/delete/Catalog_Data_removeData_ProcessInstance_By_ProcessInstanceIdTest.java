package com.agys.catalogs.processInstanceDataController.delete;

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
 * @author aila.bogasieru@agys.ch Removes data process instance
 */

public class Catalog_Data_removeData_ProcessInstance_By_ProcessInstanceIdTest {

	private String processInstanceId ="1b8f76c3-cd0a-7698-93cd-1ce69b9006e6";
	private String invalidProcessInstanceId ="dfds3454-f5a3-3456-9c20-dfgfd";

	@Test
	public void deleteCatalogDataRemoveDataProcessInstanceByProcessInstanceId() {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON)
				.delete(CredentialsUtils.CATALOGS
						+ Endpoints.middleURLDataRemoveDataProcessInstance + processInstanceId)
				.then().statusCode(200);
	}

	@Test
	public void deleteCatalogDataRemoveDataProcessInstanceByInvalidProcessInstanceId() {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON)
				.delete(CredentialsUtils.CATALOGS
						+ Endpoints.middleURLDataRemoveDataProcessInstance + invalidProcessInstanceId)
				.then().statusCode(404);
			
	}
	
	@Test
	public void deleteCatalogDataremoveDataProcessInstanceByProcessInstanceIdNoAuthentication() {
		given().
		when().contentType(ContentType.JSON)
		.delete(CredentialsUtils.CATALOGS
				+ Endpoints.middleURLDataRemoveDataProcessInstance
				+ processInstanceId)
				.then().statusCode(401);
	}
}
