package com.agys.identity.tenantController.delete;

import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.enums.Environments;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.agys.enums.GroupIdsEnum;
import com.agys.enums.UserIdsEnum;
import com.agys.utils.CredentialsUtils;
import com.jayway.restassured.http.ContentType;

import static com.agys.Constants.PRINCIPAL_HEADER_NAME;
import static com.jayway.restassured.RestAssured.given;

/**
 * 
 * @author aila.bogasieru@agys.ch Removes User Group Links
 */

public class Identity_Tenants_UserGroups_By_GroupsId_And_By_UserIdTest {
	
	private GroupIdsEnum GROUP;
	private UserIdsEnum USER;

	@Test
	public void deleteGroupIdInvalid() {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON)
				.delete(CredentialsUtils.IDENTITY
						+ Endpoints.middleURLTenantsUserGroups +GROUP.GROUP_INVALID.getId() + "/" + USER.USER_INVALID.getId())
				.then().statusCode(404);
	}

	@Test
	public void deleteGroupIdValid() {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON)
				.delete(CredentialsUtils.IDENTITY
						+ Endpoints.middleURLTenantsUserGroups +GROUP.GROUP_OK1.getId() + "/" + USER.USER_OK1.getId())
				.then().statusCode(200);
			
	}
	
	@Test
	public void deleteGroupIdValidNoAuthentication() {
		given().
		when().contentType(ContentType.JSON)
		.delete(CredentialsUtils.IDENTITY
				+ Endpoints.middleURLTenantsUserGroups
				+GROUP.GROUP_OK1.getId() + "/" + USER.USER_OK1.getId())
				.then().statusCode(401);
	}
}
