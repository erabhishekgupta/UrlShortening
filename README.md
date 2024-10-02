
# Url Shortening 


A URL shortening service takes a long URL (Uniform Resource Locator) and converts it into a much shorter version while still directing users to the original destination. This is especially useful for sharing links on platforms with character limits or for improving the aesthetics and readability of a link.


## Acknowledgements

 I would like to express my sincere gratitude to everyone who contributed to the successful completion of this URL shortening project.

- Open-Source Libraries: I would like to thank the developers and maintainers of the various open-source libraries used in this project, including:

- Spring Boot: For providing a robust and flexible framework for building Java applications.
- Vite: For a fast and modern frontend build tool that made the development process smooth.
- React: For being a powerful library to build interactive user interfaces.
- Axios: For enabling easy communication with the backend via HTTP requests.
Platform Providers:

- Railway.app: For providing a simple and efficient platform to deploy the backend services.
- Render.com: For offering a smooth deployment process for the frontend.
- Guava (com.google.guava): Guava is a set of core libraries developed by Google for Java. It provides a wide range of utilities that 
 enhance Java's standard library. For Hashing the orginal link
- Apache Commons (org.apache.commons): Apache Commons is a collection of reusable Java components developed by the Apache Software Foundation. It includes a wide variety of libraries that cater to different aspects of Java development.

Community:

-  A special thank you to the online developer communities, forums, and resources such as Stack Overflow and GitHub Discussions for their insightful help and troubleshooting tips.

## Installation

1. Clone the Repository

``git clone https://github.com/username/url-shortener.git``

2. Navigate to the Project Directory

``cd url-shortener``

3. Set Up the Database

- Make sure you have MySQL installed and running.

- Create a new MySQL database:

``CREATE DATABASE url_shortener_db``

- Update the application.properties (or application.yml) file with your MySQL credentials if needed:

``spring.datasource.url=jdbc:mysql://localhost:3306/url_shortener_db
spring.datasource.username=yourUsername
spring.datasource.password=yourPassword``

4. Run the Application

- Spring Boot handles dependencies through Maven, so no need to install them manually.

- You can directly run the Spring Boot application:

``./mvnw spring-boot:run``

- Alternatively, you can package the application as a JAR file and run it:

``./mvnw package
java -jar target/url-shortener-0.0.1-SNAPSHOT.jar``

5. Access the Application

- Once the application is running, open a browser or use a tool like Postman and access:

``http://localhost:8080``

6. API Testing (Optional)

- To shorten a URL, send a POST request to the 
``http://localhost:8080/generate``


7. Additional Notes:

- Ensure Java 17 (or the required JDK version) is installed.

- Spring Boot automatically handles the required dependencies using Maven.

- MySQL must be installed and running locally, or update the application.properties to connect to a remote database.






## Deployment

The URL Shortener project is deployed using Railway.app, a cloud platform that simplifies deployment by automatically fetching the code from GitHub and providing an easy way to configure environment variables.

Steps to Deploy on Railway.app

1. Connect GitHub Repository

- The project is connected to Railway.app by linking the GitHub repository directly.

- After logging into Railway.app, you can select the repository that hosts your project and set it up for deployment.

2. Environment Variables

- Railway.app allows you to easily manage environment variables, which are required to configure your database and other sensitive information.

->The following environment variables were created on Railway.app:

- DB_URL: The URL to the MySQL database (e.g., jdbc:mysql://localhost:3306/url_shortener_db)

- DB_USERNAME: The MySQL database username
- DB_PASSWORD: The MySQL database password

- Any other required variables can be added similarly.

3. Automatic Build and Deployment

- Once connected to the GitHub repository, Railway.app automatically pulls the latest code from the repository on every push and builds the project.

- The platform handles the deployment and runs the Spring Boot application in a cloud environment, making the app accessible at a public URL.

4. Accessing the Deployed Application

- After successful deployment, the application is live and accessible at the Railway.app-provided URL, https://urlshortening-production.up.railway.app/generate

## Roadmap

The following are planned features and improvements for the URL Shortener project:
- Custom Short URLs: Allow users to create custom shortened URLs (e.g., xyzdomain.com/aabbsdc12).
- Link Analytics: Provide detailed analytics for shortened URLs, including:
    Number of clicks,
    Click trends over the time
- Expiration Feature: Add the ability to set expiration dates for shortened URLs (either based on time or number of clicks).
- Clear Section: You can clear the input text with that button
- Copy To Clopboard: Function added to copy the shorten url very easily.


## Screenshots
- This is the landing page -
![Screenshot (448)](https://github.com/user-attachments/assets/455ba2a1-18bf-4ee0-8577-a5e72068c73d)

- Copy any long url to shorten 
![Screenshot (449)](https://github.com/user-attachments/assets/ea8b8402-a4a0-46c3-ad95-a7e72ec1f22d)

- On clicking `get your link` your link will be shorten and valid upto 20 clicks 
![Screenshot (450)](https://github.com/user-attachments/assets/3efc0f14-f4fa-4b12-85b2-c2266af88e55)

- Added a feature where you can directly copy the link to your clipboard 
![Screenshot (451)](https://github.com/user-attachments/assets/240ca5b5-488c-407b-afde-9cbcc458f6b9)
## Tech Stack

The URL Shortener project is built using the following technologies:

- Backend Framework:

**Spring Boot:** A Java-based framework used to create stand-alone, production-ready applications with minimal configuration.
Programming Language:

**Java:** The primary language used for backend development.

- Database:

**MySQL:** A relational database management system used to store the original and shortened URLs.

- Build Tool:

**Maven:** A dependency management and build automation tool for Java projects.

- Testing Framework:

**JUnit:** A testing framework used for writing and running tests in Java.


- API Documentation:

**Swagger:** A tool used to generate interactive API documentation for the RESTful endpoints.

- Deployment Platform:

**Railway.app:** A cloud platform used for deploying the application. i.e. where i delployed the backend part
**Netlify:** A cloud platform for deploying the application i.e. where i delpoyed the frontend part




- Frontend Framework:
**React:** A JavaScript library for building user interfaces, allowing for a responsive and dynamic user experience.

- Styling:
**CSS:** Used for styling the application and ensuring a good layout.

**Bootstrap:** A front-end framework for developing responsive and mobile-first websites (if used).


- Package Manager:
**npm:** A package manager for JavaScript used to install libraries and manage project dependencies.

- Development Tools:

**Postman:** A collaboration platform for API development that is used for testing and documenting APIs.

- Version Control:
**Git:** A distributed version control system used to manage the source code.
**GitHub:** A platform for hosting and collaborating on Git repositories.


## Live Link 
- Providing you the live link for the project
    
     https://shortly-longurl.netlify.app/

## Badges

![Java](https://img.shields.io/badge/Java-17-blue)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-2.6.3-green)
![MySQL](https://img.shields.io/badge/MySQL-8.0-blue)
![React](https://img.shields.io/badge/React-18.0.0-blue)
