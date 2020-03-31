package com.agys.documents.documentTemplateRest.get;


import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.enums.DocumentsIdsEnum;
import com.agys.enums.Environments;
import com.agys.utils.CredentialsUtils;
import com.jayway.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

import static com.agys.Constants.PRINCIPAL_HEADER_NAME;
import static com.jayway.restassured.RestAssured.given;

/**
 * 
 * @author aila.bogasieru@agys.ch
 *
 */

@Slf4j
public class Documents_Templates_By_IdTest {

	private DocumentsIdsEnum DOCUMENTS;

	@Test
	public void getDocumentsTemplatesById() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.DOCUMENTS
						+ Endpoints.middleURLDocumentsTemplates + DOCUMENTS.DOCUMENT_OK1.getId())
				.then().assertThat().statusCode(200);
		log.info("Documents_Templates_By_Id" + CredentialsUtils.DOCUMENTS
				+ Endpoints.middleURLDocumentsTemplates + DOCUMENTS.DOCUMENT_OK1.getId());
	}

	@Test
	public void getDocumentsTemplatesByInvalidId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.DOCUMENTS + Endpoints.middleURLDocumentsTemplates
						+ DOCUMENTS.DOCUMENT_INVALID.getId())
				.then().assertThat().statusCode(404);
		log.info("Documents_Templates_By_Id" + CredentialsUtils.DOCUMENTS
				+ Endpoints.middleURLDocumentsTemplates + DOCUMENTS.DOCUMENT_INVALID.getId());
	}

	@Test
	public void getDocumentsTemplatesByNULLId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.DOCUMENTS +
						Endpoints.middleURLDocumentsTemplates + DOCUMENTS.DOCUMENT_NULL.getId())
				.then().assertThat().statusCode(400);
		log.info("Documents_Templates_By_Id" + CredentialsUtils.DOCUMENTS
				+ Endpoints.middleURLDocumentsTemplates + DOCUMENTS.DOCUMENT_NULL.getId());
	}

	@Test
	public void getDocumentsTemplatesByIdnNoAuthentication() throws FileNotFoundException {
		given().when().contentType(ContentType.JSON)
				.get(CredentialsUtils.DOCUMENTS
						+ Endpoints.middleURLDocumentsTemplates + DOCUMENTS.DOCUMENT_OK1.getId())
				.then().assertThat().statusCode(401);
		log.info("Documents_Templates_By_Id" + CredentialsUtils.DOCUMENTS
				+ Endpoints.middleURLDocumentsTemplates + DOCUMENTS.DOCUMENT_OK1.getId());
	}
}
