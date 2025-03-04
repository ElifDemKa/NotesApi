package tests;

import baseUrl.JPH_baseUrl;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.nullValue;

public class P12_baseUrl_JPH extends JPH_baseUrl {

      /*

           1- https://jsonplaceholder.typicode.com/posts endpointine
             bir GET request gonderdigimizde
             donen response’un status code’unun 200 oldugunu ve
             Response’ta 100 kayit oldugunu test edin


     */

    @Test
    public void get01(){

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
    public void get02(){
        specJPH.pathParams("pp1","posts","pp2","44");
        //endpointte hem posts hemde 44 olduğu için benim iki tane pram olduğu için params yaparım


        Response response=given().spec(specJPH).when().get("/{pp1}/{pp2}");

        response.then().assertThat().statusCode(200)
                .body("title",Matchers.equalTo("optio dolor molestias sit"));
    }

    /*
        3- https://jsonplaceholder.typicode.com/posts/50 endpointine bir DELETE
            request gonderdigimizde donen response’un status code’unun 200 oldugunu ve
            response body’sinin null oldugunu test edin
         */
    @Test
    public void delete01(){
         /*
        3- https://jsonplaceholder.typicode.com/posts/50 endpointine bir DELETE
            request gonderdigimizde donen response’un status code’unun 200 oldugunu ve
            response body’sinin null oldugunu test edin
         */

        // 1 - Url hazirla

        specJPH.pathParams("pp1","posts", "pp2",50);

        // 2 - Expected Data hazirla

        // 3 - Response'i kaydet

        Response response = given().spec(specJPH).when().delete("/{pp1}/{pp2}");

        response.prettyPrint();

        // Assertion

        response.then().assertThat().statusCode(200).body("title",nullValue());

    }


}