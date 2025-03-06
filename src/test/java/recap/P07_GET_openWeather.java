package recap;

import baseUrl.OpenWeatherBaseUrl;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class P07_GET_openWeather extends OpenWeatherBaseUrl {
    static String myApiKey="59cab9d7b63528c4269e6c57fed1c85e";

    /*
    📌 Endpoint: https://api.openweathermap.org/data/2.5/weather?q=Istanbul&appid=YOUR_API_KEY
    📌 HTTP Metodu: GET

    Senaryo:
    Bu endpoint'e bir GET request gönderdiğimizde dönen Response’un:

    Status code’unun 200,
    Content-Type’ının application/json; charset=utf-8,
    Response Body’sinde "name" alanının "Istanbul" olduğunu,
    Response Body’sinde "main.temp" değerinin -50 ile 50 arasında olmadığını
    test ediniz.

 */

    @Test
    public void test01(){
        specOpenWeather.pathParams("pp1","data","pp2","2.5","pp3","weather")
                .queryParams("q","Istanbul","appid",myApiKey);

        Response response=given().spec(specOpenWeather).when().get("/{pp1}/{pp2}/{pp3}");

        response.then().assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .body("name", Matchers.equalTo("Istanbul"));

        // response.prettyPrint();

        Assertions.assertFalse(response.jsonPath().getDouble("main.temp")>-50
                && response.jsonPath().getDouble("main.temp")<50);
    }
}