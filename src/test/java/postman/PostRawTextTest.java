package postman;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PostRawTextTest extends BaseTest {

    @Test
    void postRawText_shouldReturnSameBody() {
        String body = "This is expected to be sent back as part of response body.";

        given()
                .body(body)
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", equalTo(body));
    }
}
