package tests;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class P05_GET_ResponseBodyTest {

     /*

        https://jsonplaceholder.typicode.com/posts/44 url’ine
        bir GET request yolladigimizda
        donen Response’in
         status code’unun 200,
         ve content type’inin application/json,
         ve response body’sinde bulunan userId’nin 5,
         ve response body’sinde bulunan title’in “optio dolor molestias sit”
        oldugunu test edin.,

  */

    @Test
    public void test(){

        // 1-EndPoint Hazırlama
        String url="https://jsonplaceholder.typicode.com/posts/44";

        // 2-Expected Data - Yok

        // 3- Response kaydı
        Response response=given().when().get(url);

        response.prettyPrint();

        // 4-Assertion işlemleri
        response.then().assertThat().statusCode(200).contentType("application/json")
                .body("userId", Matchers.equalTo(5))
                .body("title",Matchers.equalTo("optio dolor molestias sit"));

    }


}
