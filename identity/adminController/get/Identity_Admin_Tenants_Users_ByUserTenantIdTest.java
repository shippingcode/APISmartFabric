package com.agys.identity.adminController.get;


import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.enums.Environments;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.agys.enums.UsersTenantsIdsEnum;
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
public class Identity_Admin_Tenants_Users_ByUserTenantIdTest {
	

	private UsersTenantsIdsEnum USER_TENANT;

	@Test
	public void getUserTenantById() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE).when().contentType(ContentType.JSON).get(CredentialsUtils.IDENTITY
						+ Endpoints.middleURLAdminTenantsUsers + USER_TENANT.USER_TENANT_OK1.getId())
				.then().assertThat().statusCode(200);
		log.info("Identity_Admin_Tenants_Users_ByUserTenantId" + CredentialsUtils.IDENTITY
		+ Endpoints.middleURLAdminTenantsUsers + USER_TENANT.USER_TENANT_OK1.getId());
	}

	@Test
	public void getUserTenantByInvalidId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE).when().contentType(ContentType.JSON).get(CredentialsUtils.IDENTITY
						+ Endpoints.middleURLAdminTenantsUsers + USER_TENANT.USER_TENANT_INVALID.getId())
				.then().assertThat().statusCode(404);
		log.info("Identity_Admin_Tenants_Users_ByUserTenantId" + CredentialsUtils.IDENTITY
		+ Endpoints.middleURLAdminTenantsUsers + USER_TENANT.USER_TENANT_INVALID.getId());
	}
	
	@Test
	public void getUserTenantByNullId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE).when().contentType(ContentType.JSON).get(CredentialsUtils.IDENTITY
						+ Endpoints.middleURLAdminTenantsUsers + USER_TENANT.USER_TENANT_NULL.getId())
				.then().assertThat().statusCode(400);
		log.info("Identity_Admin_Tenants_Users_ByUserTenantId" + CredentialsUtils.IDENTITY
		+ Endpoints.middleURLAdminTenantsUsers + USER_TENANT.USER_TENANT_NULL.getId());
	}
	
	@Test
	public void getUserTenantByIdNoAuthentication() throws FileNotFoundException {
		given()
				.when().contentType(ContentType.JSON).get(CredentialsUtils.IDENTITY
						+ Endpoints.middleURLAdminTenantsUsers + USER_TENANT.USER_TENANT_OK2.getId())
				.then().assertThat().statusCode(401);
		log.info("Identity_Admin_Tenants_Users_ByUserTenantId" + CredentialsUtils.IDENTITY
		+ Endpoints.middleURLAdminTenantsUsers + USER_TENANT.USER_TENANT_OK2.getId());
	}
}
