package com.agys.documents.documentTemplateRest.post;

import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.enums.Environments;
import com.agys.jsonBuilder.DocumentsExport;
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

public class Documents_Templates_ExportSimpleTest {
	private ObjectMapper mapper = new ObjectMapper();

	public String html = "<!DOCTYPE html> <html> <head> <style id=\"page-size\">@page { size: A4 }</style></head> <body class=\"A4\" size=\"A4\" > <p>some text&nbsp;${CurrentTime}</p> </body> </html>";
	public String invalidHtml = "sedfsdfdsFSd75934534";

	@Test
	public void postDocumentsTemplatesExportSimple() throws JsonProcessingException {

		DocumentsExport docExportJson = DocumentsExport.builder().html(html)
				.build();

		ValidatableResponse vr =
				given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(docExportJson)).when()
				.post(CredentialsUtils.DOCUMENTS + Endpoints.middleURLDocumentsTemplatesExportSimple).then()
				.statusCode(201);

		String location = ((ValidatableResponseImpl) vr).originalResponse().header("Location");

		String response = given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(Factory.catalogContentExportJson)).when()
				.get(location)
				.then()
				.contentType(ContentType.JSON).extract().response().asString();

		DocumentsExport createDocumentsExport = JsonHelper.readValue(response, DocumentsExport.class);
		assertEquals(Factory.documentsExport.getHtml(), createDocumentsExport.getHtml(), "Htmls are equals");
	    Factory.documentsExport.setHtml(createDocumentsExport.getHtml());
	}


	@Test
	public void postDocumentsTemplatesExportSimpleNoAuthentication() throws JsonProcessingException {
		DocumentsExport docExportJson = DocumentsExport.builder().html(html)
				.build();

		given()
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(docExportJson)).when()
				.post(CredentialsUtils.DOCUMENTS + Endpoints.middleURLDocumentsTemplatesExportSimple).then()
				.statusCode(401);
	}

	@Test
	public void postWrongDocumentsTemplatesExportSimple() throws JsonProcessingException {
		DocumentsExport docExportJson = DocumentsExport.builder().invalidHtml(invalidHtml)
				.build();

		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(docExportJson)).when()
				.post(CredentialsUtils.DOCUMENTS + Endpoints.middleURLDocumentsTemplatesExportSimple).then()
				.statusCode(404);
	}
}
