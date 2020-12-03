package ru.netology;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PostmanEchoTestApiV1 {
    @Test
    void shouldReturnDemoAccounts(){
        // Given - When - Then
        // Предусловия
        given()
                .baseUri("https://postman-echo.com")
                .contentType("application/json; charset=UTF-8")
                .body("{\"id\": 1, \"name\": \"Leanne Graham\", \"email\": \"sincere@april.biz\", \"photos\": [\"photo1.jpg\"]}") // отправляемые данные (заголовки и query можно выставлять аналогично)
        // Выполняемые действия
                .when()
                .post("/post")
        // Проверки
                .then()
                .statusCode(200)
                .body("data.id", equalTo(1))
                .body("data.name", equalTo("Leanne Graham"))
                .body("data.email", equalTo("sincere@april.biz"))
                .body("data.photos", hasSize(1))
                .body("data.photos[0]", equalTo("photo1.jpg"))
        ;
    }
}
