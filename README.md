# Books & Authors — Spring Boot Management Application

A Spring Boot web application for managing **Books** and **Authors** with full CRUD functionality, JSP views, and an H2 in-memory database.

## Table of Contents

- [Features](#features)
- [Tech Stack](#tech-stack)
- [Project Structure](#project-structure)
- [Entity Relationship](#entity-relationship)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Running the Application](#running-the-application)
- [Endpoints](#endpoints)
- [Database Console](#database-console)
- [Running Tests](#running-tests)

---

## Features

- List all books along with their author details
- Add a new book and assign it to an existing author
- Edit an existing book's details
- Delete a book
- Pre-populated sample data (10 authors and 10 books) on startup

## Tech Stack

| Layer      | Technology                          |
|------------|-------------------------------------|
| Framework  | Spring Boot 3.2.5                   |
| Language   | Java 17                             |
| Persistence| Spring Data JPA / Hibernate         |
| Database   | H2 (in-memory)                      |
| View       | JSP + JSTL                          |
| Build      | Maven                               |

## Project Structure

```
src/
├── main/
│   ├── java/com/example/bookmgmt/
│   │   ├── BookManagementApplication.java   # Application entry point
│   │   ├── controller/
│   │   │   ├── BookController.java          # Handles /books routes
│   │   │   └── HomeController.java          # Handles root redirect
│   │   ├── model/
│   │   │   ├── Author.java                  # Author JPA entity
│   │   │   └── Book.java                    # Book JPA entity
│   │   ├── repository/
│   │   │   ├── AuthorRepository.java
│   │   │   └── BookRepository.java
│   │   └── service/
│   │       ├── BookService.java             # Business logic
│   │       └── DataInitializer.java         # Sample data loader
│   ├── resources/
│   │   └── application.properties
│   └── webapp/WEB-INF/jsp/
│       ├── book-list.jsp                    # Lists all books
│       └── book-form.jsp                    # Add / Edit form
└── test/
    └── java/com/example/bookmgmt/
        ├── repository/BookRepositoryTest.java
        └── service/BookServiceTest.java
```

## Entity Relationship

```
Author (1) ──────< Book (Many)
```

**Author**
- `id` – Primary key (auto-generated)
- `name` – Author's name (required)
- `nationality` – Author's nationality

**Book**
- `id` – Primary key (auto-generated)
- `title` – Book title (required)
- `isbn` – ISBN number
- `price` – Price
- `author` – Many-to-one reference to `Author` (required)

## Getting Started

### Prerequisites

- Java 17+
- Maven 3.6+

### Running the Application

```bash
# Clone the repository
git clone https://github.com/SayedZahur786/Books-_and_Authors.git
cd Books-_and_Authors

# Build and run
mvn spring-boot:run
```

The application starts on **http://localhost:8080**.

## Endpoints

| Method | URL                  | Description            |
|--------|----------------------|------------------------|
| GET    | `/`                  | Redirects to `/books`  |
| GET    | `/books`             | List all books         |
| GET    | `/books/add`         | Show add-book form     |
| POST   | `/books/save`        | Save (create/update)   |
| GET    | `/books/edit/{id}`   | Show edit form for book|
| GET    | `/books/delete/{id}` | Delete a book          |

## Database Console

The H2 console is available at **http://localhost:8080/h2-console** while the app is running.

| Setting  | Value               |
|----------|---------------------|
| JDBC URL | `jdbc:h2:mem:bookdb`|
| Username | `sa`                |
| Password | *(leave blank)*     |

## Running Tests

```bash
mvn test
```

Tests cover the repository layer (`BookRepositoryTest`) and the service layer (`BookServiceTest`).
