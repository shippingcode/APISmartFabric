package com.agys.identity.tenantController.get;


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
 * @author aila.bogasieru@agys.ch
 */
@Slf4j
public class Identity_Auth_Tenant_System_LoginTest {

    @Test
    public void getTenantsUsersSystem() throws FileNotFoundException {
        String path = CredentialsUtils.IDENTITY + Endpoints.middleURLTenantsUsersSystem;
        log.warn("Identity_Auth_Tenant_System_Login: " + path);

        given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
                .when().contentType(ContentType.JSON)
                .get(path)
                .then().assertThat().statusCode(200);
    }

    @Test
    public void getUserByIdNoAuthentication() throws FileNotFoundException {
        String path = CredentialsUtils.IDENTITY + Endpoints.middleURLTenantsUsersSystem;
        log.info("Identity_Auth_Tenant_System_Login: " + path);

        given().when().contentType(ContentType.JSON)
                .get(path)
                .then().assertThat().statusCode(401);
    }
}
