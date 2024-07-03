# TestManagement

This project is an Exam Management System developed using Spring Boot and Hibernate, designed to manage categories, subcategories, and exam questions.

## Features

- **Category Management:**
  - Add, view all, view by ID, update, and delete categories.
  
- **Subcategory Management:**
  - Add, view all, view by ID, update, and delete subcategories.
  
- **Exam Management:**
  - Upload questions from Excel.
  - Add, view all, view by ID, update, and delete exam questions.


## Technologies Used

- Java
- Spring Boot
- Apache POI
- Spring Data JPA
- Lombok
- SLF4J (for logging)

## Getting Started

To run this project locally, follow these steps:

1. **Clone the Repository:**

   ```bash
   git clone https://github.com/pallaviSonwane/testmanagement-api.git
   ```
   ```bash
   cd testmanagement-api
   ```

   
1. **Set up the database:**
   
   Ensure you have PostgreSQL installed locally or configure your database settings in application.properties.

2. **Build and run the application:**
    ```bash
   ./mvnw spring-boot:run

3. **Access the API endpoints:**

  Once the application is running, you can access the API using tools like Postman.


## API Endpoints

### Category Management

- **Add Category:**

1. **Create Category:**

    ```bash
    POST /category/addCategory
    Request Body:
    ```bash
    {
    "categoryName": "Science",
    "categoryDescription": "Topics related to scientific disciplines"
    }

1. **Create MCQ Question:**

   ```bash
   POST /exam/addQuestion
   Request Body:
   ```bash
   {
  "question_id": 1,
  "question_text": "What is the capital of France?",
  "options": ["Paris", "London", "Berlin"],
  "correct_answer": "Paris"
  }


2. **Get All Questions:**

   ```bash
   GET /exam/viewQuestion

3. **Update Question:**

   ```bash
   PUT /exam/updateById/{question_id}
   Request Body:
   ```bash
   {
  "question_text": "What is the capital of Germany?",
  "options": ["Paris", "London", "Berlin"],
  "correct_answer": "Berlin"
  }


4. **Get Question by ID:**

     ```bash
     GET /exam/viewById/{question_id}
     
5. **Delete Question:**

   ```bash
   DELETE /exam/deleteById/{question_id}

## Logging

SLF4J is used for logging. Logs are available to track requests, errors, and other important information.
