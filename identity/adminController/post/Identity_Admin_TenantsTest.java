package com.agys.identity.adminController.post;

import static com.agys.Constants.PRINCIPAL_HEADER_NAME;
import static com.jayway.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.enums.Environments;
import com.agys.model.Factory;
import com.agys.jsonBuilder.AdminTenants;
import com.agys.utils.JsonHelper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.internal.ValidatableResponseImpl;
import com.jayway.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.agys.utils.CredentialsUtils;
import com.jayway.restassured.http.ContentType;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j

public class Identity_Admin_TenantsTest {

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void postAdminTenants() throws IOException {

        final String defaultUserEmail = "smart@yahoo.com";
        final String defaultUserPassword = "pswe777rewr";
        final String domain = "354354354-degf777dgd-34544";
        final String name = "Pop";
        final String status = "ACTIVE";

        AdminTenants adminTenantsJson = AdminTenants.builder().defaultUserEmail(defaultUserEmail)
                .defaultUserPassword(defaultUserPassword).domain(domain).name(name).status(status).
                        build();

        ValidatableResponse vr = given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
                .contentType(ContentType.JSON).body(JsonHelper.OBJECT_MAPPER.writeValueAsString(Factory.adminTenantsJson)).when()
                .post(CredentialsUtils.IDENTITY + Endpoints.middleURLAdminTenants).then()
                .statusCode(201);

        String location = ((ValidatableResponseImpl) vr).originalResponse().header("Location");

        String response = given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
                .contentType(ContentType.JSON).body(mapper.writeValueAsString(Factory.adminTenantsJson)).when()
                .get(location)
                .then()
                .contentType(ContentType.JSON).extract().response().asString();

        AdminTenants createdTenant = JsonHelper.readValue(response, AdminTenants.class);
        assertEquals(Factory.adminTenantsJson.getDomain(), createdTenant.getDomain(), "The domains are equals");
        assertEquals(Factory.adminTenantsJson.getStatus(), createdTenant.getStatus(), "The statuses are equals");
        Factory.adminTenantsJson.setId(createdTenant.getId());
    }

    @Test
    public void postWrongAdminTenant() throws JsonProcessingException {
        final String defaultUserEmail = "test@gmail.com";
        final String defaultUserPassword = "sdfsdf4565465";
        final String domain = "345646456456-dfgfdgfd-45t43655-34655654";
        final String name = "AKLJK";
        final String status = "ACTIVE";

        AdminTenants adminTenantsJson = AdminTenants.builder().defaultUserEmail(defaultUserEmail)
                .defaultUserPassword(defaultUserPassword).domain(domain).name(name).status(status).
                        build();

        given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
                .contentType(ContentType.JSON).body(mapper.writeValueAsString(adminTenantsJson)).when()
                .post(CredentialsUtils.IDENTITY + Endpoints.middleURLAdminTenants).then()
                .statusCode(404);
    }

    @Test
    public void posExistingAdminTenant() throws JsonProcessingException {
        final String defaultUserEmail = "test@gmail.com";
        final String defaultUserPassword = "sdfsdf4565465";
        final String domain = "345646456456-dfgfdgfd-45t43655-34655654";
        final String name = "AKLJK";
        final String status = "ACTIVE";

        AdminTenants adminTenantsJson = AdminTenants.builder().defaultUserEmail(defaultUserEmail)
                .defaultUserPassword(defaultUserPassword).domain(domain).name(name).status(status).
                        build();

        given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
                .contentType(ContentType.JSON).body(mapper.writeValueAsString(adminTenantsJson)).when()
                .post(CredentialsUtils.IDENTITY + Endpoints.middleURLAdminTenants).then()
                .statusCode(404);
    }

    @Test
    public void postNoAuthenticationAdminTenant() throws JsonProcessingException {
        final String defaultUserEmail = "test@gmail.com";
        final String defaultUserPassword = "sdfsdf4565465";
        final String domain = "345646456456-dfgfdgfd-45t43655-34655654";
        final String name = "AKLJK";
        final String status = "ACTIVE";

        AdminTenants adminTenantsJson = AdminTenants.builder().defaultUserEmail(defaultUserEmail)
                .defaultUserPassword(defaultUserPassword).domain(domain).name(name).status(status).
                        build();
        given()
                .contentType(ContentType.JSON).body(mapper.writeValueAsString(adminTenantsJson)).when()
                .post(CredentialsUtils.IDENTITY + Endpoints.middleURLAdminTenants).then()
                .statusCode(401);
     }
}
