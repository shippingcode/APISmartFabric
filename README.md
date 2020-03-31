# rest-framework
A simple REST testing framework

This is an API Automation Framework. The structure is simple and easy to use.
Consists from 3 main packages: 
src/main/java
src/test/java 
src/test/resources

src/main/java has all the Enums with resources used in the tests, jsonBuilders for the APIs & utils with Constants & Endpoints classes.
src/test/java has all the TestNG tests, each API is structured into separated package as: identity, catalogs, documents, gui & engine & also the Factory class with all the builders for the API used to retrieve response body for post methods.
src/test/resources has all the .xml files for all the TestNGs.

.pom file is the file that will be colected by Bamboo job and has all the dependecies used in the framework and also the /resources package that will ran all the tests that are found under src/test/resources.
Syntax used is Java Rest Assured. The scope of all tests is to capture as many as response codes possible for different types of test cases, mostly concentrated on negative testing, some examples: 401 unathorized, 404 resource not found, 400 bad request,
409 conflict reource (when the resource is already created) & positive testing like 201 resource created, 200 sucess for get methods.
Each test has as name conevtion the name from swagger of the endpoint, for example if the name of the endpoint form swagger is : "POST/documents/templates" then under package post a class name will be "Documents_TemplatesTest[noOfTest].java"
