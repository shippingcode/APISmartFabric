package com.agys.catalogs.post;


import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.enums.Environments;
import com.agys.jsonBuilder.DataCatalogsContentSaveVersion;
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
public class Catalog_Data_Catalogs_Content_Save_Version_By_Versionid_ProcessDefinition_By_ProcessDefinitionIdTest {

	private ObjectMapper mapper = new ObjectMapper();

	private String active="true";
	private String code= "34566546546";
	private String columns="1";
	private String name="name";
	private String nameTranslations="name";
	private String additionalProp1="prop1";
	private String additionalProp2="prop2";
	private String additionalProp3="prop3";
	private String type="type";
	private String versionId ="2543534534534";
	private String processDefinitionId="343646456";

	DataCatalogsContentSaveVersion catalogContentSaveVersion = DataCatalogsContentSaveVersion.builder().active(active)
			.code(code).columns(columns).
					name(name).nameTranslations(nameTranslations).
					additionalProp1(additionalProp1).
					additionalProp2(additionalProp2).
					additionalProp3(additionalProp3).
					type(type).
					build();

	@Test
	public void postCatalogDataCatalogsContentSaveVersion() throws JsonProcessingException {
		ValidatableResponse vr =
				given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
						.contentType(ContentType.JSON).body(mapper.writeValueAsString(catalogContentSaveVersion)).when()
						.post(CredentialsUtils.CATALOGS + Endpoints.middleURLDataCatalogsContentSaveVersion1 + versionId +
								Endpoints.middleURLDataCatalogsContentSaveVersion2 + processDefinitionId)
						.then()
						.statusCode(201);

		String location = ((ValidatableResponseImpl) vr).originalResponse().header("Location");

		String response = given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(Factory.dataModelDefVersion)).when()
				.get(location)
				.then()
				.contentType(ContentType.JSON).extract().response().asString();

		DataCatalogsContentSaveVersion dataModelContentSaveVersion= JsonHelper.readValue(response, DataCatalogsContentSaveVersion.class);
		assertEquals(Factory.dataCatalogsContentSaveVersion.getCode(), dataModelContentSaveVersion.getCode(), "Codes are equals");
		assertEquals(Factory.dataCatalogsContentSaveVersion.getColumns(), dataModelContentSaveVersion.getColumns(), "Columns are equals");
		assertEquals(Factory.dataCatalogsContentSaveVersion.getName(), dataModelContentSaveVersion.getName(), "Names are equals");
		assertEquals(Factory.dataCatalogsContentSaveVersion.getType(), dataModelContentSaveVersion.getType(), "Types are equals");
		Factory.dataCatalogsContentSaveVersion.setCode(dataModelContentSaveVersion.getCode());
		Factory.dataCatalogsContentSaveVersion.setName(dataModelContentSaveVersion.getName());
	}

	@Test
	public void postCatalogDataCatalogsContentSaveVersionNoAuthentication() throws JsonProcessingException {

		given()
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(catalogContentSaveVersion)).when()
				.post(CredentialsUtils.CATALOGS + Endpoints.middleURLDataCatalogsContentSaveVersion1 + versionId +
						Endpoints.middleURLDataCatalogsContentSaveVersion2 + processDefinitionId)
				.then()
				.statusCode(401);

	}
}
