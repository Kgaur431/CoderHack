# CoderHack API

Welcome to the CoderHack API, a backend application designed to manage users, their scores, and badges while maintaining seamless integration with MongoDB. 
This project is built using Spring Boot, focusing on clean code principles, scalability, and robust validation.

## Features

- **User Registration**
  Users can register with a unique username. The system ensures:
    - A generated unique ID.
    - An initial score of 0.
    - An empty list of badges.
  
- **Score Management**
  - Update user scores while ensuring validation (scores must be between 0 and 100).

- **Badge Assignment**
  - Assign badges to users based on their performance.

- **User Retrieval**
  - Fetch user details or list all users sorted by their scores in descending order.

- **User Deletion**
  - Remove users from the system with a simple API call.


## Validation Rules
  -Registration:
     -Username is mandatory and cannot be empty.
    -Score is always initialized to 0 by default.
-Score Update:
    -Score must be between 0 and 100.

## Tech Stack
 - Java 17
 - Spring Boot
 - MongoDB
 - Lombok
 - Jakarta Validation API


## API Endpoints

| Method   | Endpoint              | Description                          |
|----------|-----------------------|--------------------------------------|
| `POST`   | `/api/users/register` | Register a new user                  |
| `PUT`    | `/api/users/{id}/score`| Update a user's score                |
| `GET`    | `/api/users`          | Retrieve all users (sorted by score) |
| `GET`    | `/api/users/{id}`     | Fetch details of a specific user     |
| `DELETE` | `/api/users/{id}`     | Delete a user                        |



## Project Structure
* src/main/java/com/example/coderhack/
* ├── controller/        # API Controllers
* ├── dto/               # Data Transfer Objects
* ├── entity/            # Entity Classes (User, etc.)
* ├── repository/        # MongoDB Repositories
* ├── service/           # Business Logic
* ├── utils/            # Entity-DTO Mappers
* └── exception/         # Custom Exception Handling
* 