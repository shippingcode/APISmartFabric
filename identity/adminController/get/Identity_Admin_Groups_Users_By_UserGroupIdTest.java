package com.agys.identity.adminController.get;

import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.enums.Environments;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.agys.enums.UsersGroupsIdsEnum;
import com.agys.utils.CredentialsUtils;
import com.jayway.restassured.http.ContentType;

import lombok.extern.slf4j.Slf4j;

import static com.agys.Constants.PRINCIPAL_HEADER_NAME;
import static com.jayway.restassured.RestAssured.given;
import java.io.FileNotFoundException;

/**
 * 
@author aila.bogasieru@agys.ch
 *
 */

@Slf4j
public class Identity_Admin_Groups_Users_By_UserGroupIdTest {
	

	private UsersGroupsIdsEnum USERGROUP;
	
	final String groupId = "4354646";
	final String id = "46546546";
	final String isManager = "true";
	final String userId = "ab280eec-762c-4f5c-a599-1c949db477b0";

	@Test
	public void getUserById() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE).when().contentType(ContentType.JSON).get(CredentialsUtils.IDENTITY
						+ Endpoints.middleURLAdminGroupsUsers + USERGROUP.USERSGROUPS_OK1.getId())
				.then().assertThat().statusCode(200);
		log.info("Identity_Admin_Groups_Users_By_UserGroupId"+ CredentialsUtils.IDENTITY
						+ Endpoints.middleURLAdminGroupsUsers + USERGROUP.USERSGROUPS_OK1.getId());
	}

	@Test
	public void getUserByIdWithoutAuthentication() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE).when().contentType(ContentType.JSON).get(CredentialsUtils.IDENTITY
						+ Endpoints.middleURLAdminGroupsUsers + USERGROUP.USERSGROUPS_OK2.getId())
				.then().assertThat().statusCode(401);
		log.info("Identity_Admin_Groups_Users_By_UserGroupId"+ CredentialsUtils.getProperty("baseURL")
		+ Endpoints.middleURLAdminGroupsUsers + USERGROUP.USERSGROUPS_OK2.getId());
	}
	
	@Test
	public void getUserByNullId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE).when().contentType(ContentType.JSON).get(CredentialsUtils.IDENTITY
						+ Endpoints.middleURLAdminGroupsUsers + USERGROUP.USERSGROUPS_NULL.getId())
				.then().assertThat().statusCode(400);
		log.info("Identity_Admin_Groups_Users_By_UserGroupId"+ CredentialsUtils.IDENTITY
		+ Endpoints.middleURLAdminGroupsUsers + USERGROUP.USERSGROUPS_NULL.getId());
	}
	

	@Test
	public void getUserByInvalidId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE).when().contentType(ContentType.JSON).get(CredentialsUtils.getProperty("baseURL")
						+ Endpoints.middleURLAdminGroupsUsers + USERGROUP.USERSGROUPS_INVALID.getId())
				.then().assertThat().statusCode(404);
		log.info("Identity_Admin_Groups_Users_By_UserGroupId"+ CredentialsUtils.IDENTITY
		+ Endpoints.middleURLAdminGroupsUsers + USERGROUP.USERSGROUPS_INVALID.getId());
	}
}
