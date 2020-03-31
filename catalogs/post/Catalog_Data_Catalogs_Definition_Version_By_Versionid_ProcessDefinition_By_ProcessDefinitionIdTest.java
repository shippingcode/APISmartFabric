package com.agys.catalogs.post;


import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.enums.Environments;
import com.agys.jsonBuilder.DataCatalogsDefinitionVersion;
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
public class Catalog_Data_Catalogs_Definition_Version_By_Versionid_ProcessDefinition_By_ProcessDefinitionIdTest {

	private ObjectMapper mapper = new ObjectMapper();

	private String description = "this is a field description";
	private String idFields="5666";
	private String nameFields ="nameFileds";
	private String type="dfghf";
	private String idDescription="508b2cf1-bc2b-4d4e-8d1a-d5f85c4e8177";
	private String nameDescription="this is a description";
	private String removed="yes";
	private String versionId ="345643456546";
	private String processDefinitionId="364545654";

	DataCatalogsDefinitionVersion catalogDefinitionVersion = DataCatalogsDefinitionVersion.builder().description(description)
			.idFields(idFields).nameFields(nameFields).
					type(type).idDescription(idDescription).
					nameDescription(nameDescription).removed(removed).
					build();

	@Test
	public void postCatalogDataCatalogsContentLoadVersion() throws JsonProcessingException {

		ValidatableResponse vr =
				given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
						.contentType(ContentType.JSON).body(mapper.writeValueAsString(catalogDefinitionVersion)).when()
						.post(CredentialsUtils.CATALOGS + Endpoints.middleURLDataCatalogsDefinitionVersion1 + versionId +
								Endpoints.middleURLDataCatalogsDefinitionVersion2 + processDefinitionId)
						.then()
						.statusCode(201);

		String location = ((ValidatableResponseImpl) vr).originalResponse().header("Location");

		String response = given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(Factory.dataCatalogDefVersion)).when()
				.get(location)
				.then()
				.contentType(ContentType.JSON).extract().response().asString();

		DataCatalogsDefinitionVersion dataModelContentSaveVersion= JsonHelper.readValue(response, DataCatalogsDefinitionVersion.class);
		assertEquals(Factory.dataCatalogDefVersion.getDescription(), dataModelContentSaveVersion.getDescription(), "Descriptions are equals");
		assertEquals(Factory.dataCatalogDefVersion.getIdFields(), dataModelContentSaveVersion.getIdFields(), "IdFields are equals");
		assertEquals(Factory.dataCatalogDefVersion.getNameFields(), dataModelContentSaveVersion.getNameFields(), "Name fields are equals");
		assertEquals(Factory.dataCatalogDefVersion.getType(), dataModelContentSaveVersion.getType(), "Types are equals");
		assertEquals(Factory.dataCatalogDefVersion.getIdDescription(), dataModelContentSaveVersion.getIdDescription(), "Ids description are equals");
		assertEquals(Factory.dataCatalogDefVersion.getNameDescription(), dataModelContentSaveVersion.getNameDescription(), "Names description are equals");
		Factory.dataCatalogDefVersion.setDescription(dataModelContentSaveVersion.getDescription());
		Factory.dataCatalogDefVersion.setIdFields(dataModelContentSaveVersion.getIdFields());
		Factory.dataCatalogDefVersion.setNameFields(dataModelContentSaveVersion.getNameFields());
	}

	@Test
	public void postCatalogDataCatalogsContentLoadVersionNoAuthentication() throws JsonProcessingException {
			given()
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(catalogDefinitionVersion)).when()
				.post(CredentialsUtils.CATALOGS + Endpoints.middleURLDataCatalogsDefinitionVersion1 + versionId +
						Endpoints.middleURLDataCatalogsDefinitionVersion2 + processDefinitionId)
				.then()
				.statusCode(401);
	}
}
