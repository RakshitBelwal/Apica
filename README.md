How to Run and Test the Entire System
Prerequisites
1. Docker
2. Docker Compose

Steps to Run the System
Clone the repositories:

Build Docker images:

Navigate to the root directories of the user-service and journal-service projects and run the following command to build the Docker images:

docker build -t userservice:latest.
docker build -t journalservice:latest.


Run Docker Compose:

Navigate to the directory containing the docker-compose.yml file and run the following command:

docker-compose up
This command will start Zookeeper, Kafka, User Service, and Journal Service containers.

Verify the services:

User Service: Open your browser or use a tool like Postman to test the User Service API endpoints at http://localhost:8081/api/users.
Journal Service: Open your browser or use a tool like Postman to test the Journal Service API endpoints at http://localhost:8082/api/journals.


Documenting REST API Endpoints

User Service Endpoints

Method	Endpoint	Description
POST	  /api/users	Register a new user
GET	    /api/users/{id}	Retrieve user details by ID
GET	    /api/users/ Retrieve user details by ID
DELETE	/api/users/{id}	Delete user


Journal Service Endpoints
GET	    /api/journals	Retrieve all journals





Running and Testing the APIs

1. Register a new user:

POST /api/users 
Content-Type: application/json

{
    "username": "testuser",
    "password": "password",
    "email": "testuser@example.com"
}

2. Retrieve user details:
   GET /api/users/

3. Update user details:
PUT /api/users/{id}
Content-Type: application/json

{
    "username": "updateduser",
    "email": "updateduser@example.com"
}

4. Delete a user:
DELETE /api/users/{id}

5. Retrieve all journals:
   GET /api/journals



   Stopping the System
To stop the entire system, run:
docker-compose down
