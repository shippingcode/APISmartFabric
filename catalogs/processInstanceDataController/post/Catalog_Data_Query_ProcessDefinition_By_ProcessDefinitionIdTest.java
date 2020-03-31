package com.agys.catalogs.processInstanceDataController.post;


import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.enums.Environments;
import com.agys.jsonBuilder.CatalogDataLoadDataProcessInstance;
import com.agys.jsonBuilder.CatalogDataLoadDataProcessInstanceGUI;
import com.agys.jsonBuilder.CatalogDataLoadDataProcessInstanceMapping;
import com.agys.jsonBuilder.CatalogDataQueryProcessDefinition;
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

@Slf4j
public class Catalog_Data_Query_ProcessDefinition_By_ProcessDefinitionIdTest {

	private ObjectMapper mapper = new ObjectMapper();

	private String string = "true";
	private String processInstanceId ="4525f6a0-f5a3-4120-9c20-933260bf37a1";

	CatalogDataQueryProcessDefinition catalogDataQueryProcessDefinition = CatalogDataQueryProcessDefinition.builder().string(string)
	.build();

	@Test
	public void postCatalogDataQueryProcessDefinitionByProcessDefinitionId() throws JsonProcessingException {

		ValidatableResponse vr =
				given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
						.contentType(ContentType.JSON).body(mapper.writeValueAsString(catalogDataQueryProcessDefinition) + processInstanceId).when()
						.post(CredentialsUtils.CATALOGS + Endpoints.middleURLDataQueryProcessDefinition + processInstanceId)
						.then()
						.statusCode(201);

		String location = ((ValidatableResponseImpl) vr).originalResponse().header("Location");

		String response = given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(Factory.dataModelDefVersion)).when()
				.get(location)
				.then()
				.contentType(ContentType.JSON).extract().response().asString();

		CatalogDataQueryProcessDefinition catalogDataQueryProcessDef= JsonHelper.readValue(response, CatalogDataQueryProcessDefinition.class);
		assertEquals(Factory.catalogDataQueryProcessDefinition.getString(), catalogDataQueryProcessDef.getString(), "Strings are the same");
		Factory.catalogDataQueryProcessDefinition.setString(catalogDataQueryProcessDef.getString());
	}

	@Test
	public void postCatalogDataQueryProcessDefinitionByProcessDefinitionIdNoAuthentication() throws JsonProcessingException {

		given()
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(catalogDataQueryProcessDefinition)+  processInstanceId).when()
				.post(CredentialsUtils.CATALOGS + Endpoints.middleURLDataQueryProcessDefinition + processInstanceId)
				.then()
				.statusCode(401);
	}
}
