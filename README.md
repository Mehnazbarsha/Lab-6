# Lab 6: REST Endpoints

Software Engineering - Prof. Bradford

## Project Description

This project implements REST endpoints for:
1. Password quality evaluation
2. Email address validation

Both endpoints are fully tested with comprehensive unit tests.

## Prerequisites

- Java 17 or higher
- Maven 3.6+
- Git

## Project Structure

```
lab6/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           └── lab6/
│   │   │               ├── Lab6Application.java
│   │   │               ├── controller/
│   │   │               │   ├── PasswordController.java
│   │   │               │   └── EmailController.java
│   │   │               ├── service/
│   │   │               │   ├── PasswordService.java
│   │   │               │   └── EmailService.java
│   │   │               └── model/
│   │   │                   ├── PasswordQualityRequest.java
│   │   │                   ├── PasswordQualityResponse.java
│   │   │                   ├── EmailValidationRequest.java
│   │   │                   └── EmailValidationResponse.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/
│           └── com/
│               └── example/
│                   └── lab6/
│                       └── service/
│                           ├── PasswordServiceTest.java
│                           └── EmailServiceTest.java
├── pom.xml
└── README.md
```

## How to Build and Run

### 1. Clone the Repository

```bash
git clone <your-repository-url>
cd lab6
```

### 2. Make Maven Wrapper Executable (if needed)

```bash
chmod a+x ./mvnw
```

### 3. Build the Project

```bash
./mvnw clean package
```

This will compile the code and run all unit tests.

### 4. Run the Application

```bash
./mvnw spring-boot:run
```

The application will start on `http://localhost:8080`

### 5. Run Tests Only

```bash
./mvnw test
```

## REST API Endpoints

### 1. Password Quality Check

**Endpoint:** `POST /api/password-quality`

**Request Body:**
```json
{
  "password": "YourPassword123!"
}
```

**Response:**
```json
{
  "quality": "STRONG",
  "score": 90,
  "feedback": "Excellent password!"
}
```

**Quality Levels:**
- `STRONG`: Score >= 80
- `MODERATE`: Score >= 60
- `WEAK`: Score >= 40
- `VERY_WEAK`: Score < 40
- `INVALID`: Empty or null password

**Testing with curl:**
```bash
curl -X POST http://localhost:8080/api/password-quality \
  -H "Content-Type: application/json" \
  -d '{"password":"StrongP@ssw0rd!"}'
```

### 2. Email Address Validation

**Endpoint:** `POST /api/email-address-valid`

**Request Body:**
```json
{
  "email": "user@example.com"
}
```

**Response:**
```json
{
  "valid": true,
  "message": "Valid email address"
}
```

**Testing with curl:**
```bash
curl -X POST http://localhost:8080/api/email-address-valid \
  -H "Content-Type: application/json" \
  -d '{"email":"test@example.com"}'
```

## Testing

The project includes comprehensive unit tests for both services:

- **PasswordServiceTest**: Tests password evaluation logic with various scenarios
- **EmailServiceTest**: Tests email validation with valid and invalid inputs

### Test Coverage Includes:

**Password Tests:**
- Strong passwords
- Moderate passwords
- Weak passwords
- Empty/null passwords
- Passwords with various character combinations

**Email Tests:**
- Valid email formats
- Invalid formats (no @, multiple @, missing domain, etc.)
- Empty/null emails
- Emails with special characters

## Password Scoring Criteria

The password quality is evaluated based on:

1. **Length** (35 points total)
   - 25 points for 8+ characters
   - 10 additional points for 12+ characters

2. **Uppercase Letters** (20 points)
   - Contains at least one uppercase letter

3. **Lowercase Letters** (20 points)
   - Contains at least one lowercase letter

4. **Digits** (15 points)
   - Contains at least one number

5. **Special Characters** (10 points)
   - Contains special characters (!@#$%^&*, etc.)

## Email Validation Criteria

An email is considered valid if it meets these requirements:

1. Contains exactly one @ symbol
2. Has a non-empty username before @
3. Has a domain after @ with at least one dot
4. Does not contain spaces
5. Matches standard email format pattern

## Dependencies

- Spring Boot 3.1.5
- Spring Web
- JUnit Jupiter (for testing)

