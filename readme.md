SESAR XML to EarthChem Db loader

This repository contains code to enable loading sample descriptions into the EarthChem ODM2 database from SESAR XML.  
The SESAR XML v2 schema is used, and data are loaded into the 2016 version of EarthChem ODM2 relational database

# Requirements
* Java SE 7, language, http://www.oracle.com/technetwork/java/javase/downloads/java-archive-downloads-javase7-521261.html 
* Jersey 2.25, libraries for web services, https://jersey.java.net
* PostgreSQL, database, https://www.postgresql.org/ 
* Eclipse 4.5.0, an integrated development environment (IDE), https://eclipse.org/ide/
* Apache Tomcat v8.0, server for web services, http://tomcat.apache.org/

# What's here:

## .settings
This contains – or at least should contain – vital information needed to successfully build your project inside Eclipse, such as the character encoding used for source code, Java compiler settings, and much more.

## WebContent
This folder is the mandatory location of all Web resources, including HTML, JSP, graphic files, and so on.

## .gitignore
A file which Git has been explicitly told to ignore. This is where secret information (e.g. DB usernames and logins) used by a local installation should be kept. Double check that your 'secrets' files are not being synced to the online Github repo.
.
## .classpath
The classpath files contains src and target entries that correspond with folders in the project.

## .project
This is the Eclipse project description file.

##  src/com/sesar
This contains all source code files.

## SesarToEarthChemWS/src/com/sesar/dao/
This contains code files to access data from database;

## SesarToEarthChemWS/src/com/sesar/dao/ActionDao.java
Retrieve data from XML and create updating queries for saving to person, affiliation, action, method, feature_action, equipment, equipment_type, equipment_action and action_by

