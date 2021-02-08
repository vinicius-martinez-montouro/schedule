# Project Schedule

This API was used to manager schedule of users, where the following technologies were used:

 - Java 11
 - Spring boot
 - Database MongoDB
 - Lombook
 - Maven
 - JPA
 - Data mongodb

# Files

Backend: The whole part of the backend is located in the following directory:
schedule

Docker: Docker compose files are located in the following directory:
schedule/docker
	
UML: This project's UML is in the directory:
files/UML	
## Installation roadmap

>Necessary tools:
- Maven 3.6.2
- JDK 11
- Docker
- Eclipse ou Intelij
- Plugin Lombok and Docker
>Generate project package
-Inside the folder schedule run the command: mvn clean package

>Upload application
>mvnw spring-boot:run
-Inside the folder schedule execute the command: Test if the API has gone up through the 
URL http://localhost:80802/ifsp-prss6/manager-schedule/v1

## Docker

>Docker Compose:
-The docker compose is located in the following schedule / docker directory. This is responsible for uploading the application and the database.
The exposed ports are for the API https://localhost:8082 and Data Base https://localhost:27017

## Up Application without environment
-Run: To upload the account with the images, just type at the command prompt inside the folder schedule/docker:
	**`docker-compose up -d --build`**

## Swagger
-The project documentation can be accessed through the 
URL http://localhost:8082/swagger-ui.html