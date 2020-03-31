package com.agys.catalogs.modelController.post;


import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.enums.Environments;
import com.agys.jsonBuilder.DataModelJsonPath;
import com.agys.model.Factory;
import com.agys.utils.CredentialsUtils;
import com.agys.utils.JsonHelper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.internal.ValidatableResponseImpl;
import com.jayway.restassured.response.ValidatableResponse;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static com.agys.Constants.PRINCIPAL_HEADER_NAME;
import static com.jayway.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

/**
 * @author aila.bogasieru@agys.ch
 */

@Slf4j

public class Catalog_Data_Model_JsonPathTest {

	private ObjectMapper mapper = new ObjectMapper();
	final String json = "{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }";
	final String path = "//users/downloads/something";
	final String type = "type";


DataModelJsonPath dataModelJsonPathBuilder = DataModelJsonPath.builder().json(json)
			.path(path).type(type).build();

	@Test
	public void postCatalog_Data_Model_JsonPath() throws JsonProcessingException {

		DataModelJsonPath dataModelJsonPathBuilder = DataModelJsonPath.builder().json(json)
				.path(path).type(type).build();

		ValidatableResponse vr = given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(dataModelJsonPathBuilder)).when()
				.post(CredentialsUtils.CATALOGS + Endpoints.middleURLDataModelJsonPath).then()
				.statusCode(201);

		String location = ((ValidatableResponseImpl) vr).originalResponse().header("Location");

		String response = given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(Factory.catalogContentExportJson)).when()
				.get(location)
				.then()
				.contentType(ContentType.JSON).extract().response().asString();
		DataModelJsonPath dataModelJsonPath = JsonHelper.readValue(response, DataModelJsonPath.class);
		assertEquals(Factory.dataModelJsonPath.getJson(), dataModelJsonPath.getJson(), "The jsons are equals");
		assertEquals(Factory.dataModelJsonPath.getPath(), dataModelJsonPath.getPath(), "The paths are equals");
		assertEquals(Factory.dataModelJsonPath.getType(), dataModelJsonPath.getType(), "The type are equals");

		Factory.dataModelJsonPath.setJson(dataModelJsonPath.getJson());
		Factory.dataModelJsonPath.setPath(dataModelJsonPath.getPath());
		Factory.dataModelJsonPath.setType(dataModelJsonPath.getType());
	}

	@Test
	public void posCatalog_Data_Model_JsonPathNoAuthentication() throws JsonProcessingException {
			given()
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(dataModelJsonPathBuilder)).when()
				.post(CredentialsUtils.CATALOGS + Endpoints.middleURLDataModelJsonPath).then()
				.statusCode(401);
	}
}
