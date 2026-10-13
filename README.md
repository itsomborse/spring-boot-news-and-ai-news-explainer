# 📰 News Vault AI (`news-vault-ai`)

**News Vault AI** is a robust, secure Spring Boot REST API application designed to store, manage, and deliver news content with integrated AI-powered insights. The platform features Role-Based Access Control (RBAC) separating Public and Admin operations, custom input validation, centralized exception handling, and AI summary explanations for stored news articles via Spring AI.

---

## 🌟 Key Features

* **🔑 Role-Based Access Control (RBAC):**
  * **Public Endpoints (`/api/news/**`):** Unrestricted access to view news, search articles by title, and get AI-generated news explanations.
  * **Admin Endpoints (`/api/admin/**`):** Protected endpoints requiring `ADMIN` role authentication for Insert, Update, and Delete operations.
* **🤖 AI News Explainer (Spring AI):**
  * Explains complex news articles in plain language by analyzing news descriptions using Spring AI (`ChatModel`).
* **🛡️ Security & Authentication:**
  * Spring Security configuration with BCrypt Password Encoding and HTTP Basic/Form Login support.
* **⚡ Input Validation & Exception Handling:**
  * Automatic validation using Jakarta Bean Validation (`@Valid`).
  * Custom centralized exception handling via `@ControllerAdvice` (`globalExceptiion`) returning structured `ExceptionFormat` JSON responses.
* **💾 Persistence Layer:**
  * Spring Data JPA integrated with SQL Database (`newsdatabase` entity mapping).

---

## 🛠️ Tech Stack & Dependencies

* **Language:** Java 21
* **Framework:** Spring Boot 3.4.1
* **Modules:**
  * Spring Web (MVC)
  * Spring Security
  * Spring Data JPA
  * Spring AI (`spring-ai-starter-model-google-genai`)
  * Spring Boot Validation
* **Libraries & Utilities:** Lombok, BCrypt Password Encoder
* **Database:** MySQL / PostgreSQL

---

## 📁 Project Structure Overview

```text
com.ilovenews.News
 ├── configuration
 │    ├── PasswordSecurityConfiguration.java   # BCrypt PasswordEncoder Bean
 │    └── SecurityConfiguration.java           # Security Filter Chain, CORS, and In-Memory Admin setup
 ├── controller
 │    ├── NewsControllerAdmin.java            # Protected CRUD Endpoints (/api/admin)
 │    └── NewsControllerPublic.java           # Public Access & AI Explainer Endpoints (/api/news)
 ├── globalexception
 │    ├── custome
 │    │    └── NewsNotFoundException.java     # Custom Runtime Exception
 │    ├── dto
 │    │    └── ExceptionFormat.java           # Standard Error Response Payload
 │    └── globalExceptiion.java              # Centralized @ExceptionHandler Handler
 ├── module
 │    └── News.java                            # JPA Entity mapped to 'newsdatabase'
 ├── repository
 │    └── NewsRepository.java                  # JPA Repository with custom search query
 └── service
      └── NewsService.java                     # Core Business Logic & Spring AI Integration
```

---

## ⚙️ Configuration Setup

# Server Configuration
server.port=8080

# Database Configuration (MySQL Example)
spring.datasource.url=jdbc:mysql://localhost:3306/news_db?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# Spring AI Configuration
spring.ai.google.genai.api-key=YOUR_GEMINI_API_KEY

---

## 📥 Example Request (Insert News)

POST /api/admin/insert
Content-Type: application/json

{
  "title": "Spring Boot 3.4 Released",
  "shortDescription": "New features in Spring Boot 3.4",
  "description": "Spring Boot 3.4 brings enhanced GraalVM support, improved structured logging, and new observability features for microservices.",
  "publishedAt": "2026-10-13T18:00:00"
}

"Added"
