package tests;

import lombok.LombokUserData;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static specs.Specs.*;


//API-тесты
//#1 проверка метода GET "SINGLE USER" (получить конкретного юзера)
//#2 проверка метода GET "SINGLE USER NOT FOUND" (пользователь не найден

public class lombokReqresInApiTest {

    //#1 проверка метода GET SINGLE USER (получить конкретного юзера)
    //  /api/users/3
    //  ОР: "ID = 3
    @Test
    void checkGETusers() {
        LombokUserData data = given()
                                .spec(myRequest)
                            .when()
                                .get("/users/3")
                            .then()
                                .spec(myResponse200) //убедиться, что статус-код 200 ОК
                                .log().body()
                                .extract().as(LombokUserData.class);

        assertEquals(3, data.getMyUser().getId());
}

    //#2 проверка метода GET SINGLE USER NOT FOUND (пользователь не найден
    //  /api/users/33
    //  ОР: statusCode == 404
    @Test
    void checkGETemptyUsers() {

        LombokUserData data = given()
                .spec(myRequest)
                .when()
                .get("/users/33")
                .then()
                .spec(myResponse404) //убедиться, что возврщается ошибка 404
                .log().body()
                .extract().as(LombokUserData.class);

    }
}
