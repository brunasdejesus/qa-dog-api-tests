package tests;

import org.junit.jupiter.api.Test;
import utils.BaseTest;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class BreedsTest extends BaseTest {

    @Test
    void shouldListAllBreeds() {

        given()
                .when()
                .get("/breeds/list/all")
                .then()
                .statusCode(200)
                .time(lessThan(3000L))
                .body("status", equalTo("success"))
                .body("message", notNullValue());


    }

    @Test
    void shouldReturnImagesFromBreed() {

        given()
                .when()
                .get("/breed/hound/images")
                .then()
                .statusCode(200)
                .time(lessThan(3000L))
                .body("status", equalTo("success"))
                .body("message", not(empty()));

    }

    @Test
    void shouldReturnRandomImage() {

        given()
                .when()
                .get("/breeds/image/random")
                .then()
                .statusCode(200)
                .time(lessThan(3000L))
                .body("status", equalTo("success"))
                .body("message", containsString("https://"));

    }

}


