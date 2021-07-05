# Assignment Automation Suite Information

### To run the Assignment Automation Suite from command line in the project folder

~~~~~~~~~~~~~~~~~~~~
mvn clean install
~~~~~~~~~~~~~~~~~~~~~

### To run Assignment Automation Suite from bat file in the project folder
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Double click on run.bat file present inside the project
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

### To run Assignment Automation Suite Parallel
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Steps are:
1. Go to config.properties present in resources and set runEnvironment = remote
2. Then go to testng.xml file and on suite level and this parallel = "classes"
3. Then go to start_docker.bat and double click it present inside the project
4. Then via mvn clean install
5. After successful execution, go to stop_docker.bat file and double click on it.
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
### To run Assignment Automation Suite via Jenkins
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Refer to the word file attach with the project
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

###Testing file description
-testng.xml= define the all tests in this project

### Packages Description
-Base:  Defining all the driver setups.
-pages: Defining all the pages actions and the respective object
-tests: Defining all the pages test and assertion
-Utilities: Defining all the utilities needed for the tests

###Tests.java files description

**BaseTest**: The main class which defines
-@BeforeMethod-to open the browser and get the name of the test
-@AfterMethod- to close the browser

**LoginTest**: includes test
-to verify the valid and invalid user details

**BusHireTest**: includes test
-to verify all ways available to hire.
-to check the buttons

**HomeTest**: includes test
-Search bus with both valid and invalid type of data.
-modify bus search details.
-to check the invite functionality.
-to validate the contact info.

**Explore siteMap test**: includes test
-To check bus search using operator.
-To register with bus service.

**career test**: includes test
- to apply in redBus via job partners.

**ReadBlog**: includes test
- to check the blog page at redbus.

**RedCare test**: includes test
-test to check the donate in redCare page.

**RPool test**: includes test
-to check video hyper link
- to offer a trip.

**searchBus operator test**: includes test
-to search bus via particular operator.

**TestHelp**: includes test
-to check the help functionality in redBus.

Other files description

-ReadData.java: used to take the elements from the excel for test
-ScreenShots.java: define function to take the screenshot
-swtichToPages.java: used to switch windows
-config.Properties-helps to provide essential links and data

