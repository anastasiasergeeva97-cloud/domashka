package postman;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PutRequestTest extends BaseTest {
//тест
    @Test
    void putRequest_shouldReturnSameBody() {
        String body = "This is expected to be sent back as part of response body.";

        given()
                .body(body)
                .when()
                .put("/put")
                .then()
                .statusCode(200)
                .body("data", equalTo(body));
    }
}
