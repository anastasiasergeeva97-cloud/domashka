package postman;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PostFormDataTest extends BaseTest {
//тест
    @Test
    void postFormData_shouldReturnFormFields() {
        given()
                .contentType("application/x-www-form-urlencoded")
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("form.foo1", equalTo("bar1"))
                .body("form.foo2", equalTo("bar2"));
    }
}