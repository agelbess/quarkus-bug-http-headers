package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class MyResourceTest {

    @Test
    public void testGet() {
        given()
          .when().get("/get")
          .then()
             .statusCode(200);
    }

    @Test
    public void buggyGet() {
        given()
                .when().get("/buggyGet")
                .then()
                .statusCode(200);
    }

}
