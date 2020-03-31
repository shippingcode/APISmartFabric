package com.agys.identity.systemController.get;

import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.enums.Environments;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.agys.enums.GroupIdsEnum;
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
public class Identity_Tenants_Groups_By_GrouspIdTest {

	private GroupIdsEnum GROUP;

	@Test
	public void getTenantsGroupsByGroupId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON).get(CredentialsUtils.IDENTITY
						+ Endpoints.middleURLTenantsGroups + GROUP.GROUP_OK1.getId())
				.then().assertThat().statusCode(200);
		log.info("Identity_Tenants_Groups_By_GrouspId" + CredentialsUtils.IDENTITY
				+ Endpoints.middleURLTenantsGroups + GROUP.GROUP_OK1.getId());
	}

	@Test
	public void getTenantsGroupsByInvalidGroupId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON).get(CredentialsUtils.IDENTITY
						+ Endpoints.middleURLTenantsGroups + GROUP.GROUP_INVALID.getId())
				.then().assertThat().statusCode(404);
		log.info("Identity_Tenants_Groups_By_GrouspId" + CredentialsUtils.IDENTITY
				+ Endpoints.middleURLTenantsGroups + GROUP.GROUP_INVALID.getId());
	}

	@Test
	public void getTenantsGroupsByNullGroupId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON).get(CredentialsUtils.IDENTITY
						+ Endpoints.middleURLTenantsGroups + GROUP.GROUP_NULL.getId())
				.then().assertThat().statusCode(400);
		log.info("Identity_Tenants_Groups_By_GrouspId" + CredentialsUtils.IDENTITY
				+ Endpoints.middleURLTenantsGroups + GROUP.GROUP_NULL.getId());
	}

	@Test
	public void getTenantsGroupsByGroupIdNoAuthentication() throws FileNotFoundException {
		given().when().contentType(ContentType.JSON)
				.get(CredentialsUtils.IDENTITY
						+ Endpoints.middleURLTenantsGroups + GROUP.GROUP_OK2.getId())
				.then().assertThat().statusCode(401);
		log.info("Identity_Tenants_Groups_By_GrouspId" + CredentialsUtils.IDENTITY
				+ Endpoints.middleURLTenantsGroups + GROUP.GROUP_OK2.getId());
	}
}
