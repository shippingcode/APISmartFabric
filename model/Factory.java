package com.agys.model;

import com.agys.jsonBuilder.*;
import com.agys.utils.JsonHelper;

import java.util.UUID;

public class Factory {
    public static final AdminTenants adminTenantsJson = AdminTenants.builder()
            .defaultUserEmail(UUID.randomUUID().toString() + "@agys.ch")
            .defaultUserPassword("testPasswd")
            .domain(("d." + UUID.randomUUID().toString()).replaceAll("[^a-zA-Z0-9]", ""))
            .name(UUID.randomUUID().toString())
            .status("ACTIVE").build();

    public static final DataCatalogsContentExportJson catalogContentExportJson = DataCatalogsContentExportJson.builder()
            .catalogs(UUID.randomUUID().toString())
            .processDefinitionId("508b2cf1-bc2b-4d4e-8d1a-d5f85c4e8177")
            .build();

    public static final DataCatalogsContentExportVersion catalogContentExportVersion = DataCatalogsContentExportVersion.builder()
            .catalogs(UUID.randomUUID().toString())
            .processDefinitionId("508b2cf1-bc2b-4d4e-8d1a-d5f85c4e8177")
            .versionId("508b2cf1-bc2b-4d4e-8d1a-d5f85c4e8177")
            .build();


    public static final DataCatalogsContentImportVersion catalogContentImportVersion = DataCatalogsContentImportVersion.builder()
            .overwriteExisting("false")
            .inactiveOther("false")
            .attachment("35345345")
            .catalogs("46456456")
            .processDefinitionId("508b2cf1-bc2b-4d4e-8d1a-d5f85c4e8177")
            .versionId("508b2cf1-bc2b-4d4e-8d1a-d5f85c4e8177")
           .build();

    public static final DataModelJsonPath dataModelJsonPath  = DataModelJsonPath.builder()
            .json("{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch�(test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
            .path("//users/downloads/something")
            .type("type")
            .build();



   public static final DataModelMapping dataModelMapping = DataModelMapping.builder().
           blockchainOnly("true")
            .genericModelTimestamp("0").
                   description("this is something").
                    idField("4565467457567657").
                   nameField("ThisIsAName").
                   typeField("type").
                   id("45654674575676573543").
                   name("ThisIsAName1").
                   removed("yes").
                    idModelClass("45555").
                   isBCReady("true").
                   isEmbeded("true").
                   isIndexable("true").
                    isList("true").
                   nameModelClass("true").
                   typeModelClass("true").
                   id1("345354").
                   isBCReady1("true").
                    name1("true").
                   idModelCoreEntitioes("true").
                   isBCReadyModelCoreEntitioes("true").
                    isEmbededModelCoreEntitioes("true").
                   isIndexableModelCoreEntitioes("true").
                    isListModelCoreEntitioes("true").
                   nameModelCoreEntitioes("true").
                    typeModelCoreEntitioes("true").id2("2353534").
                   isBCReady2("true").
                   name3("Name")
                   .diagramFileId("diagrameFiled")
                   .id4("34534345")
                   .type4("type4").
                   id5("3454345").
                   isBCReady4("true").
                   isEmbeded4("true").
                   isIndexable4("true").
                   isList4("true").
                    name5("name5").
                   type5("type45").id100("24535").
                   isBCReady5("true").name100("name55").
                   type100("type100").
                   pathlist("//users/downloads/something").
                    build();

    public static final DataModelDefinitionVersion dataModelDefVersion  = DataModelDefinitionVersion.builder()
            .diagram("swewrfwe")
            .fieldsId("wesr")
            .fieldsBCReady("swerw")
            .fieldsEmbeded("true")
            .fieldsIndexable("true")
            .fieldsList("true")
            .fieldName("name")
            .fieldType("type")
            .id("508b2cf1-as2b-4d4e-8d1a-h7f85c4e8177")
            .isBCReady("true")
            .name("name34w54")
            .type("type1")
             .build();

    public static final DataCatalogsContentVersion dataCatalogContentVersion  = DataCatalogsContentVersion.builder()
            .filters("swewrfwe")
            .options("wesr")
            .all_languages("en, fr, it")
            .ascending("true")
            .sort_by("type")
            .type("type545")
            .build();

    public static final DataCatalogsContentSaveVersion dataCatalogsContentSaveVersion  = DataCatalogsContentSaveVersion.builder()
            .active("true")
            .code("34566546546")
            .columns("1")
            .name("name222")
            .additionalProp1("prop1")
            .additionalProp2("prop2")
            .additionalProp3("prop3")
            .build();


    public static final DataCatalogsDefinitionVersion dataCatalogDefVersion  = DataCatalogsDefinitionVersion.builder()
            .description("this is a field description")
            .idFields("5666")
            .nameFields("nameFileds")
            .type("dfghf")
            .idDescription("508b2cf1-bc2b-4d4e-8d1a-d5f85c4e8177")
            .nameDescription("this is a description")
            .removed("yes")
            .build();

    public static final CatalogDataLoadDataInternal catalogDataLoadDataIntern  = CatalogDataLoadDataInternal.builder()
            .includeAttachmentData("true")
            .includeCatalogData("true")
            .processInstanceId("a36d58ac-be8f-4256-8b3c-90e1bc920c3d")
            .versionId("a36d58ac-be8f-4256-8b3c-90e1bc920c3d")
            .processDefinitionId("a36d58ac-be8f-4256-8b3c-90e1bc920c3d")
            .build();

    public static final CatalogDataLoadDataProcessInstanceMapping catalogDataLoadDataProcessInstanceMapp  = CatalogDataLoadDataProcessInstanceMapping.builder()
            .correctTypes("true")
            .mapping("true")
            .build();

    public static final CatalogDataLoadDataProcessInstance catalogLoadDataProcessInstance  = CatalogDataLoadDataProcessInstance.builder()
            .catalogData("true")
            .embeddedData("true")
            .build();

    public static final CatalogDataQueryProcessDefinition catalogDataQueryProcessDefinition  = CatalogDataQueryProcessDefinition.builder()
            .string("dehgierhglerjogrey")
            .build();

    public static final DocumentsExport documentsExport  = DocumentsExport.builder()
            .html("<!DOCTYPE html> <html> <head> <style id=\"page-size\">@page { size: A4 }</style></head> <body class=\"A4\" size=\"A4\" > <p>some text&nbsp;${CurrentTime}</p> </body> </html>")
            .build();

    public static final DocumentsGenerate documentsGenerate  = DocumentsGenerate.builder()
            .processInstanceId("5d62145f-8c4e-4b93-a037-8ae05ecae071")
             .documentTemplateId("9d8adcb5-050e-34d2-c54f-0de2ecc52ef4")
            .fileName("FileName")
            .savePath("//downloads")
            .build();


    public static final DocumentsTemplates documentsTemplates  = DocumentsTemplates.builder()
            .description("MyDescription")
            .h("o")
            .id("d7eaf674-d4dd-42bd-bbb4-a9eb2951926f")
            .isActive("true")
            .iteration("yes")
            .name("AutomatedDocumentsApi")
            .ownerId("d7eaf674-d4dd-42bd-bbb4-a9eb2951926f")
            .processDefinitionId("d7eaf674-d4dd-42bd-bbb4-a9eb2951926f")
            .template("346546$")
            .usedAttributes("24")
            .versionId("d7eaf674-d4dd-42bd-bbb4-a9eb2951926f")
            .build();

    public static final PortalRevisionInstall portalRevisionInstallation  = PortalRevisionInstall.builder()
            .active("true")
            .guiControlId("2453645734-76345735-2576348534")
            .installedGUIControlRevisionId("275634583456-683458536-8338753")
            .instanceId("7234wefjwes-82364382y45wefl-2634832")
            .toBeInstalledGUIControlRevisionId("swjfsdjfweruew-8347nfkdsn-sakfjsd-84375")
            .build();

    public static final GuiControlRevisionSave guiControlRevisionSave  = GuiControlRevisionSave.builder()
            .code("34535")
            .config("34543")
            .fileName("MyNameAila")
            .fileType("txt")
            .fileUUID("3456464565-346546456-456456")
            .guiControlId("481d57e6-27a2-423e-b309-709126b94263")
            .guiControlRevisionId("481d57e6-2ha2-423e-b309-709126b94265")
            .revision("10")
            .build();

    public static final PortalRevisionInstall portalRevisionInstall  = PortalRevisionInstall.builder()
            .active("true")
            .guiControlId("2453645734-76345735-2576348534")
            .installedGUIControlRevisionId("275634583456-683458536-8338753")
            .instanceId("7234wefjwes-82364382y45wefl-2634832")
            .toBeInstalledGUIControlRevisionId("swjfsdjfweruew-8347nfkdsn-sakfjsd-8437")
            .build();

    public static final AdminGroupsUsers adminGroupsUsers  = AdminGroupsUsers.builder()
            .groupId("e3f72af2-cc56-4353-abaf-54af2ba47936")
            .id("ee8e633a-f482-411f-96a5-e3ea154ed504")
            .isManager("true")
            .userId("d6259540-7004-40ac-b926-d972c4389dec")
            .build();



    public static final AdminGroups adminGroups  = AdminGroups.builder()
            .code("e3f72af2-cc56-4353-abaf-54af2ba47936")
            .id("ee8e633a-f482-411f-96a5-e3ea154ed504")
            .name("true")
            .tenantId("d6259540-7004-40ac-b926-d972c4389dec")
            .type("typer")
            .build();

    public static final AdminTenantsUsers adminTenantsUsers  = AdminTenantsUsers.builder()
            .id("3566")
            .status("ACTIVE")
            .tenantId("d634b20d-128e-4a57-97cf-7b7b01aeb901")
            .userId("cddef63d-5065-4b85-b685-0811c67b3b8a")
            .build();

    public static final AdminUsers adminUsers  = AdminUsers.builder()
            .code("3566")
            .department("IT")
            .email("d634b2@agys.ch")
            .firstName("jOHN")
            .gender("FEMALE")
            .id("00000000-0000-0000-0000-000000000001")
            .language("EN")
            .lastName("Pop")
            .password("aqwerwe5345")
            .passwordLastUpdate("")
            .phone("34543646")
            .position("ADMIN")
            .reportsTo("###@@@^^^")
            .status("ACTIVE")
            .title("")
            .token("e5d69d66-4720-4963-928e-4b0df52b30ad")
            .tokenExpiry("2019-01-31 10:32:02")
            .username("###@@@^^^")
            .build();

    public static final SystemLogin systemJson  = SystemLogin.builder()
            .tenantId("dacb0d16-6f03-4dff-a485-8d123376cac0")
            .userEmail("fabric_user@agys.ch")
            .userPassword("")
            .build();


    public static final Login login  = Login.builder()
            .tenantId("d634b20d-128e-4a57-97cf-7b7b01aeb901")
            .userEmail("fabric_user@agys.ch")
            .userPassword("passw0rd")
            .build();

      public static final TenantsUsers tenantsUsers  = TenantsUsers.builder()
            .code("34535")
            .email("UUID.randomUUID() + @testfabric.ch")
            .firstName("Aila")
            .lastName("Bogasieru")
            .gender("FEMALE")
            .language("English")
            .password("Pawdfg")
            .phone("325345436")
            .status("ACTIVE")
            .title("")
            .token("365456")
            .tokenExpiry("2019-01-11T13:31:19.825Z")
            .build();

    public static final TenantsGroupsPermission tenantsGroupsPermission  = TenantsGroupsPermission.builder()
            .groupId("da26c865-4ef0-4e33-87fe-54fdec501ec5")
            .id("45656786784")
            .permission("")
            .permissionType("DOCUMENT_TEMPLATE")
            .targetId("TYPE")
            .build();

    public static final TenantsGroups tenantsGroups  = TenantsGroups.builder()
            .code("67567")
            .id("45656786784")
            .name("John")
            .tenantId("27b8de05-a57c-4983-b07b-d0ef011a9f7c")
            .type("TYPE")
            .build();

    public static final EngineApiFlowApprovalSubmit engineApiFlowApprovalSubmitClass  = EngineApiFlowApprovalSubmit.builder()
            .actionCode("APPROVE")
            .comment("This is a comment")
            .taskId("08c2d3e5-5092-419a-bb37-f81d4df9ec95")
            .build();

    public static final EngineApiFlowGuiSubmit createEngineApiFlowGuiSubmit  = EngineApiFlowGuiSubmit.builder()
            .actionId("APPROVE")
            .comment("This is a comment")
            .taskId("08c2d3e5-5092-419a-bb37-f81d4df9ec95")
            .build();


    public static final EngineApiProcessDefinitionExternalStart engineApiProcessDefinitionExternalStartClass  = EngineApiProcessDefinitionExternalStart.builder()
            .additionalProp1("additionalProp1")
            .additionalProp2("additionalProp2")
            .additionalProp3("additionalProp3")
            .build();

    public static final EngineApiProcessDefinitionProcessInstancesActive engineApiProcessDefinitionProcessInstancesActiveClass  = EngineApiProcessDefinitionProcessInstancesActive.builder()
            .activityIds("3c3fb853-10be-0b99-5220-c7658ec06146")
            .additionalProp1("additionalProp1")
            .additionalProp2("additionalProp2")
            .additionalProp3("additionalProp3")
            .build();

    public static final EngineApiProcessDefinitionInsert engineApiProcessDefinitionInsertClass  = EngineApiProcessDefinitionInsert.builder()
            .image("3c3fb853-10be-0b99-5220-c7658ec06146")
            .processDefinitionModel("{\"id\":null,\"versionId\":\"e0216c9a-6f81-4d12-93f2-8b5f9bd2c2a6\",\"type\":null,\"active\":true,\"name\":\"apiProcessDefModel\",\"blockchainEnabled\":false,\"code\":\"4d66caed-6d5a-14b5-5e10-12be50811f5f\",\"description\":null,\"iteration\":0,\"blockchainType\":\"STANDARD\"}")
            .build();

    public static final EngineApiProcessInstanceBlockchainResult engineApiProcessInstanceBlockchainResultClass  = EngineApiProcessInstanceBlockchainResult.builder()
            .processInstanceId("730fff63-6ffe-42ba-b645-aa97b978be6f")
            .build();

    public static final EngineTaskFilterCreate engineTaskFilterCreateClass  = EngineTaskFilterCreate.builder()
            .id("e4fc3642-dba2-41aa-bf1a-56bd5ebc4b9d")
            .isDefault("true")
            .name("Task13.02.2019")
            .ownerId("3e420496-344b-4702-a11d-72e024774bac")
            .application("My Apps")
            .dueIn("2")
            .priorities("1")
            .taskName("Task13022019")
            .taskStatus("Completed")
            .build();

    public static final EngineTaskList engineTaskListClass  = EngineTaskList.builder()
            .activeTasks("e4fc3642-dba2-41aa-bf1a-56bd5ebc4b9d")
            .isTeam("true")
            .page("Task13.02.2019")
            .searchTerm("3e420496-344b-4702-a11d-72e024774bac")
            .size("My Apps")
            .sortDirection("2")
            .sortField("1")
            .dueIn("Task13022019")
            .priorities("Completed")
            .taskName("Name")
            .taskStatus("In progress")
            .build();


 public static final EngineVariablesInternal engineApiVariablesInternalClass  = EngineVariablesInternal.builder()
         .includeAttachmentData("true")
         .includeCatalogData("true")
         .processInstanceId("21eca05d-7581-4f22-86e7-a6d7a403ab30")
         .variables("a")
         .build();

 public static final PermissionsGroupPermissions permissionsGroupPermissionsClass  = PermissionsGroupPermissions.builder()
         .groupId("e3f72af2-cc56-4353-abaf-54af2ba47936")
         .id("ee8e633a-f482-411f-96a5-e3ea154ed504")
         .permission("Admin")
         .permissionType("type")
         .targetId("345345-325435-235345")
         .build();


 public static final PermissionsUserPermissions permissionsUserPermissionsClass  = PermissionsUserPermissions.builder()
         .userId("00000000-0000-0000-0000-000000000001")
         .permission("Admin")
         .permissionType("type")
         .targetId("345345-325435-235345")
         .build();

 public static final PublicResetPassword publicResetPasswordClass  = PublicResetPassword.builder()
         .userEmail("test@fabric.ch")
         .build();


 public static final PublicSetPassword publicSetPasswordClass  = PublicSetPassword.builder()
         .password("pass0rd")
         .repeatPassword("pass0rd")
         .token("35345-23534543-25434")
         .build();

 public static final TenantsGroup tenantsGroupClass  = TenantsGroup.builder()
         .code("e3f72af2-cc56-4353-abaf-54af2ba47936")
         .id("ee8e633a-f482-411f-96a5-e3ea154ed504")
         .name("Admin")
         .tenanatId("4575-567567-567567")
         .type("type")
         .groupId("00000000-0000-0000-0000-000000000001")
         .groupsPermisId("235345-23534534")
         .permission("w")
         .permissionType("type")
         .targetId("235345-345345345-34534543")
         .groupIdUserGroup("e1bf7e32-6846-473c-88df-0b59b4dd5870")
         .idUserGroup("e1bf7e32-6846-473c-88df-0b59b4dd5870")
         .isManager("true")
         .userId("00000000-0000-0000-0000-000000000001")
         .build();

 public static final TenantsUser tenantsUserClass  = TenantsUser.builder()
         .avatarPath("//downloads/pictures/")
         .code("ee8e633a-f482-411f-96a5-e3ea154ed504")
         .department("")
         .email("admin@fabric.ch")
         .firstName("John")
         .gender("FEMALE")
         .id("4525f6a0-f5a3-4120-9c20-933260bf37a1")
         .language("en")
         .lastName("Petterson")
         .password("passw0rd")
         .passwordLastUpdate("")
         .phone("349867546")
         .position("")
         .reportsTo("")
         .status("ACT")
         .title("Mr")
         .username("aila")
         .groupId("e3f72af2-cc56-4353-abaf-54af2ba47936")
         .userGroupId("ee8e633a-f482-411f-96a5-e3ea154ed504")
         .isManager("true")
         .userId("00000000-0000-0000-0000-000000000001")
         .userTenantPermissionId("")
         .permission("w")
         .permissionType("type")
         .targetId("943ce705-bda9-49cc-b499-6abf72422f2e")
         .userTenantId("930334d2-15fc-419c-9bfa-253ede554c33")
         .build();

 public static final TenantsUsersProfileNotification tenantsUsersProfileNotificationClass  = TenantsUsersProfileNotification.builder()
         .appNot("true")
         .diagramModifiedNot("true")
         .email("true")
         .inApp("true")
         .interfaceModifiedNot("true")
         .interfaceNot("true")
         .sms("true")
         .taskNot("true")
         .taskRoleNot("true")
         .userId("78c38837-8af3-438a-8560-0d73d8915ceb")
         .build();

}