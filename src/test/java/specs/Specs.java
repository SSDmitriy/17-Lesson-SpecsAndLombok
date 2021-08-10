package specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;

//спецификации для запроса
public class Specs {
    public static RequestSpecification myRequest = with()
            .baseUri("https://reqres.in/")
            .basePath("/api")
            .log().all()
            .contentType(ContentType.JSON);

    //для ответа сервера "200 ОК"
    public static ResponseSpecification myResponse200 = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .build();

    //для ответа сервера "404"
    public static ResponseSpecification myResponse404 = new ResponseSpecBuilder()
            .expectStatusCode(404)
            .build();
}
