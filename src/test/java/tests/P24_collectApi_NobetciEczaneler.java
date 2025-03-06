package tests;

import baseUrl.CollectApiBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.responseSpecification;

public class P24_collectApi_NobetciEczaneler extends CollectApiBaseUrl {
 /*
        https://api.collectapi.com/health/dutyPharmacy?il=istanbul&ilce=Üsküdar
        adresine aşağıdaki bilgilerler bir GET request yapınca
        dönen cevabı yazdırınız.

        header
        Content-Type : application/json
        Authorization: apiKeyiniz

  */

    @Test
    public void test01(){
        specCollectApi.pathParams("pp1","health","pp2","dutyPharmacy")
                .queryParams("il","istanbul","ilce","Üsküdar");

        Response response=given().spec(specCollectApi).when()
                .header("Content-Type","application/json")
                .header("Authorization","apikey 4kI8rTnIIPO3yPcrzStSfI:1Hb4JHbWETWOQNHusEJo1a")
                .get("/{pp1}/{pp2}");

        response.prettyPrint();



    }
}