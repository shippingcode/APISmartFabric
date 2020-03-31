package com.agys.catalogs.processInstanceDataController.post;


import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.enums.Environments;
import com.agys.jsonBuilder.CatalogDataLoadDataInternal;
;
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
public class Catalog_Data_LoadData_InternalTest {

	private ObjectMapper mapper = new ObjectMapper();

	private String includeAttachmentData = "true";
	private String includeCatalogData="true";
	private String processInstanceId ="a36d58ac-be8f-4256-8b3c-90e1bc920c3d";
    private String versionId="a36d58ac-be8f-4256-8b3c-90e1bc920c3d";
	private String processDefinitionId="a36d58ac-be8f-4256-8b3c-90e1bc920c3d";

	CatalogDataLoadDataInternal catalogloadDataInternal = CatalogDataLoadDataInternal.builder().includeAttachmentData(includeAttachmentData)
			.includeCatalogData(includeCatalogData).processDefinitionId(processDefinitionId).
					processInstanceId(processInstanceId).versionId(versionId).build();

	@Test
	public void postCatalogDataLoadDataInternal() throws JsonProcessingException {

		ValidatableResponse vr =
				given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
						.contentType(ContentType.JSON).body(mapper.writeValueAsString(catalogloadDataInternal)).when()
						.post(CredentialsUtils.CATALOGS + Endpoints.middleURLDataLoaddataInternal)
						.then()
						.statusCode(201);

		String location = ((ValidatableResponseImpl) vr).originalResponse().header("Location");

		String response = given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(Factory.dataModelDefVersion)).when()
				.get(location)
				.then()
				.contentType(ContentType.JSON).extract().response().asString();

		CatalogDataLoadDataInternal catalogDataLoadDataInternal= JsonHelper.readValue(response, CatalogDataLoadDataInternal.class);
		assertEquals(Factory.catalogDataLoadDataIntern.getProcessInstanceId(), catalogDataLoadDataInternal.getProcessInstanceId(), "Process Instances are equals");
		assertEquals(Factory.catalogDataLoadDataIntern.getVersionId(), catalogDataLoadDataInternal.getVersionId(), "Versions ids are equals");
		assertEquals(Factory.catalogDataLoadDataIntern.getProcessDefinitionId(), catalogDataLoadDataInternal.getProcessDefinitionId(), "Process definition Ids are equals");

		Factory.catalogDataLoadDataIntern.setProcessInstanceId(catalogDataLoadDataInternal.getProcessInstanceId());
		Factory.catalogDataLoadDataIntern.setVersionId(catalogDataLoadDataInternal.getVersionId());
		Factory.catalogDataLoadDataIntern.setProcessDefinitionId(catalogDataLoadDataInternal.getProcessDefinitionId());
	}

	@Test
	public void postCatalogDataLoadDataInternalNoAuthentication() throws JsonProcessingException {

		given()
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(catalogloadDataInternal)).when()
				.post(CredentialsUtils.CATALOGS + Endpoints.middleURLDataLoaddataInternal)
				.then()
				.statusCode(401);
	}
}
