package com.APISmartFabric.Tests.adminController.GET;


import org.testng.annotations.Test;
import com.APISmartFabric.Enums.UsersTenantsIdsEnum;
import com.APISmartFabric.Utils.CredentialsUtils;
import com.jayway.restassured.http.ContentType;

import lombok.extern.slf4j.Slf4j;

import static com.jayway.restassured.RestAssured.given;
import java.io.FileNotFoundException;

/**
 * 
@author aila.bogasieru@agys.ch
 *
 */

@Slf4j
public class Identity_Admin_Tenants_Users_ByUserTenantIdTest08 {
	

	private UsersTenantsIdsEnum USER_TENANT;

	@Test
	public void getUserTenantById() throws FileNotFoundException {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.when().contentType(ContentType.JSON).get(CredentialsUtils.getProperty("baseURL")
						+ CredentialsUtils.getProperty("middleURLAdminTenantsUsers") + USER_TENANT.USER_TENANT_OK1.getId())
				.then().assertThat().statusCode(200);
		log.info("Identity_Admin_Tenants_Users_ByUserTenantId" + CredentialsUtils.getProperty("baseURL")
		+ CredentialsUtils.getProperty("middleURLAdminTenantsUsers") + USER_TENANT.USER_TENANT_OK1.getId());
	}

	@Test
	public void getUserTenantByInvalidId() throws FileNotFoundException {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.when().contentType(ContentType.JSON).get(CredentialsUtils.getProperty("baseURL")
						+ CredentialsUtils.getProperty("middleURLAdminTenantsUsers") + USER_TENANT.USER_TENANT_INVALID.getId())
				.then().assertThat().statusCode(404);
		log.info("Identity_Admin_Tenants_Users_ByUserTenantId" + CredentialsUtils.getProperty("baseURL")
		+ CredentialsUtils.getProperty("middleURLAdminTenantsUsers") + USER_TENANT.USER_TENANT_INVALID.getId());
	}
	
	@Test
	public void getUserTenantByNullId() throws FileNotFoundException {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.when().contentType(ContentType.JSON).get(CredentialsUtils.getProperty("baseURL")
						+ CredentialsUtils.getProperty("middleURLAdminTenantsUsers") + USER_TENANT.USER_TENANT_NULL.getId())
				.then().assertThat().statusCode(404);
		log.info("Identity_Admin_Tenants_Users_ByUserTenantId" + CredentialsUtils.getProperty("baseURL")
		+ CredentialsUtils.getProperty("middleURLAdminTenantsUsers") + USER_TENANT.USER_TENANT_NULL.getId());
	}
	
	@Test
	public void getUserTenantByIdNoAuthentication() throws FileNotFoundException {
		given()
				.when().contentType(ContentType.JSON).get(CredentialsUtils.getProperty("baseURL")
						+ CredentialsUtils.getProperty("middleURLAdminTenantsUsers") + USER_TENANT.USER_TENANT_OK2.getId())
				.then().assertThat().statusCode(403);
		log.info("Identity_Admin_Tenants_Users_ByUserTenantId" + CredentialsUtils.getProperty("baseURL")
		+ CredentialsUtils.getProperty("middleURLAdminTenantsUsers") + USER_TENANT.USER_TENANT_OK2.getId());
	}
}
