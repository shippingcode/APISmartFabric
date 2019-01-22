package com.APISmartFabric.Tests.tenantController.GET;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import com.APISmartFabric.Enums.UserIdsEnum;
import com.APISmartFabric.Utils.CredentialsUtils;
import static com.jayway.restassured.RestAssured.given;
import java.io.FileNotFoundException;

/**
 * 
 * @author aila.bogasieru@agys.ch
 *
 */

public class Identity_Tenants_UsersTenants_By_UserIdTest34 {

	private UserIdsEnum USERS;
	private static final Logger logger = LoggerFactory.getLogger(Identity_Tenants_UsersTenants_By_UserIdTest34.class);

	@Test
	public void getTenantsUsersByUserId() throws FileNotFoundException {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.when().contentType("application/json")
				.get(CredentialsUtils.getProperty("baseURL")
						+ CredentialsUtils.getProperty("middleURLTenantsUsersTenants") + USERS.USER_OK2.getId())
				.then().assertThat().statusCode(200);
		logger.info("Identity_Tenants_Users_Profile" + CredentialsUtils.getProperty("baseURL")
				+ CredentialsUtils.getProperty("middleURLTenantsUsersTenants") + USERS.USER_OK2.getId());
	}

	@Test
	public void getTenantsUsersByInvalidUserId() throws FileNotFoundException {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.when().contentType("application/json")
				.get(CredentialsUtils.getProperty("baseURL")
						+ CredentialsUtils.getProperty("middleURLTenantsUsersTenants") + USERS.USER_INVALID.getId())
				.then().assertThat().statusCode(404);
		logger.info("Identity_Tenants_Users_Profile" + CredentialsUtils.getProperty("baseURL")
				+ CredentialsUtils.getProperty("middleURLTenantsUsersTenants") + USERS.USER_INVALID.getId());
	}

	@Test
	public void getTenantsUsersByNULLUserId() throws FileNotFoundException {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.when().contentType("application/json")
				.get(CredentialsUtils.getProperty("baseURL")
						+ CredentialsUtils.getProperty("middleURLTenantsUsersTenants") + USERS.USER_NULL.getId())
				.then().assertThat().statusCode(404);
		logger.info("Identity_Tenants_Users_Profile" + CredentialsUtils.getProperty("baseURL")
				+ CredentialsUtils.getProperty("middleURLTenantsUsersTenants") + USERS.USER_NULL.getId());
	}

	@Test
	public void getTenantsUsersByUserIdNoAuthentication() throws FileNotFoundException {
		given().when().contentType("application/json")
				.get(CredentialsUtils.getProperty("baseURL")
						+ CredentialsUtils.getProperty("middleURLTenantsUsersTenants") + USERS.USER_OK1.getId())
				.then().assertThat().statusCode(403);
		logger.info("Identity_Tenants_Users_Profile" + CredentialsUtils.getProperty("baseURL")
				+ CredentialsUtils.getProperty("middleURLTenantsUsersTenants") + USERS.USER_OK1.getId());
	}
}
