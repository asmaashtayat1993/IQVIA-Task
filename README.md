Objective 

This project consists of two microservices that handle user creation, retrieval, updates, and deletion using an H2 in-memory database. The services interact via OpenFeign for communication.
Overview

Microservices:

1.	User Service (user-service):
This service is responsible for creating and managing user data, storing it in an H2 in-memory database.
2.	User Management Service (user-management-service):
This service provides management functions, such as fetching, updating, and deleting user details. It communicates with the User Service using OpenFeign to handle these operations.

Database:

•	H2 In-Memory Database:

o	Accessible at:  (http://localhost:8080/h2-console)

o	Credentials are specified in the application.properties file of each microservice.
________________________________________

Microservices Details

1. User Service (user-service)
   
•	Port: 8080
•	Responsibilities:
o	Create and store user details.
o	Maintain the user data in an H2 database.
•	Endpoints:
o	POST /api/users/save- Create a new user.
o	GET /api/users/get/{id} - Retrieve a specific user by ID.
o	PUT /api/users/update/{id} - Update user details by ID.
o	DELETE /api/users/delete/{id} - Delete a user by ID.
o	GET /api/users/all - Get all users.
o	

3. User Management Service (user-management-service)
   
•	Port: 8081
•	Responsibilities:
o	Manage user information by calling the User Service.
o	Supports operations such as fetching, updating, and deleting user data.
o	Uses OpenFeign for seamless integration with the User Service.
•	Endpoints:
o	GET /api/managment/users/all - Retrieve all users (calls UserService).
o	GET /api/managment/users/get/{id} - Retrieve a user by ID (calls UserService).
o	PUT /api/managment/users/update/{id} - Update a user (calls UserService).
o	DELETE /api/managment/users/delete/{id} - Delete a user (calls UserService).

________________________________________

Running the Application

1.	Clone the repository.
2.	Start both microservices:
o	Run the User Service (user-service) on port 8080.
o	Run the User Management Service (user-management-service) on port 8081.
3.	Access the H2 database console at :   (http://localhost:8080/h2-console).
o	Credentials can be found in the application.properties file.

________________________________________

Technology Used :

•	Spring Boot - For building microservices.
•	Spring Cloud OpenFeign - For inter-service communication.
•	H2 Database - In-memory database for data persistence.
Usage
After starting both services,create user by user-service and  you can perform operations on users via the user-management-service, which will communicate with user-service to handle data. (refer to postman collection)


