# Assessment

									   =======================
										Framework Architecture:
									   =======================

Project - Maven
Framework - Page Object Model[POM] using Page Factory in Selenium.
Language - Java
WebDriver - 3.141.59 version
Browsers - chrome
Test Executions - JUnit (or) maven test
Screenshots - {rootfolder}\test-output\Screenshots\
Logger - Log4j - {rootfolder}/target/Log.log
Reports - Cucumber Reports - {rootfolder}\target\cucumber-reports\index.html
Editor - Eclipse

=================
Folder Structure
=================
src/main/java - Individual pages are classified in to their corresponding packages and written inside java file
				Framework related codes

src/main/resources - contains config folder related to Chromedriver Execution File and log4j.xml file

src/test/java -  Cucumber Runner and Step Definition Files

src/test/resources - Feature Files

target/Log.log - contains test execution log informations

Screenshots - contains test execution passed/failed screenshots

pom.xml - contains dependencies,plugins,etc

===========
Executions:
===========
=======
JUnit
=======
1) For APITesting Feature:
   Right click on src/test/resources/com.runners/APITestRunner and Run As-> JUnit Test
 
2) For UI - Amazon TestFeature:
   Right click on src/test/resources/com.runners/AmazonRunnerTest and Run As-> JUnit Test

#