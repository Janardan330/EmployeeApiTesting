# Employee Management API Testing Framework

An automated API testing framework built with **Java**, **REST Assured**, and **TestNG** that validates CRUD operations on an Employee Management API.

## 📋 Project Overview

This framework sends HTTP requests to a REST API and verifies whether the API returns the expected results. It covers the full spectrum of employee management operations:

- ✅ **Create** a new employee
- ✅ **Retrieve** employee details
- ✅ **Update** employee information
- ✅ **Delete** an employee
- ✅ **Validate** invalid requests and missing employees
- ✅ **Response time** threshold validation

> **Note:** This project uses the public [JSONPlaceholder API](https://jsonplaceholder.typicode.com) for testing. JSONPlaceholder simulates POST, PUT, and DELETE operations — these return sample responses but do not permanently change stored data.

## 🛠️ Technologies

| Technology | Purpose |
|---|---|
| Java 11+ | Programming language |
| REST Assured 5.5.6 | API automation library |
| Maven | Dependency management & build tool |
| TestNG 7.11.0 | Test execution and assertions |
| JSON | API request and response format |
| Git/GitHub | Version control |

## 📁 Project Structure

```
EmployeeApiTesting/
│
├── pom.xml                              # Maven configuration
├── mvnw / mvnw.cmd                      # Maven Wrapper (no global install needed)
├── .gitignore
├── README.md
│
└── src/
    └── test/
        └── java/
            └── tests/
                └── EmployeeApiTest.java  # All API test cases
```

## 🚀 Getting Started

### Prerequisites

- **Java 11** or higher installed ([Download Java](https://www.oracle.com/java/technologies/downloads/))
- **Git** installed ([Download Git](https://git-scm.com/downloads))
- No Maven installation required — the project includes a Maven Wrapper

### Installation

1. **Clone the repository:**
   ```bash
   git clone https://github.com/Janardan330/EmployeeApiTesting.git
   cd EmployeeApiTesting
   ```

2. **Run the tests:**

   **Windows:**
   ```bash
   mvnw.cmd clean test
   ```

   **macOS/Linux:**
   ```bash
   chmod +x mvnw
   ./mvnw clean test
   ```

   If you have Maven installed globally, you can also run:
   ```bash
   mvn clean test
   ```

3. **View test reports:**

   After running, reports are available at:
   ```
   target/surefire-reports/
   ```

## 🧪 Test Cases

| # | Test Case | HTTP Method | Endpoint | Expected Status |
|---|-----------|-------------|----------|-----------------|
| 1 | Retrieve employee | GET | `/users/1` | 200 OK |
| 2 | Invalid employee ID | GET | `/users/9999` | 404 Not Found |
| 3 | Create employee | POST | `/users` | 201 Created |
| 4 | Update employee | PUT | `/users/1` | 200 OK |
| 5 | Delete employee | DELETE | `/users/1` | 200 OK |
| 6 | Response time check | GET | `/users/1` | 200 OK (< 5 seconds) |

### Test Details

- **GET Employee** — Retrieves user with ID 1 and validates the response contains a valid `id`, non-null `name`, and an `email` with `@`.
- **GET Invalid Employee** — Requests a non-existent user (ID 9999) and expects a 404 response.
- **POST Create Employee** — Sends a JSON body with `name`, `username`, and `email` fields and validates the response echoes them back with a 201 status.
- **PUT Update Employee** — Sends updated `name` and `email` for user ID 1 and verifies the changes in the response.
- **DELETE Employee** — Deletes user ID 1 and expects a 200 status.
- **Response Time Check** — Ensures the GET request completes within 5 seconds.

## 📊 Sample Test Output

```
-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running tests.EmployeeApiTest
Tests run: 6, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 9.448 s -- in tests.EmployeeApiTest

Results:

Tests run: 6, Failures: 0, Errors: 0, Skipped: 0

------------------------------------------------------------------------
BUILD SUCCESS
------------------------------------------------------------------------
```

## 📦 Dependencies

Defined in `pom.xml`:

```xml
<!-- REST Assured - API Testing -->
<dependency>
    <groupId>io.rest-assured</groupId>
    <artifactId>rest-assured</artifactId>
    <version>5.5.6</version>
</dependency>

<!-- TestNG - Test Framework -->
<dependency>
    <groupId>org.testng</groupId>
    <artifactId>testng</artifactId>
    <version>7.11.0</version>
</dependency>
```

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/new-test`)
3. Commit your changes (`git commit -m 'Add new test case'`)
4. Push to the branch (`git push origin feature/new-test`)
5. Open a Pull Request

## 📄 License

This project is open source and available for educational purposes.

## 👤 Author

**Janardan** — [GitHub](https://github.com/Janardan330)
