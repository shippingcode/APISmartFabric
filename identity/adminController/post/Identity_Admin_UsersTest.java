package com.agys.identity.adminController.post;

import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.enums.Environments;
import com.agys.jsonBuilder.AdminUsers;
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
public class Identity_Admin_UsersTest {
	private ObjectMapper mapper = new ObjectMapper();

	private String code="3566";
	private String department="IT";
	private String email="d634b2@agys.ch";
	private String firstName="John";
	private String gender="FEMALE";
	private String id="00000000-0000-0000-0000-000000000001";
	private String language="EN";
	private String lastName="Pop";
	private String password="aqwerwe5345";
	private String passwordLastUpdate="";
	private String phone="34543646";
	private String position="ADMIN";
	private String reportsTo="###@@@^^^";
	private String status="ACTIVE";
	private String title="";
	private String token="e5d69d66-4720-4963-928e-4b0df52b30ad";
	private String tokenExpiry="2019-01-31 10:32:02";
	private String username="###@@@^^^";

	AdminUsers adminUsersJson = AdminUsers.builder().code(code)
			.department(department).email(email).firstName(firstName).gender(gender).
					id(id).language(language).lastName(lastName).password(password).
					passwordLastUpdate(passwordLastUpdate).phone(phone).position(position).
			reportsTo(reportsTo).status(status).title(title).token(token).tokenExpiry(tokenExpiry).username(username).
					build();

	@Test
	public void postAdminUser() throws JsonProcessingException {

		ValidatableResponse vr =
				given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
						.contentType(ContentType.JSON).body(mapper.writeValueAsString(adminUsersJson)).when()
						.post(CredentialsUtils.IDENTITY + Endpoints.middleURLUser).then()
						.statusCode(201);

		String location = ((ValidatableResponseImpl) vr).originalResponse().header("Location");

		String response = given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(Factory.adminUsers)).when()
				.get(location)
				.then()
				.contentType(ContentType.JSON).extract().response().asString();

		AdminUsers adminUsers = JsonHelper.readValue(response, AdminUsers.class);
		assertEquals(Factory.adminUsers.getCode(), adminUsers.getCode(), "Codes are equals");
		assertEquals(Factory.adminUsers.getDepartment(), adminUsers.getDepartment(), "Departments are equals");
		assertEquals(Factory.adminUsers.getEmail(), adminUsers.getEmail(), "Emails are equals");
		assertEquals(Factory.adminUsers.getFirstName(), adminUsers.getFirstName(), "First names are equals");
		assertEquals(Factory.adminUsers.getGender(), adminUsers.getGender(), "Genders are equals");
		assertEquals(Factory.adminUsers.getId(), adminUsers.getId(), "Ids are equals");
		assertEquals(Factory.adminUsers.getLanguage(), adminUsers.getLanguage(), "Languages are equals");
		assertEquals(Factory.adminUsers.getLastName(), adminUsers.getLastName(), "Last names are equals");
	    assertEquals(Factory.adminUsers.getPassword(), adminUsers.getPassword(), "Passwords are equals");
		assertEquals(Factory.adminUsers.getPasswordLastUpdate(), adminUsers.getPasswordLastUpdate(), "Passwords Last Update are equals");
		assertEquals(Factory.adminUsers.getPhone(), adminUsers.getPhone(), "Phones are equals");
		assertEquals(Factory.adminUsers.getPosition(), adminUsers.getPosition(), "Positions are equals");
		assertEquals(Factory.adminUsers.getReportsTo(), adminUsers.getReportsTo(), "Reports to are equals");
		assertEquals(Factory.adminUsers.getStatus(), adminUsers.getStatus(), "Statuses are equals");
		assertEquals(Factory.adminUsers.getTitle(), adminUsers.getTitle(), "Titles are equals");
		assertEquals(Factory.adminUsers.getToken(), adminUsers.getToken(), "Tokens equals");
		assertEquals(Factory.adminUsers.getTokenExpiry(), adminUsers.getTokenExpiry(), "Tokens expiry are equals");
		assertEquals(Factory.adminUsers.getUsername(), adminUsers.getUsername(), "Usernames are equals");

		Factory.adminUsers.setCode(adminUsers.getCode());
		Factory.adminUsers.setId(adminUsers.getId());
		Factory.adminUsers.setDepartment(adminUsers.getDepartment());
		Factory.adminUsers.setEmail(adminUsers.getEmail());
		Factory.adminUsers.setId(adminUsers.getId());
		Factory.adminUsers.setPhone(adminUsers.getPhone());
		Factory.adminUsers.setStatus(adminUsers.getStatus());
		Factory.adminUsers.setUsername(adminUsers.getUsername());
	}

	@Test
	public void postWrongAdminUser() throws JsonProcessingException {

		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
					.contentType(ContentType.JSON).body(mapper.writeValueAsString(adminUsersJson)).when()
					.post(CredentialsUtils.IDENTITY + Endpoints.middleURLUser).then()
					.statusCode(404);
	}

	@Test
	public void posAdminUserWithoutAuthentication() throws JsonProcessingException {
		given()
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(adminUsersJson)).when()
				.post(CredentialsUtils.IDENTITY + Endpoints.middleURLUser).then()
				.statusCode(401);
	}
}
