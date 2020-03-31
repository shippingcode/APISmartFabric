package com.agys.documents.documentTemplateRest.post;

import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.enums.Environments;
import com.agys.jsonBuilder.DocumentsTemplates;
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

public class Documents_TemplatesTest {

	private ObjectMapper mapper = new ObjectMapper();

	private String description = "Description";
	private String h = "0";
	private String id = "d7eaf674-d4dd-42bd-bbb4-a9eb2951926f";
	private String isActive = "true";
	private String isAdvanced = "yes";
	private String iteration = "yes";
	private String name = "AutomatedDocumentsApi";
	private String ownerId = "d7eaf674-d4dd-42bd-bbb4-a9eb2951926f";
	private String processDefinitionId = "d7eaf674-d4dd-42bd-bbb4-a9eb2951926f";
	private String template = "346546$";
	private String usedAttributes = "24";
	private String versionId = "d7eaf674-d4dd-42bd-bbb4-a9eb2951926f";
	private String w = "0";

	DocumentsTemplates docsTemplates = DocumentsTemplates.builder().description(description)
			.h(h).id(id).isActive(isActive).
					isAdvanced(isAdvanced).iteration(iteration).name(name).
					ownerId(ownerId).processDefinitionId(processDefinitionId).template(template).usedAttributes(usedAttributes).versionId(versionId).
					w(w).build();

	@Test
	public void postDocumentsTemplates() throws JsonProcessingException {
		ValidatableResponse vr =
				given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE).
						contentType(ContentType.JSON).body(mapper.writeValueAsString(docsTemplates)).when()
						.post(CredentialsUtils.DOCUMENTS + Endpoints.middleURLDocumentsTemplates).then()
						.statusCode(201);

		String location = ((ValidatableResponseImpl) vr).originalResponse().header("Location");

		String response = given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(Factory.catalogContentExportJson)).when()
				.get(location)
				.then()
				.contentType(ContentType.JSON).extract().response().asString();

		DocumentsTemplates documentsTemplatesJson= JsonHelper.readValue(response, DocumentsTemplates.class);
		assertEquals(Factory.documentsTemplates.getDescription(), documentsTemplatesJson.getDescription(), "Descriptions are equals");
		assertEquals(Factory.documentsTemplates.getH(), documentsTemplatesJson.getH(), "Hs are equals");
		assertEquals(Factory.documentsTemplates.getId(), documentsTemplatesJson.getId(), "Ids are equals");
		assertEquals(Factory.documentsTemplates.getName(), documentsTemplatesJson.getName(), "Names are equals");
		assertEquals(Factory.documentsTemplates.getOwnerId(), documentsTemplatesJson.getOwnerId(), "Owner Ids are equals");
		assertEquals(Factory.documentsTemplates.getProcessDefinitionId(), documentsTemplatesJson.getProcessDefinitionId(), "Processes definition are equals");
		assertEquals(Factory.documentsTemplates.getTemplate(), documentsTemplatesJson.getTemplate(), "Templates are equals");
		assertEquals(Factory.documentsTemplates.getVersionId(), documentsTemplatesJson.getVersionId(), "Version Ids are equals");
		assertEquals(Factory.documentsTemplates.getW(), documentsTemplatesJson.getW(), "Ws are equals");

		Factory.documentsTemplates.setDescription(documentsTemplatesJson.getDescription());
		Factory.documentsTemplates.setH(documentsTemplatesJson.getH());
		Factory.documentsTemplates.setId(documentsTemplatesJson.getId());
		Factory.documentsTemplates.setName(documentsTemplatesJson.getName());
		Factory.documentsTemplates.setOwnerId(documentsTemplatesJson.getOwnerId());
		Factory.documentsTemplates.setProcessDefinitionId(documentsTemplatesJson.getProcessDefinitionId());
		Factory.documentsTemplates.setTemplate(documentsTemplatesJson.getTemplate());
		Factory.documentsTemplates.setVersionId(documentsTemplatesJson.getVersionId());
		Factory.documentsTemplates.setW(documentsTemplatesJson.getW());
}

	@Test
	public void postDocumentsTemplatesNoAuthentication() throws JsonProcessingException {

		given().
				contentType(ContentType.JSON).body(mapper.writeValueAsString(docsTemplates)).when()
				.post(CredentialsUtils.DOCUMENTS + Endpoints.middleURLDocumentsTemplates).then()
				.statusCode(401);
}

	@Test
	public void postWrongDocumentsTemplates() throws JsonProcessingException {

		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE).
				contentType(ContentType.JSON).body(mapper.writeValueAsString(docsTemplates)).when()
				.post(CredentialsUtils.DOCUMENTS + Endpoints.middleURLDocumentsTemplates).then()
				.statusCode(404);
	}
}
