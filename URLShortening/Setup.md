# Setup Instructions for URL Shortener Project

This document provides the steps to set up and run the URL Shortener project locally.

## Prerequisites
- Java 17 or later
- Maven
- MySQL

## Clone the Repository

``git clone https://github.com/username/url-shortener.git``

## Navigate to the Project Directory

``cd url-shortener``

## Set Up the Database

- Make sure you have MySQL installed and running.

- Create a new MySQL database:

``CREATE DATABASE url_shortener_db``

- Update the application.properties (or application.yml) file with your MySQL credentials if needed:

``spring.datasource.url=jdbc:mysql://localhost:3306/url_shortener_db
spring.datasource.username=yourUsername
spring.datasource.password=yourPassword``

 ## Run the Application

- Spring Boot handles dependencies through Maven, so no need to install them manually.

- You can directly run the Spring Boot application:

``./mvnw spring-boot:run``

- Alternatively, you can package the application as a JAR file and run it:

``./mvnw package
java -jar target/url-shortener-0.0.1-SNAPSHOT.jar``

## Access the Application

- Once the application is running, open a browser or use a tool like Postman and access:

``http://localhost:8080``

## API Testing (Optional)

- To shorten a URL, send a POST request to the 
``http://localhost:8080/generate``


## Additional Notes:

- Ensure Java 17 (or the required JDK version) is installed.

- Spring Boot automatically handles the required dependencies using Maven.

- MySQL must be installed and running locally, or update the application.properties to connect to a remote database.
