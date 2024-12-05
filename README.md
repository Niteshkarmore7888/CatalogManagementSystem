# CatalogManagementSystem
 Requirements
Before running the project, ensure you have the following installed:
Java: Version 17 or higher
Spring Boot: Version 3.x or higher
MySQL: Installed and running on your machine
Maven: For managing project dependencies

# Setup Instructions
Clone the Repository
Clone the project to your local machine using Git:https://github.com/Niteshkarmore7888/CatalogManagementSystem.git

# Configure Database
Update the application.properties file with your MySQL database credentials:
spring.datasource.url=jdbc:mysql://localhost:3306/TwinleavsDb?createTableIfNotExists=true
spring.datasource.username=root
spring.datasource.password=12345
spring.jpa.hibernate.ddl-auto=update

# Run the Project
Use the following Maven command to run the application:
mvn spring-boot:run

Requirements
Before running the project, ensure you have the following installed:

Java: Version 17 or higher
Spring Boot: Version 3.x or higher
MySQL: Installed and running on your machine
Maven: For managing project dependencies
Setup Instructions
Clone the Repository
Clone the project to your local machine using Git:


git clone https://github.com/yourusername/catalog-management-system.git
cd catalog-management-system
Configure Database
Update the application.properties file with your MySQL database credentials:

# properties

spring.datasource.url=jdbc:mysql://localhost:3306/catalog_db
spring.datasource.username=your_username
spring.datasource.password=your_password

# Run the Project
Use the following Maven command to run the application:
mvn spring-boot:run

# Technologies Used
Spring Boot: Framework for building Java applications with minimal configuration
Spring Data JPA: Simplifies database interactions with MySQL using JPA repositories
Hibernate Validator: Used for input validation using annotations
MySQL: Relational database management system for storing product data
Lombok: Reduces boilerplate code (getters, setters, constructors) in Java classes

# Product Entity
The Product entity represents a product in the catalog with the following fields:
id: Unique identifier for each product
name: The name of the product
brand: The brand of the product
description: A short description of the product
price: The price of the product
quantity: The number of items in stock
category: The category of the product (e.g., Electronics, Furniture)
dateAdded: The date the product was added to the catalog

# Validation
Fields in the Product entity are validated using annotations:

@NotBlank: Ensures the field is not empty
@Positive: Ensures the field value is positive
@Size: Enforces the field to have a specific size range

