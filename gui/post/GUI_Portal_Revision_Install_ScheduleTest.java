package com.agys.gui.post;


import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.enums.Environments;
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

@Slf4j
public class GUI_Portal_Revision_Install_ScheduleTest {

	private ObjectMapper mapper = new ObjectMapper();
	
	private String active = "true";
	private String guiControlId ="2453645734-76345735-2576348534";
	private String installedGUIControlRevisionId ="275634583456-683458536-8338753";
	private String instanceId="7234wefjwes-82364382y45wefl-2634832";
	private String toBeInstalledGUIControlRevisionId="swjfsdjfweruew-8347nfkdsn-sakfjsd-84375";

	PortalRevisionInstall portalRevisionInstallJson = PortalRevisionInstall.builder().active(active)
			.guiControlId(guiControlId).installedGUIControlRevisionId(installedGUIControlRevisionId).
					instanceId(instanceId).toBeInstalledGUIControlRevisionId(toBeInstalledGUIControlRevisionId).
					build();

	
	@Test
	public void postGUIPortalRevisionInstallSchedule() throws JsonProcessingException {
		ValidatableResponse vr =
				given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
						.contentType(ContentType.JSON).body(mapper.writeValueAsString(portalRevisionInstallJson)).when()
						.post(CredentialsUtils.getProperty("baseURLGUI") + Endpoints.middleURLGUIPortalRevisionInstallList).then()
						.statusCode(201);

		String location = ((ValidatableResponseImpl) vr).originalResponse().header("Location");

		String response = given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(Factory.catalogContentExportJson)).when()
				.get(location)
				.then()
				.contentType(ContentType.JSON).extract().response().asString();

		PortalRevisionInstall portalRevisionInstallation = JsonHelper.readValue(response, PortalRevisionInstall.class);

		assertEquals(Factory.portalRevisionInstall.getGuiControlId(), portalRevisionInstallation.getGuiControlId(), "GUI Control Ids are equals");
		assertEquals(Factory.portalRevisionInstall.getInstalledGUIControlRevisionId(), portalRevisionInstallation.getInstalledGUIControlRevisionId(), "Installed GUI Control Revision Ids are equals");
		assertEquals(Factory.portalRevisionInstall.getInstanceId(), portalRevisionInstallation.getInstanceId(), "Instance Ids are equals");
		assertEquals(Factory.portalRevisionInstall.getToBeInstalledGUIControlRevisionId(), portalRevisionInstallation.getToBeInstalledGUIControlRevisionId(), "To be installed GUI Control Revision Ids are equals");

		Factory.portalRevisionInstall.setGuiControlId(portalRevisionInstallation.getGuiControlId());
		Factory.portalRevisionInstall.setInstalledGUIControlRevisionId(portalRevisionInstallation.getInstalledGUIControlRevisionId());
		Factory.portalRevisionInstall.setInstanceId(portalRevisionInstallation.getInstanceId());
		Factory.portalRevisionInstall.setToBeInstalledGUIControlRevisionId(portalRevisionInstallation.getToBeInstalledGUIControlRevisionId());
	}

	@Test
	public void postGUIPortalRevisionInstallScheduleNoAuthentication() throws JsonProcessingException {
			given().contentType(ContentType.JSON).body(mapper.writeValueAsString(portalRevisionInstallJson)).when()
				.post(CredentialsUtils.getProperty("baseURLGUI") + Endpoints.middleURLGUIPortalRevisionInstallList).then()
				.statusCode(401);
	}
}
