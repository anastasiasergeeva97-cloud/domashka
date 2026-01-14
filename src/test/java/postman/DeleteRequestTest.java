package postman;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class DeleteRequestTest extends BaseTest {

    @Test
    void deleteRequest_shouldReturnSameBody() {
        String body = "This is expected to be sent back as part of response body.";

        given()
                .body(body)
                .when()
                .delete("/delete")
                .then()
                .statusCode(200)
                .body("data", equalTo(body));
    }
}
