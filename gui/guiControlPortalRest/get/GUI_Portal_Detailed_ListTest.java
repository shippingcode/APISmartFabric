package com.agys.gui.guiControlPortalRest.get;


import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.enums.Environments;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.agys.utils.CredentialsUtils;
import com.jayway.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;

import static com.agys.Constants.PRINCIPAL_HEADER_NAME;
import static com.jayway.restassured.RestAssured.given;
import java.io.FileNotFoundException;

/**
 * 
 * @author aila.bogasieru@agys.ch
 *
 */
@Slf4j

public class GUI_Portal_Detailed_ListTest {


	@Test
	public void getGUIPortalDetailedList() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE).
				when().contentType(ContentType.JSON)
				.get(CredentialsUtils.GUI
						+ Endpoints.middleURLGUIPortalDetailedList)
				.then().assertThat().statusCode(200);
		log.info("GUI_Portal_Detailed_List" + CredentialsUtils.GUI
				+ Endpoints.middleURLGUIPortalDetailedList);
	}

	@Test
	public void getGUIPortalDetailedListNoAuthentication() throws FileNotFoundException {
		given().when().contentType(ContentType.JSON)
				.get(CredentialsUtils.GUI
				+
						Endpoints.middleURLGUIPortalDetailedList)
				.then().assertThat().statusCode(401);
		log.info("GUI_Portal_Detailed_List" + CredentialsUtils.GUI
				+ Endpoints.middleURLGUIPortalDetailedList);
	}
}
