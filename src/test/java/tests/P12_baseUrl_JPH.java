package tests;

import baseUrl.JPH_baseUrl;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class P12_baseUrl_JPH extends JPH_baseUrl {

      /*

            https://jsonplaceholder.typicode.com/posts endpointine
             bir GET request gonderdigimizde
             donen response’un status code’unun 200 oldugunu ve
             Response’ta 100 kayit oldugunu test edin


     */

    @Test
    public void test01(){

        //1-Endpoint hazırlanması
        specJPH.pathParam("pp1", "posts");  // eger parametrem 1 tane ise pathparamı seceriz,
                                                 // birden fazla ise pathparams seceriz

        //2-Expected Body verilmemiş

        //3-Response kaydı

        Response response=given().spec(specJPH).when().get("/{pp1}");
        //response.prettyPrint();

        //4-Assertion
        response.then().assertThat().statusCode(200).body("body", Matchers.hasSize(100));

    }
    /*
    2- https://jsonplaceholder.typicode.com/posts/44 endpointine
        bir GET request gonderdigimizde donen response’un
        status code’unun 200 oldugunu ve “title” degerinin
        “optio dolor molestias sit” oldugunu test edin

     */
    @Test
    public void test02(){
        specJPH.pathParams("pp1","posts","pp2","44");
        //endpointte hem posts hemde 44 olduğu için benim iki tane pram olduğu için params yaparım


        Response response=given().spec(specJPH).when().get("/{pp1}/{pp2}");

        response.then().assertThat().statusCode(200)
                .body("title",Matchers.equalTo("optio dolor molestias sit"));
    }

}