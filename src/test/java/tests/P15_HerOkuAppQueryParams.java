package tests;

import baseUrl.RestFull_BaseUrl;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class P15_HerOkuAppQueryParams extends RestFull_BaseUrl {



    /*

    https://restful-booker.herokuapp.com/booking endpointine
    gerekli Query parametrelerini yazarak
    “firstname” degeri “Eric” olan rezervasyon oldugunu test edecek
    bir GET request gonderdigimizde, donen response’un status code’unun
    200 oldugunu ve “Eric” ismine sahip en az bir booking oldugunu test edin

 */
    @Test
    public void test02(){
        specRestFull.pathParam("pp1","booking").queryParam("firstname","Eric");

        Response response=given().spec(specRestFull).when().get("/{pp1}");

        response.then().assertThat().statusCode(200).body("size()",Matchers.greaterThan(0));


    }



    /*
           https://restful-booker.herokuapp.com/booking endpointine
           gerekli Query parametrelerini yazarak
           “firstname” degeri “Jim” ve “lastname” degeri “Jackson” olan rezervasyon oldugunu
           test edecek bir GET request gonderdigimizde,
           donen response’un status code’unun 200 oldugunu ve
           “Jim Jackson” ismine sahip en az bir booking oldugunu test edin

     */
    @Test
    public void test03(){
        specRestFull.pathParam("pp1","booking").queryParams("firstname","Josh","lastname","Allen");

        Response response=given().spec(specRestFull).when().get("/{pp1}");

        response.then().assertThat().statusCode(200).body("size()", Matchers.greaterThan(0));
        // sorguda en az 1 tanew booking istediği için biz hem size nı isteriz hemde en az bir tane dededği için
        //0' dan büyük olsun deriz *greaterThan


    }

}