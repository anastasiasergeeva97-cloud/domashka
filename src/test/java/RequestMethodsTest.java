package postman;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.PrintStream;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class RequestMethodsTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://postman-echo.com";

        // Логируем всё в консоль
        PrintStream console = System.out;
        RestAssured.filters(
                new RequestLoggingFilter(console),
                new ResponseLoggingFilter(console)
        );
    }

    @Test
    public void testGetRequest() {
        given()
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .when()
                .get("/get")
                .then()
                .statusCode(200)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"))
                .body("url", equalTo("https://postman-echo.com/get?foo1=bar1&foo2=bar2"));
    }

    @Test
    public void testPostRawText() {
        String body = "This is expected to be sent back as part of response body.";

        given()
                .contentType(ContentType.TEXT)
                .body(body)
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", equalTo(body))
                .body("json", equalTo(null));
    }

    @Test
    public void testPostFormData() {
        given()
                .contentType(ContentType.URLENC)
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("form.foo1", equalTo("bar1"))
                .body("form.foo2", equalTo("bar2"));
    }

    @Test
    public void testPutRequest() {
        String body = "This is expected to be sent back as part of response body.";

        given()
                .contentType(ContentType.TEXT)
                .body(body)
                .when()
                .put("/put")
                .then()
                .statusCode(200)
                .body("data", equalTo(body));
    }

    @Test
    public void testPatchRequest() {
        String body = "This is expected to be sent back as part of response body.";

        given()
                .contentType(ContentType.TEXT)
                .body(body)
                .when()
                .patch("/patch")
                .then()
                .statusCode(200)
                .body("data", equalTo(body));
    }

    @Test
    public void testDeleteRequest() {
        String body = "This is expected to be sent back as part of response body.";

        given()
                .contentType(ContentType.TEXT)
                .body(body)
                .when()
                .delete("/delete")
                .then()
                .statusCode(200)
                .body("data", equalTo(body));
    }
}