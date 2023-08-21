# Library Management System

This repository contains code of Library Management System.
This system facilitates the management of a library's operations, including borrowing and returning books, tracking book titles, and managing user accounts.

**ATTENTION**
This application is not intended for commercial use. It primarily serves as a programming exercise.

## Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
- [API Endpoints](#api-endpoints)

## Features

- View and manage book borrowing operations.
- Manage book titles, authors, and publication years.
- Create and manage user accounts.
- Change the status of book copies (e.g., borrowed, in stock).
- Check available book copies for specific titles.
- Borrow and return books by users.

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- Spring Web (for building RESTful APIs)
- MySQL (as the database management system)
- Lombok (for generating boilerplate code)
- JSON (for data exchange)
- JPA (Java Persistence API) for ORM (Object-Relational Mapping)
- Apache HttpClient (for making HTTP requests)
- Gradle

## Getting Started

- Clone the repository to your local machine.
- Open the project in your preferred Java development environment.
- Make sure you have Java installed on your machine.
- Build and run the application.
- To interact with the application you have to use special application (like Postman) to call requests on "http://localhost:8080"

## API Endpoints
The application provides the following API endpoints, accessible on port 8080 after startup:

### Library Controller
- POST /library/borrow/{copyId}/{userId} - Borrow a book copy by providing the copy Id and user Id.
- PUT /library/return/{copyId} - Return a borrowed book copy and update its status.
- GET /library/stock/{titleId} - Check available copies of a book title.
- PUT /library/status/{copyId}/{status} - Change the status of a book copy.

### Title Controller
- GET /titles - Retrieve a list of all book titles.
- GET /titles/{id} - Retrieve details of a specific book title.
- POST /titles - Create a new book title.
- PUT /titles/updateTitle/{id} - Update details of a book title.
- DELETE /titles/deleteTitle/{id} - Delete a book title.

### User Controller
- GET /users - Retrieve a list of all user accounts.
- GET /users/{id} - Retrieve details of a specific user account.
- POST /users - Create a new user account.
- PUT /users/updateUser/{id} - Update details of a user account.
- DELETE /users/deleteUser/{id} - Delete a user account.

### Copy Controller
- GET /copies/{id} - Retrieve details of a specific copy by its ID.
- GET /copies - Retrieve a list of all copies stored in the library.
- POST /copies - Create a new copy by providing the copy details in the request body.
- PUT /copies/updateCopy/{id} - Update details of a specific copy by its ID. Provide the updated copy details in the request body.
- DELETE /copies/deleteCopy/{id} - Delete a specific copy by its ID.