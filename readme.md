SESAR XML to EarthChem Db loader

This repository contains code to enable loading sample descriptions into the EarthChem ODM2 database from SESAR XML.  
The SESAR XML v2 schema is used, and data are loaded into the 2016 version of EarthChem ODM2 relational database

# Requirements
* Java SE 7, language, http://www.oracle.com/technetwork/java/javase/downloads/java-archive-downloads-javase7-521261.html 
* Jersey 2.25, libraries for web services, https://jersey.java.net
* PostgreSQL including postgresql-9.2-1004.jdbc4.jar, database with ODM2 schema, https://www.postgresql.org/ 
* Eclipse 4.5.0, an integrated development environment (IDE), https://eclipse.org/ide/
* Apache Tomcat v8.0, server for web services, http://tomcat.apache.org/

# Installation
* Install Java at C:\Program Files\Java\jdk1.7.0-9;
* Install Eclipse at C:\eclipse, right click New at Eclipse, click Dynamic Web Project, and enter project name to create SesarToEarthChemWS project;
* Download Jersey jar files and move these file to C:\...\SesarToEarthChemWS\WebContent\WEB-INF\lib;
* Download postgresql-9.2-1004.jdbc4.jar from https://jdbc.postgresql.org/download.html and move this file to  C:\...\SesarToEarthChemWS\WebContent\WEB-INF\lib; 
* On Eclipse, right click project name and select properties, click Java Build Path, click libraries, click Add JARS, click project name -> WebContent-> WEB-INF -> lib, select all jar files and click OK to add jar files;
* Install Apache Tomcat at C:\apache-tomcat-8.0.39; 
* Add the following contents to C:\apache-tomcat-8.0.39\conf\web.xml:
```xml
<resource-ref>
 <description>postgreSQL Datasource example</description>
 <res-ref-name>jdbc/postgres</res-ref-name>
 <res-type>javax.sql.DataSource</res-type>
 <res-auth>Container</res-auth>
</resource-ref>
```
* Add the following contents to C:\apache-tomcat-8.0.39\conf\context.xml:
```xml
<Context>
<Resource name="jdbc/postgres" auth="Container"
          type="javax.sql.DataSource" driverClassName="org.postgresql.Driver"
          url="jdbc:postgresql:xxxx"
          username="xxx" password="xxx" maxTotal="0" maxIdle="10"
maxWaitMillis="-1"/>
</Context>"
```

# Deployment
* Right click project name, "SesarToEarthChemWS", at Eclipse and select "Export";
* Click "Web" folder, select "WAR file" and then click "Next >";
* Click "Browse..." to find location of "\apache-tomcat-8.0.39\webapps" and enter file "sesarec" for war file and click "Save";
* Finally, click "Finish" at "Export" page to finish deployment.

# Use application
* URL: hostname/sesarec/ssec/samples;
* html form method: post;
* content-type: application/xml;
* accept-language: text/html;
* if request is correct, sever returns "Status: 200 OK" with a statement "The data have been saved to database!";  
* if XML Syntax error occurs, sever returns "Status: 400 Bad Request"; if url error occurs, sever returns "Status: 404 Not Found"; if other errors occur, server returns error messages.

# What's here:

## .settings
This contains – or at least should contain – vital information needed to successfully build your project inside Eclipse, such as the character encoding used for source code, Java compiler settings, and much more.

## WebContent
This folder is the mandatory location of all Web resources.

## WebContent/META-INF/
This folder is not been used.

## WebContent/WEB-INF/
This contains lib folder and web.xml.

## WebContent/WEB-INF/lib
This contains jar files, which contain libraries required for this project.

## WebContent/WEB-INF/web.xml
This is the deployment descriptor for a Servlet-based Java web application.

## .gitignore
A file which Git has been explicitly told to ignore. This is where secret information (e.g. DB usernames and logins) used by a local installation should be kept. Double check that your 'secrets' files are not being synced to the online Github repo.

## .classpath
The classpath files contains src and target entries that correspond with folders in the project.

## .project
This is the Eclipse project description file.

## sesar_to_ec_test.xml
This is xml file used for test.

## src/com/sesar
This contains all source code files.

## src/com/sesar/dao/
This contains code files to receive data from xml and to access data from database;

## src/com/sesar/dao/ActionDao.java
Retrieve data from XML and create updating queries for saving to person, affiliation, action, method, feature_action, equipment, equipment_type, equipment_action and action_by of database.

## src/com/sesar/dao/SamplingFeatureDao.java
Retrieve data from XML and create updating queries for saving to sampling_feature, specimen, sampling_feature_external_identifier, related_feature, taxonomic_classifier, sampling_feature_taxonomic_classifier, annotation and sampling_feature_annotation of database.

## src/com/sesar/util/
This contains programing utility files.

## src/com/sesar/util/DatabaseUtil.java
This file is used for making database connection, for retrieving data from database, and for saving data to database by JDBC. 

## src/com/sesar/model/
This contains Java bean used in Jersey.

## src/com/sesar/model/Classification.java
Java bean used in Jersey for XML classification element.

## src/com/sesar/model/ExternalUrl.java
Java bean used in Jersey for xml external_url element.

## src/com/sesar/model/ExternalUrls.java
Java bean used in Jersey for xml external_urls element.

## src/com/sesar/model/Metamorphic.java
Java bean used in Jersey for xml metamorphic element.

## src/com/sesar/model/Rock.java
Java bean used in Jersey for xml rock element.

## src/com/sesar/model/Sample.java
Java bean used in Jersey for xml sample element.

## src/com/sesar/model/SampleOtherNames.java
Java bean used in Jersey for xml sample_other_names element.

## src/com/sesar/model/Samples.java
Java bean used in xml Jersey for samples element.

## src/com/sesar/model/package-info.java
This class is used for prefix namespace in the package level.

## src/com/sesar/ws/
This contains web service file.

## src/com/sesar/ws/SesarEcService.java
This is Restful web service file.
