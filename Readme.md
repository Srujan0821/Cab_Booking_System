# Cab Booking System

## 1. Introduction
The **Cab Booking System** is a backend application built using **Java (Spring Boot)** that enables users to:
- Book rides.
- Manage payments.
- Rate and provide feedback for drivers.

This system is designed to handle core functionalities such as user management, ride booking, payment processing, and driver ratings. It is built with a modular architecture to ensure scalability and maintainability.

---

## 2. Features
- **User Management**: Register and manage users.
- **Ride Booking**: Book rides with available drivers.
- **Payment Processing**: Process payments for rides.
- **Driver Ratings**: Submit and retrieve ratings for drivers.
- **Exception Handling**: Custom exceptions for better error management.

---

## 3. Folder Structure
The project follows the standard **Spring Boot** structure:
```
cabbookingsystem/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── cabbookingsystem/
│   │   │           ├── controller/       # REST controllers
│   │   │           ├── service/          # Business logic
│   │   │           ├── repository/       # Data access layer
│   │   │           ├── model/            # Entity classes
│   │   │           ├── exception/        # Custom exceptions
│   │   │           └── CabBookingSystemApplication.java  # Main application class
│   │   └── resources/
│   │       ├── application.properties    # Configuration properties
│   │       └── static/                   # Static resources (if any)
│   └── test/
│       └── java/
│           └── com/
│               └── cabbookingsystem/
│                   └── tests/            # Unit and integration tests
├── pom.xml                               # Maven configuration file
└── README.md                             # Project documentation
```

---

## 4. Technologies Used
- **Java**: Programming language.
- **Spring Boot**: Backend framework.
- **Spring Data JPA**: ORM for database interactions.
- **MySQL**: Relational database.
- **Hibernate Validator**: For input validation.
- **Maven**: Dependency management.
- **Postman**: API testing.

---

## 5. Setup Instructions

### Prerequisites
- **Java 17** or higher installed.
- **Maven** installed.
- **MySQL** database running.

### Steps
1. Clone the repository:
    ```bash
    git clone https://github.com/your-repo/cab-booking-system.git
    cd cab-booking-system
    ```

2. Configure the database:
    - Open `src/main/resources/application.properties`.
    - Update the database connection details:
      ```properties
      spring.datasource.url=jdbc:mysql://localhost:3306/cab_booking_system
      spring.datasource.username=root
      spring.datasource.password=your_password
      spring.jpa.hibernate.ddl-auto=update
      ```

3. Build the project:
    ```bash
    mvn clean install
    ```

4. Run the application:
    ```bash
    mvn spring-boot:run
    ```

5. Access the application:
    - The application will run on `http://localhost:8080`.

---


## 6. License
This project is licensed under the MIT License.

---
