package com.agys.identity.authenticationController.get;

import static com.agys.Constants.PRINCIPAL_HEADER_NAME;
import static com.jayway.restassured.RestAssured.given;
import java.io.FileNotFoundException;

import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.enums.Environments;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.agys.enums.TenantDomainEnum;
import com.agys.utils.CredentialsUtils;
import com.jayway.restassured.http.ContentType;

import lombok.extern.slf4j.Slf4j;

/**
 * 
@author aila.bogasieru@agys.ch
 *
 */

@Slf4j
public class Identity_Auth_TenantAnonLogin_By_TenantDomainTest {
	

	private TenantDomainEnum TENANT_DOMAIN;


	@Test
	public void getTenantByTenantDomain() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON).get(CredentialsUtils.IDENTITY
						+ Endpoints.middleURLTenant + TENANT_DOMAIN.TENANT_DOMAIN_OK1.getId())
				.then().assertThat().statusCode(200);
		log.info("Identity_Auth_TenantAnonLogin_By_TenantDomain" + CredentialsUtils.IDENTITY
				+ Endpoints.middleURLTenant + TENANT_DOMAIN.TENANT_DOMAIN_OK1.getId());
	}

	@Test
	public void getTenantByInvalidTenantDomain() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON).get(CredentialsUtils.IDENTITY +
				Endpoints.middleURLTenant + TENANT_DOMAIN.TENANT_DOMAIN_INVALID.getId())
				.then().assertThat().statusCode(404);
		log.info("Identity_Auth_TenantAnonLogin_By_TenantDomain" + CredentialsUtils.IDENTITY
				+ Endpoints.middleURLTenant + TENANT_DOMAIN.TENANT_DOMAIN_INVALID.getId());
	}
	
	@Test
	public void getTenantByNULLTenantDomain() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON).get(CredentialsUtils.IDENTITY
						+ Endpoints.middleURLTenant + TENANT_DOMAIN.TENANT_DOMAIN_NULL.getId())
				.then().assertThat().statusCode(400);
		log.info("Identity_Auth_TenantAnonLogin_By_TenantDomain" + CredentialsUtils.IDENTITY
				+ Endpoints.middleURLTenant + TENANT_DOMAIN.TENANT_DOMAIN_NULL.getId());
	}
	
	@Test
	public void getTenantByTenantDomainNoAuthentication() throws FileNotFoundException {
		given()
				.when().contentType(ContentType.JSON).get(CredentialsUtils.IDENTITY
						+ Endpoints.middleURLTenant + TENANT_DOMAIN.TENANT_DOMAIN_OK2.getId())
				.then().assertThat().statusCode(401);
		log.info("Identity_Auth_TenantAnonLogin_By_TenantDomain" + CredentialsUtils.IDENTITY
				+  Endpoints.middleURLTenant + TENANT_DOMAIN.TENANT_DOMAIN_OK2.getId());
	}
}
