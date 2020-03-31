package com.agys.identity.permissionController.get;


import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.utils.CredentialsUtils;
import com.jayway.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;
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
public class Identity_Permissions_UserPermissions_By_ProcessDefinitionIdTest {


	private String processDefinitionId="5f8e91e3-cf30-4b21-ad97-dd110816b109";
	private String invaliPprocessDefinitionId="5f8e91e3-cf30-4b21-ad97-dd110816b109";
	private String nullProcessDefinitionId="5f8e91e3-cf30-4b21-ad97-dd110816b109";

	@Test
	public void getIdentityPermissionsGroupPermissionsByProcessDefinitionId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON).get(CredentialsUtils.GUI
						+ Endpoints.middleURLIdentityPermissionsUserPermissions + processDefinitionId)
				.then().assertThat().statusCode(200);
		log.info("GUI_Control_Id_By_Id" + CredentialsUtils.GUI
				+ Endpoints.middleURLIdentityPermissionsUserPermissions + processDefinitionId);
	}
	
	@Test
	public void IdentityPermissionsGroupPermissionsByInvalidProcessDefinitionId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE).when().contentType(ContentType.JSON).get(CredentialsUtils.GUI
						+ Endpoints.middleURLIdentityPermissionsUserPermissions + invaliPprocessDefinitionId)
				.then().assertThat().statusCode(404);
		log.info("GUI_Control_Id_By_Id" + CredentialsUtils.GUI
		+ Endpoints.middleURLIdentityPermissionsUserPermissions + invaliPprocessDefinitionId);
	}
	
	@Test
	public void getIdentityPermissionsGroupPermissionsByNULLProcessDefinitionId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE).when().contentType(ContentType.JSON).get(CredentialsUtils.GUI
				+ Endpoints.middleURLIdentityPermissionsUserPermissions + nullProcessDefinitionId)
		.then().assertThat().statusCode(400);
		log.info("GUI_Control_Id_By_Id" + CredentialsUtils.GUI
		+ Endpoints.middleURLIdentityPermissionsUserPermissions + nullProcessDefinitionId);
	}

	@Test
	public void getIdentityPermissionsGroupPermissionsByProcessDefinitionIdNoAuthentication() throws FileNotFoundException {
		given()	
		.when().contentType(ContentType.JSON).get(CredentialsUtils.GUI
				+ Endpoints.middleURLIdentityPermissionsUserPermissions + processDefinitionId)
		.then().assertThat().statusCode(401);
		log.info("GUI_Control_Id_By_Id" + CredentialsUtils.GUI
		+ Endpoints.middleURLIdentityPermissionsUserPermissions + processDefinitionId);
	}
}
