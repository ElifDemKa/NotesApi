package tests;

import baseUrl.RestFull_BaseUrl;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;

public class P13_restfullBaseUrl extends RestFull_BaseUrl{

     /*

       1- https://restful-booker.herokuapp.com/booking endpointine
       bir GET request gonderdigimizde donen response’un
       status code’unun 200 oldugunu ve
       Response’ta 12 bookingid'sine sahip booking oldugunu test edin

     */
     /*
        2- https://restful-booker.herokuapp.com/booking endpointine gerekli
        Query parametrelerini yazarak “firstname” degeri “Eric” olan rezervasyon
        oldugunu test edecek bir GET request gonderdigimizde, donen response’un
        status code’unun 200 oldugunu ve “Eric” ismine sahip en az bir booking oldugunu test edin
     */
     /*
        3- https://restful-booker.herokuapp.com/booking endpointine gerekli Query
         parametrelerini yazarak “firstname” degeri “Jim” ve “lastname” degeri
         “Jackson” olan rezervasyon oldugunu test edecek bir GET request gonderdigimizde,
         donen response’un status code’unun 200 oldugunu ve “Jim Jackson” ismine sahip
         en az bir booking oldugunu test edin.
    */

    @Test
    public void get01(){
        /*

       1- https://restful-booker.herokuapp.com/booking endpointine
       bir GET request gonderdigimizde donen response’un
       status code’unun 200 oldugunu ve
       Response’ta 12 bookingid'sine sahip booking oldugunu test edin

     */

        specRestFull.pathParam("pp1","booking");


        Response response=given().spec(specRestFull).when().get("/{pp1}");
        response.prettyPrint();
        response.then().assertThat().statusCode(200).body("bookingid", Matchers.hasItem(12));
        //not: burada *hasItemı kullanmamızın nedenı 12 numaralı panelin olup olmadığını test etmek içindir
        //eger 12 tane pane olduğunu test etmis olsaydık *hasSize kullanırdık
        //*greaterThan deseydik 12 ıd sinden buyuk olan ıd leri getir demis olurduk
    }




    @Test
    public void get02(){

        /*
        2- https://restful-booker.herokuapp.com/booking endpointine gerekli
        Query parametrelerini yazarak “firstname” degeri “Eric” olan rezervasyon
        oldugunu test edecek bir GET request gonderdigimizde, donen response’un
        status code’unun 200 oldugunu ve “Eric” ismine sahip en az bir booking oldugunu test edin
    */
        // 1 - Url hazirla

        specRestFull.pathParam("pp1","booking").queryParam("firstname","Eric");

        // 2 - Expected Data hazirla

        // 3 - Response'i kaydet

        Response response = given().spec(specRestFull).when().get("/{pp1}");

        response.prettyPrint();

        // 4 - Assertion

        response.then().assertThat().statusCode(200).body("bookingid",hasSize(2));

    }
    @Test
    public void get03(){
/*
        3- https://restful-booker.herokuapp.com/booking endpointine gerekli Query
         parametrelerini yazarak “firstname” degeri “Jim” ve “lastname” degeri
         “Jackson” olan rezervasyon oldugunu test edecek bir GET request gonderdigimizde,
         donen response’un status code’unun 200 oldugunu ve “Jim Jackson” ismine sahip
         en az bir booking oldugunu test edin.
    */

        // 1 - Url hazirla

        specRestFull
                .pathParam("pp1","booking")
                .queryParams("firstname","Jim","lastname","Jackson");

        // 2 - Expected Data

        // 3 - Response'i kaydet

        Response response = given().spec(specRestFull).when().get("/{pp1}");

        response.prettyPrint();

        // 4 - Assertion

        response
                .then()
                .assertThat()
                .statusCode(200)
                .body("bookingid",hasSize(3));

    }

}