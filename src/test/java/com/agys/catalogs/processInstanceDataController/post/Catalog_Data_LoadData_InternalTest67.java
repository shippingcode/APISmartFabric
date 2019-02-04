package com.agys.catalogs.processInstanceDataController.post;


import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.jsonBuilder.CatalogDataLoadDataInternal;
import com.agys.jsonBuilder.DataCatalogsContentVersion;
import com.agys.utils.CredentialsUtils;
import com.agys.utils.RensposeBodyDisplay;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import static com.agys.Constants.PRINCIPAL_HEADER_NAME;
import static com.jayway.restassured.RestAssured.given;

@Slf4j
public class Catalog_Data_LoadData_InternalTest67 {

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

		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(catalogloadDataInternal)).when()
				.post(CredentialsUtils.getProperty("baseURLCatalogs") + Endpoints.middleURLDataLoaddataInternal)
				.then()
				.statusCode(201);
	}

	@Test
	public void postCatalogDataLoadDataInternalNoAuthentication() throws JsonProcessingException {

		given()
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(catalogloadDataInternal)).when()
				.post(CredentialsUtils.getProperty("baseURLCatalogs") + Endpoints.middleURLDataLoaddataInternal)
				.then()
				.statusCode(401);
	}
}