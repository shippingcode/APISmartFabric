package com.agys.documents.documentTemplateRest.get;


import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.enums.Environments;
import com.agys.enums.ProcessDefinitionEnum;
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
public class Documents_Templates_ProcessDefinition_By_ProcessDefinitionIdTest {

	private ProcessDefinitionEnum PROCESS_DEFINITION;

	@Test
	public void getDocumentsProcessDefinitionByProcessDefinitionId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.DOCUMENTS
						+ Endpoints.middleURLDocumentsTemplatesProcessDefinition + PROCESS_DEFINITION.PROCESS_DEFINITION_OK1.getId())
				.then().assertThat().statusCode(200);
		log.info("Documents_Templates_ProcessDefinition_By_ProcessDefinitionId" + CredentialsUtils.DOCUMENTS
				+ Endpoints.middleURLDocumentsTemplatesProcessDefinition + PROCESS_DEFINITION.PROCESS_DEFINITION_OK1.getId());
	}

	@Test
	public void getDocumentsProcessDefinitionByInvalidProcessDefinitionId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.DOCUMENTS
						+ Endpoints.middleURLDocumentsTemplatesProcessDefinition
						+ PROCESS_DEFINITION.PROCESS_DEFINITION_INVALID.getId())
				.then().assertThat().statusCode(404);
		log.info("Documents_Templates_ProcessDefinition_By_ProcessDefinitionId" + CredentialsUtils.DOCUMENTS
				+ Endpoints.middleURLDocumentsTemplatesProcessDefinition + PROCESS_DEFINITION.PROCESS_DEFINITION_INVALID.getId());
	}

	@Test
	public void getDocumentsProcessDefinitionByNULLProcessDefinitionId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.DOCUMENTS
						+ Endpoints.middleURLDocumentsTemplatesProcessDefinition + PROCESS_DEFINITION.PROCESS_DEFINITION_NULL.getId())
				.then().assertThat().statusCode(400);
		log.info("Documents_Templates_ProcessDefinition_By_ProcessDefinitionId" + CredentialsUtils.DOCUMENTS
				+ Endpoints.middleURLDocumentsTemplatesProcessDefinition + PROCESS_DEFINITION.PROCESS_DEFINITION_NULL.getId());
	}

	@Test
	public void getDocumentsProcessDefinitionByProcessDefinitionIdNoAuthentication() throws FileNotFoundException {
		given().when().contentType(ContentType.JSON)
				.get(CredentialsUtils.DOCUMENTS
						+ Endpoints.middleURLDocumentsTemplatesProcessDefinition + PROCESS_DEFINITION.PROCESS_DEFINITION_OK4.getId())
				.then().assertThat().statusCode(401);
		log.info("Documents_Templates_ProcessDefinition_By_ProcessDefinitionId" + CredentialsUtils.DOCUMENTS
				+ Endpoints.middleURLDocumentsTemplatesProcessDefinition + PROCESS_DEFINITION.PROCESS_DEFINITION_OK4.getId());
	}
}
