package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class EmployeeApiTest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI =
                "https://jsonplaceholder.typicode.com";
    }

    // Test 1: Get employee details
    @Test
    public void getEmployeeTest() {

        given()
            .pathParam("id", 1)
        .when()
            .get("/users/{id}")
        .then()
            .statusCode(200)
            .body("id", equalTo(1))
            .body("name", notNullValue())
            .body("email", containsString("@"));
    }

    // Test 2: Check invalid employee ID
    @Test
    public void getInvalidEmployeeTest() {

        given()
        .when()
            .get("/users/9999")
        .then()
            .statusCode(404);
    }

    // Test 3: Create a new employee
    @Test
    public void createEmployeeTest() {

        String requestBody = "{\n"
            + "    \"name\": \"Janardan\",\n"
            + "    \"username\": \"janardan123\",\n"
            + "    \"email\": \"janardan@example.com\"\n"
            + "}";

        given()
            .header("Content-Type", "application/json")
            .body(requestBody)
        .when()
            .post("/users")
        .then()
            .statusCode(201)
            .body("name", equalTo("Janardan"))
            .body("email", equalTo("janardan@example.com"));
    }

    // Test 4: Update employee details
    @Test
    public void updateEmployeeTest() {

        String requestBody = "{\n"
            + "    \"name\": \"Janardan Updated\",\n"
            + "    \"email\": \"updated@example.com\"\n"
            + "}";

        given()
            .header("Content-Type", "application/json")
            .body(requestBody)
        .when()
            .put("/users/1")
        .then()
            .statusCode(200)
            .body("name", equalTo("Janardan Updated"))
            .body("email", equalTo("updated@example.com"));
    }

    // Test 5: Delete employee
    @Test
    public void deleteEmployeeTest() {

        given()
        .when()
            .delete("/users/1")
        .then()
            .statusCode(200);
    }

    // Test 6: Validate response time
    @Test
    public void checkResponseTimeTest() {

        given()
        .when()
            .get("/users/1")
        .then()
            .statusCode(200)
            .time(lessThan(5000L));
    }
}
