package tests;

import baseUrl.RestFull_BaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.testng.annotations.Test;
import testDatas.RestFullDatas;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;


public class P20_POST_deSeralization extends RestFull_BaseUrl {
        /*

    https://restful-booker.herokuapp.com/booking url’ine
asagidaki body’ye sahip bir POST request gonderdigimizde
donen response’un id haric asagidaki gibi oldugunu test edin.

Request body
       {
           “firstname” : “Ahmet”,
           “lastname” : “Bulut”,
           “totalprice” : 500,
           “depositpaid” : false,
           “bookingdates” : {
               “checkin” : “2021-06-01”,
               “checkout” : “2021-06-10”
           },
           “additionalneeds” : “wi-fi”
       }

Response Body // expected data
 {
    “bookingid”: 24,
    “booking”: {
        “firstname”: “Ahmet”,
        “lastname”: “Bulut”,
        “totalprice”: 500,
        “depositpaid”: false,
        “bookingdates”: {
            “checkin”: “2021-06-01",
            “checkout”: “2021-06-10"
        },
        “additionalneeds”: “wi-fi”
    }
}

     */

    @Test
    public void test() {
        specRestFull.pathParam("pp1", "booking");
        Map<String, Object> reqMapBody = RestFullDatas.mapDataOlustur();

        Map<String, Object> expMapBody = RestFullDatas.expMapDataOlustur();

        Response response = given().spec(specRestFull).contentType(ContentType.JSON).when().body(reqMapBody).post("/{pp1}");

        //response.prettyPrint();

        Map<String, Object> resMAP = response.as(HashMap.class);


        assertEquals(((Map) expMapBody.get("booking")).get("firstname"),
                ((Map) resMAP.get("booking")).get("firstname"));
        assertEquals(((Map) expMapBody.get("booking")).get("lastname"),
                ((Map) resMAP.get("booking")).get("lastname"));
        assertEquals(((Map)expMapBody.get("booking")).get("totalprice"),
                ((Map)resMAP.get("booking")).get("totalprice"));
        assertEquals(((Map)expMapBody.get("booking")).get("depositpaid"),
                ((Map)resMAP.get("booking")).get("depositpaid"));

        assertEquals(((Map)((Map)expMapBody.get("booking")).get("bookingdates")).get("checkin"),
                ((Map)((Map)resMAP.get("booking")).get("bookingdates")).get("checkin"));

        assertEquals(((Map)((Map)expMapBody.get("booking")).get("bookingdates")).get("checkout"),
                ((Map)((Map)resMAP.get("booking")).get("bookingdates")).get("checkout"));











    }
}