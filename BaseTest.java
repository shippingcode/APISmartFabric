package com.agys;


import com.jayway.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

/**
 * 
 @author aila.bogasieru@agys.ch
 *
 */

public class BaseTest {

    @BeforeClass
    public static void setup() {
        String port = System.getProperty("server.port");
        if (port == null) {
            RestAssured.port = Integer.valueOf(8080);
        }
        else{
            RestAssured.port = Integer.valueOf(port);
        }


        String basePath = System.getProperty("server.base");
        if(basePath==null){
            basePath = "/catalogs-service/catalogs/";
        }
        RestAssured.basePath = basePath;

        String baseHost = System.getProperty("server.host");
        if(baseHost==null){
            baseHost = "https://dev01.hq.smartfabric.ch:9443";
        }
        RestAssured.baseURI = baseHost;

    }
}
