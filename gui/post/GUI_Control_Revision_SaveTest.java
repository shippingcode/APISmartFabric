package com.agys.gui.post;

import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.enums.Environments;
import com.agys.jsonBuilder.GuiControlRevisionSave;
import com.agys.jsonBuilder.PortalRevisionInstall;
import com.agys.model.Factory;
import com.agys.utils.JsonHelper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.internal.ValidatableResponseImpl;
import com.jayway.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.agys.utils.CredentialsUtils;
import com.jayway.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;

import static com.agys.Constants.PRINCIPAL_HEADER_NAME;
import static com.jayway.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;

/**
 * 
@author aila.bogasieru@agys.ch
 *
 */

@Slf4j
public class GUI_Control_Revision_SaveTest {

	private ObjectMapper mapper = new ObjectMapper();

	private String code = "34535";
	private String config ="34543";
	private String fileName ="trr";
	private String fileType="tert";
	private String fileUUID="3456464";
	private String guiControlId="46456";
	private String guiControlRevisionId="34645";
	private String revision ="10";

	GuiControlRevisionSave guiControlRevisionSave = GuiControlRevisionSave.builder().code(code)
			.config(config).fileName(fileName).
					fileType(fileType).fileUUID(fileUUID).guiControlId(guiControlId).guiControlRevisionId(guiControlRevisionId).revision(revision).
					build();

	@Test
	public void postGUIControlRevisionSave() throws FileNotFoundException, JsonProcessingException {
		ValidatableResponse vr =
				given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
						.contentType(ContentType.JSON).body(mapper.writeValueAsString(guiControlRevisionSave)).when()
						.post(CredentialsUtils.GUI + Endpoints.middleURLGUIControlRevisionSave).then()
						.statusCode(201);

		String location = ((ValidatableResponseImpl) vr).originalResponse().header("Location");

		String response = given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(Factory.catalogContentExportJson)).when()
				.get(location)
				.then()
				.contentType(ContentType.JSON).extract().response().asString();

		GuiControlRevisionSave guiControlRevisionSaveJson= JsonHelper.readValue(response, GuiControlRevisionSave.class);

		assertEquals(Factory.guiControlRevisionSave.getCode(), guiControlRevisionSaveJson.getCode(), "Codes are equals");
		assertEquals(Factory.guiControlRevisionSave.getConfig(), guiControlRevisionSaveJson.getConfig(), "Configs are equals");
		assertEquals(Factory.guiControlRevisionSave.getFileName(), guiControlRevisionSaveJson.getFileName(), "Files are equals");
		assertEquals(Factory.guiControlRevisionSave.getGuiControlId(), guiControlRevisionSaveJson.getGuiControlId(), "GUI Control Ids are equals");
		assertEquals(Factory.guiControlRevisionSave.getFileType(), guiControlRevisionSaveJson.getFileType(), "File types are equals");
		assertEquals(Factory.guiControlRevisionSave.getFileUUID(), guiControlRevisionSaveJson.getFileUUID(), "File UUIDs are equals");
		assertEquals(Factory.guiControlRevisionSave.getGuiControlRevisionId(), guiControlRevisionSaveJson.getGuiControlRevisionId(), "Control Revision Ids are equals");
		assertEquals(Factory.guiControlRevisionSave.getRevision(), guiControlRevisionSaveJson.getRevision(), "Revisions are equals");

		Factory.guiControlRevisionSave.setCode(guiControlRevisionSaveJson.getCode());
		Factory.guiControlRevisionSave.setConfig(guiControlRevisionSaveJson.getConfig());
		Factory.guiControlRevisionSave.setFileName(guiControlRevisionSaveJson.getFileName());
		Factory.guiControlRevisionSave.setFileType(guiControlRevisionSaveJson.getFileType());
		Factory.guiControlRevisionSave.setFileUUID(guiControlRevisionSaveJson.getFileUUID());
		Factory.guiControlRevisionSave.setGuiControlId(guiControlRevisionSaveJson.getGuiControlId());
		Factory.guiControlRevisionSave.setGuiControlRevisionId(guiControlRevisionSaveJson.getGuiControlRevisionId());
		Factory.guiControlRevisionSave.setRevision(guiControlRevisionSaveJson.getRevision());

		log.info("GUI_Control_Revision_Save" + CredentialsUtils.getProperty("baseURLGUI")
		+ Endpoints.middleURLGUIControlRevisionSave);
	}
	
	@Test
	public void postGUIControlRevisionSaveNoAuthentication() throws FileNotFoundException, JsonProcessingException {
		given()
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(guiControlRevisionSave)).when()
				.post(CredentialsUtils.GUI + Endpoints.middleURLGUIControlRevisionSave)
		.then().assertThat().statusCode(401);
		log.info("GUI_Control_Revision_Save" + CredentialsUtils.getProperty("baseURLGUI")
		+ Endpoints.middleURLGUIControlRevisionSave);
	}
}
