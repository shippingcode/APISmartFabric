package com.agys.engine.versionController.get;


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
public class Engine_Api_Version_By_VersionIdTest {
    private String invalidVersionId = "346456-346546546-456546";
    private String versionId = "";


    @Test
    public void getEngineApiVersionByVersionId() throws FileNotFoundException {
        String path = CredentialsUtils.ENGINE + Endpoints.middleEngineApiVersion;
        given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
                .when().contentType(ContentType.JSON)
                .get(path)
                .then().assertThat().statusCode(200);
        log.info("Engine Api Variables" + path + versionId);
    }

    @Test
    public void getEngineApiVersionByInvalidVersionId() throws FileNotFoundException {
        given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
                .when().contentType(ContentType.JSON)
                .get(CredentialsUtils.ENGINE
                        + Endpoints.middleEngineApiVersion)
                .then().assertThat().statusCode(200);
        log.info("Engine Api Variables" + CredentialsUtils.ENGINE
                + Endpoints.middleEngineApiVersionLatest + invalidVersionId);
    }


    @Test
    public void getEngineApiVersionByVersionIdNoAuthentication() throws FileNotFoundException {
        given()
                .when().contentType(ContentType.JSON)
                .get(CredentialsUtils.ENGINE
                        + Endpoints.middleEngineApiVariables)
                .then().assertThat().statusCode(401);
        log.info("Engine Api Variables" + CredentialsUtils.ENGINE
                + Endpoints.middleEngineApiVersionLatest);
    }
}
