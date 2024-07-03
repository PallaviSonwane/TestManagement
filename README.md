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

1. **Add Category:**

    ```bash
    POST /category/addCategory
    ```
    Request Body:
    ```bash
    {
    "categoryName": "Java",
    "categoryDescription": "Core Java category"
    }
    ```
    
2. **View All Categories:**

   ```bash
   GET /category/viewAllCategoryInfo

3. **View Category By ID:**

   ```bash
   GET /category/viewSingleCategory/4

4. **Delete Category By ID:**

   ```bash
   DELETE /category/deleteCategoryById/1

5. **Update Category By ID:**

   ```bash
   PUT /category/updateCategoryById/4


### Subcategory Management

1. **Add Subcategory**

   ```bash
   POST /subCategory/addSubcategory
   ```
   Request Body:
   ```bash
   {
  "subCategoryName": "Exception Handling",
  "subCategoryDis": "Exception Handling from Java"
  }


2. **View All Subcategory**

   ```bash
   GET /subCategory/getAllSubCategory

3. **View Subcategory By Id**

  ```bash
  GET /subCategory/getSubCategory/16
  ```

4. **Delete Subcategory By ID:**

  ```bash
  DELETE /subCategory/deleteSubCategory/1
  ```

5. **Update Subcategory By ID:**

  ```bash
  PUT /subCategory/updateSubCategory/21
  ```

### Exam Management

1. **Upload Excel Data**

   ```bash
   POST /exam/upload
   ```

   ```bash
   {
    "file": "<Excel File>"
  }


  
   

## Logging

SLF4J is used for logging. Logs are available to track requests, errors, and other important information.
