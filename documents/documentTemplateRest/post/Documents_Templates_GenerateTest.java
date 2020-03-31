package com.agys.documents.documentTemplateRest.post;

import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.enums.Environments;
import com.agys.jsonBuilder.DocumentsGenerate;
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

public class Documents_Templates_GenerateTest {

	private ObjectMapper mapper = new ObjectMapper();

	private static final String processInstanceId = "";
	private static final String documentTemplateId = "";
	private static final String fileName = "";
	private static final String savePath = "";
	private static final String invalidProcessInstanceId = "";


	DocumentsGenerate docGenerateJson = DocumentsGenerate.builder().processInstanceId(processInstanceId)
			.documentTemplateId(documentTemplateId).fileName(fileName).
					savePath(savePath).build();

	@Test
	public void postDocumentsTemplatesGenerate() throws JsonProcessingException {

		ValidatableResponse vr =
				given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
						.contentType(ContentType.JSON).body(mapper.writeValueAsString(docGenerateJson)).when()
						.post(CredentialsUtils.DOCUMENTS + Endpoints.middleURLDocumentsTemplatesGenerate).then()
						.statusCode(201);

		String location = ((ValidatableResponseImpl) vr).originalResponse().header("Location");

		String response = given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(Factory.catalogContentExportJson)).when()
				.get(location)
				.then()
				.contentType(ContentType.JSON).extract().response().asString();

		DocumentsGenerate docsGenerate = JsonHelper.readValue(response, DocumentsGenerate.class);
		assertEquals(Factory.documentsGenerate.getProcessInstanceId(), docsGenerate.getProcessInstanceId(), "Process Instance Ids are equals");
		assertEquals(Factory.documentsGenerate.getDocumentTemplateId(), docsGenerate.getDocumentTemplateId(), "Documents templates are equals");
		assertEquals(Factory.documentsGenerate.getFileName(), docsGenerate.getFileName(), "File names are equals");
		assertEquals(Factory.documentsGenerate.getSavePath(), docsGenerate.getSavePath(), "Save paths are equals");
		Factory.documentsGenerate.setProcessInstanceId(docsGenerate.getProcessInstanceId());
		Factory.documentsGenerate.setDocumentTemplateId(docsGenerate.getDocumentTemplateId());
		Factory.documentsGenerate.setFileName(docsGenerate.getFileName());
		Factory.documentsGenerate.setSavePath(docsGenerate.getSavePath());
	}

	@Test
	public void postDocumentsTemplatesGenerateNoAuthentication() throws JsonProcessingException {

	given()
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(docGenerateJson)).when()
				.post(CredentialsUtils.DOCUMENTS + Endpoints.middleURLDocumentsTemplatesGenerate).then()
				.statusCode(401);
	}

	@Test
	public void postWrongDocumentsTemplatesGenerate() throws JsonProcessingException {

		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(docGenerateJson)).when()
				.post(CredentialsUtils.DOCUMENTS+ Endpoints.middleURLDocumentsTemplatesGenerate).then()
				.statusCode(404);
	}
}
