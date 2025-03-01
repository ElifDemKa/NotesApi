package tests;

import baseUrl.RestFull_BaseUrl;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class P13_restfullBaseUrl extends RestFull_BaseUrl{

     /*

       https://restful-booker.herokuapp.com/booking endpointine
       bir GET request gonderdigimizde donen response’un
       status code’unun 200 oldugunu ve
       Response’ta 12 bookingid'sine sahip booking oldugunu test edin

  */

    @Test
    public void test01(){

        specRestFull.pathParam("pp1","booking");


        Response response=given().spec(specRestFull).when().get("/{pp1}");
        response.prettyPrint();
        response.then().assertThat().statusCode(200).body("bookingid", Matchers.hasItem(12));
        //not: burada *hasItemı kullanmamızın nedenı 12 numaralı panelin olup olmadığını test etmek içindir
        //eger 12 tane pane olduğunu test etmis olsaydık *hasSize kullanırdık
        //*greaterThan deseydik 12 ıd sinden buyuk olan ıd leri getir demis olurduk
    }

}