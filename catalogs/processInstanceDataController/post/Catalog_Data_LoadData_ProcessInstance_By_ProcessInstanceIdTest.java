package com.agys.catalogs.processInstanceDataController.post;


import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.enums.Environments;
import com.agys.jsonBuilder.CatalogDataLoadDataInternal;
import com.agys.jsonBuilder.CatalogDataLoadDataProcessInstance;
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
public class Catalog_Data_LoadData_ProcessInstance_By_ProcessInstanceIdTest {

	private ObjectMapper mapper = new ObjectMapper();

	private String catalogData = "2345678";
	private String embeddedData="true";
	private String processInstanceId ="730f2a54-b71b-30f3-2bce-1e0e8b0e6f52";

	CatalogDataLoadDataProcessInstance catalogloadDataProcessInstance = CatalogDataLoadDataProcessInstance.builder().catalogData(catalogData)
			.embeddedData(embeddedData).build();

	@Test
	public void postCatalogDataLoadDataProcessInstanceByProcessInstanceId() throws JsonProcessingException {

		ValidatableResponse vr =
				given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
						.contentType(ContentType.JSON).body(mapper.writeValueAsString(catalogloadDataProcessInstance) + processInstanceId).when()
						.post(CredentialsUtils.CATALOGS + Endpoints.middleURLDataLoadDataProcessDefinition)
						.then()
						.statusCode(201);

		String location = ((ValidatableResponseImpl) vr).originalResponse().header("Location");

		String response = given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(Factory.dataModelDefVersion)).when()
				.get(location)
				.then()
				.contentType(ContentType.JSON).extract().response().asString();

		CatalogDataLoadDataProcessInstance catalogDataLoadDataProcessInstance= JsonHelper.readValue(response, CatalogDataLoadDataProcessInstance.class);
		assertEquals(Factory.catalogLoadDataProcessInstance.getCatalogData(), catalogDataLoadDataProcessInstance.getCatalogData(), "Catalog data are the same");
		Factory.catalogLoadDataProcessInstance.setCatalogData(catalogDataLoadDataProcessInstance.getCatalogData());
	}

	@Test
	public void postCatalogDataLoadDataInternalNoAuthentication() throws JsonProcessingException {

		given()
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(catalogloadDataProcessInstance)+ processInstanceId).when()
				.post(CredentialsUtils.CATALOGS + Endpoints.middleURLDataLoadDataProcessDefinition)
				.then()
				.statusCode(401);
	}
}
