package com.agys.identity.tenantController.get;

import com.agys.Constants;
import com.agys.Endpoints;
import org.testng.annotations.Test;
import com.agys.utils.CredentialsUtils;
import com.jayway.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;

import static com.agys.Constants.PRINCIPAL_HEADER_NAME;
import static com.jayway.restassured.RestAssured.given;
import java.io.FileNotFoundException;

/**
 * 
 * @author aila.bogasieru@agys.ch
 *
 */
@Slf4j
public class Identity_Tenants_Users_Email_By_EmailTest27 {


	@Test
	public void getTenantsUsersEmailByEmail() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.getProperty("baseURL")
						+ Endpoints.middleURLTenantsUsersEmailByEmail + "test_user%40agys.ch")

				.then().assertThat().statusCode(200);
		log.info("Identity_Tenants_Users_Email_By_Email" + CredentialsUtils.getProperty("baseURL")
				+ Endpoints.middleURLTenantsUsersEmailByEmail + "test_user%40agys.ch");
	}

	@Test
	public void getTenantsUsersEmailByEmailNoAuthentication() throws FileNotFoundException {
		given().when().contentType(ContentType.JSON)
				.get(CredentialsUtils.getProperty("baseURL")
						+ Endpoints.middleURLTenantsUsersEmailByEmail + "test_user%40agys.ch")
				.then().assertThat().statusCode(401);
		log.info("Identity_Tenants_Users_Email_By_Email" + CredentialsUtils.getProperty("baseURL")
				+ Endpoints.middleURLTenantsUsersEmailByEmail + "test_user%40agys.ch");
	}
}