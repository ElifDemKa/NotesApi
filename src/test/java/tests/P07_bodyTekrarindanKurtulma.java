package tests;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class P07_bodyTekrarindanKurtulma {
    /*

     https://restful-booker.herokuapp.com/booking/10 url’ine
     bir GET request gonderdigimizde donen Response’un,
         status code’unun 200,
         ve content type’inin application-json,
         ve response body’sindeki
            “firstname”in, “Susan”,
         ve “lastname”in, “Jackson”,
         ve “totalprice”in, 612,
         ve “depositpaid”in, false,
         ve “additionalneeds”in, “Breakfast”
    oldugunu test edin

  */
    @Test
    public void test(){

        //1-Endpoint Hazırlama
        String url="https://restful-booker.herokuapp.com/booking/100";

        //2-ExpectedData Hazırlama - Soruda verilmemiş

        //3-Response kaydı
        Response response=given().when().get(url);

        //4-Assertion
        response.then().assertThat().statusCode(200).contentType("application/json; charset=utf-8")
                .body("firstname",equalTo("Josh"),"lastname",equalTo("Allen"),
                        "totalprice",equalTo(111),"depositpaid",equalTo(true),
                        "additionalneeds",equalTo("super bowls"));

    }
}
