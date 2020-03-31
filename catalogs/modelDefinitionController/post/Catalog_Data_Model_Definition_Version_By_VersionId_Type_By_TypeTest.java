package com.agys.catalogs.modelDefinitionController.post;


import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.enums.Environments;
import com.agys.jsonBuilder.DataModelDefinitionVersion;
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
public class Catalog_Data_Model_Definition_Version_By_VersionId_Type_By_TypeTest {

	private ObjectMapper mapper = new ObjectMapper();

	private String diagram = "swewrfwe";
	private String fieldsId="wesr";
	private String fieldsBCReady="swerw";
	private String fieldsEmbeded ="dgDF";
	private String fieldsIndexable="dfghf";
	private String fieldsList="FGhg";
	private String fieldName="field";
	private String fieldType="type";
	private String id="508b2cf1-as2b-4d4e-8d1a-h7f85c4e8177";
	private String isBCReady="true";
	private String name="ThisIsAName";
	private String type="type1";
	public static final String versionId ="508b2cf1-bc2b-4d4e-8d1a-d5f85c4e8177";


	DataModelDefinitionVersion catalogModelDefinitionVersion = DataModelDefinitionVersion.builder().diagram(diagram)
			.fieldsId(fieldsId).fieldsBCReady(fieldsBCReady).
					fieldsEmbeded(fieldsEmbeded).fieldsIndexable(fieldsIndexable).fieldsList(fieldsList).
			fieldName(fieldName).fieldType(fieldType).id(id).isBCReady(isBCReady).name(name).
					type(type).build();

	@Test
	public void posCatalogDataModelDefinitionVersionByVersionIdTypeByType() throws JsonProcessingException {

		ValidatableResponse vr = given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(catalogModelDefinitionVersion)).when()
				.post(CredentialsUtils.CATALOGS + Endpoints.middleURLDataModelDefinitionVersion + versionId +
						Endpoints.middleURLDataModelDefinitionVersionProcessDefinitionType3
						+type)
				.then()
				.statusCode(201);

		String location = ((ValidatableResponseImpl) vr).originalResponse().header("Location");

		String response = given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(Factory.dataModelDefVersion)).when()
				.get(location)
				.then()
				.contentType(ContentType.JSON).extract().response().asString();

		DataModelDefinitionVersion dataModelDefinitionVersion= JsonHelper.readValue(response, DataModelDefinitionVersion.class);
		assertEquals(Factory.dataModelDefVersion.getDiagram(), dataModelDefinitionVersion.getDiagram(), "The diagrams are equals");
		assertEquals(Factory.dataModelDefVersion.getFieldName(), dataModelDefinitionVersion.getFieldName(), "The filed names are equals");
		assertEquals(Factory.dataModelDefVersion.getId(), dataModelDefinitionVersion.getId(), "The ids are equals");
		assertEquals(Factory.dataModelDefVersion.getName(), dataModelDefinitionVersion.getName(), "The names are equals");
		Factory.dataModelDefVersion.setId(dataModelDefinitionVersion.getId());
		Factory.dataModelDefVersion.setName(dataModelDefinitionVersion.getName());
	}

	@Test
	public void posCatalogDataModelDefinitionVersionByVersionIdTypeByTypeNoAuthentication() throws JsonProcessingException {

		given()
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(catalogModelDefinitionVersion)).when()
				.post(CredentialsUtils.CATALOGS + Endpoints.middleURLDataModelDefinitionVersion + versionId +
						Endpoints.middleURLDataModelDefinitionVersionProcessDefinitionType3
						+type)
				.then()
				.statusCode(401);
	}
}
