package com.agys.catalogs.modelController.post;

import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.enums.Environments;
import com.agys.jsonBuilder.DataModelMapping;
import com.agys.model.Factory;
import com.agys.utils.CredentialsUtils;
import com.agys.utils.JsonHelper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.internal.ValidatableResponseImpl;
import com.jayway.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import lombok.extern.slf4j.Slf4j;


import static com.agys.Constants.PRINCIPAL_HEADER_NAME;
import static com.jayway.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

@Slf4j

public class Catalog_Data_Model_MappingTest {
    private ObjectMapper mapper = new ObjectMapper();
    final String blockchainOnly = "true";
    final String genericModelTimestamp = "0";
    final String description = "this is something";
    final String idField = "4565467457567657";
    final String nameField = "ThisIsAName";
    final String typeField ="type";
    final String id = "45654674575676573543";
    final String name = "ThisIsAName1";
    final String removed ="yes";
    final String idModelClass = "45555";
    final String isBCReady = "true";
    final String isEmbeded ="true";
    final String isIndexable ="true";
    final String isList ="true";
    final String nameModelClass ="true";
    final String typeModelClass ="true";
    final String id1 ="345354";
    final String isBCReady1 ="true";
    final String name1 ="trusdfgdgdge";
    final String idModelCoreEntitioes= "34564";
    final String isBCReadyModelCoreEntitioes= "true";
    final String isEmbededModelCoreEntitioes= "true";
    final String isIndexableModelCoreEntitioes= "true";
    final String isListModelCoreEntitioes= "true";
    final String nameModelCoreEntitioes= "coreEntitie";
    final String typeModelCoreEntitioes= "typecoreEntity";
    final String id2= "45654654";
    final String isBCReady2= "true";
    final String name3= "name2";
    final String diagramFileId= "diagrameFiled";
    final String id4= "456547567";
    final String type4= "type4";
    final String id5= "457567";
    final String isBCReady4= "true";
    final String isEmbeded4= "true";
    final String isIndexable4= "true";
    final String isList4= "true";
    final String name5= "name 5";
    final String type5="type 5";
    final String id100="436456456";
    final String isBCReady5="true";
    final String name100="name 500";
    final String type100="type 5";
    final String pathlist="346";


    DataModelMapping dataModelMapping = DataModelMapping.builder().blockchainOnly(blockchainOnly)
            .genericModelTimestamp(genericModelTimestamp).description(description).
                    idField(idField).nameField(nameField).typeField(typeField).id(id).name(name).removed(removed).
                    idModelClass(idModelClass).isBCReady(isBCReady).isEmbeded(isEmbeded).isIndexable(isIndexable).
                    isList(isList).nameModelClass(nameModelClass).typeModelClass(typeModelClass).id1(id1).isBCReady1(isBCReady1).
                    name1(name1).idModelCoreEntitioes(idModelCoreEntitioes).isBCReadyModelCoreEntitioes(isBCReadyModelCoreEntitioes).
                    isEmbededModelCoreEntitioes(isEmbededModelCoreEntitioes).isIndexableModelCoreEntitioes(isIndexableModelCoreEntitioes).
                    isListModelCoreEntitioes(isListModelCoreEntitioes).nameModelCoreEntitioes(nameModelCoreEntitioes).
                    typeModelCoreEntitioes(typeModelCoreEntitioes).id2(id2).isBCReady2(isBCReady2).name3(name3).diagramFileId(diagramFileId).
                    id4(id4).type4(type4).id5(id5).isBCReady4(isBCReady4).isEmbeded4(isEmbeded4).isIndexable4(isIndexable4).isList4(isList4).
                    name5(name5).type5(type5).id100(id100).isBCReady5(isBCReady5).name100(name100).type100(type100).pathlist(pathlist).
                    build();

  @Test
    public void postCatalog_Data_Model_JsonPath() throws JsonProcessingException {

        ValidatableResponse vr = given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
                .contentType(ContentType.JSON).body(mapper.writeValueAsString(dataModelMapping)).when()
                .post(CredentialsUtils.CATALOGS + Endpoints.middleURLDataModelMapping).then()
                .statusCode(201);

        String location = ((ValidatableResponseImpl) vr).originalResponse().header("Location");

        String response = given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
                .contentType(ContentType.JSON).body(mapper.writeValueAsString(Factory.catalogContentExportJson)).when()
                .get(location)
                .then()
                .contentType(ContentType.JSON).extract().response().asString();

        DataModelMapping dataModelJsonPath = JsonHelper.readValue(response, DataModelMapping.class);
        assertEquals(Factory.dataModelMapping.getId(), dataModelJsonPath.getId(), "Ids are equals");
        assertEquals(Factory.dataModelMapping.getDescription(), dataModelJsonPath.getDescription(), "Descriptions are equals");
        assertEquals(Factory.dataModelMapping.getName(), dataModelJsonPath.getName(), "Names are equals");

        Factory.dataModelMapping.setId(dataModelJsonPath.getId());
        Factory.dataModelMapping.setName(dataModelJsonPath.getName());
    }

    @Test
    public void posCatalog_Data_Model_JsonPathNoAuthentication() throws JsonProcessingException {
         given()
                .contentType(ContentType.JSON).body(mapper.writeValueAsString(dataModelMapping)).when()
                .post(CredentialsUtils.CATALOGS + Endpoints.middleURLDataModelMapping).then()
                .statusCode(401);
   }
}

