package tests;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class P11_GET_ResponseBodyTestListKullanimi {
    /*

    https://api.collectapi.com/health/dutyPharmacy?il=Kırıkkale url’ine
    bir GET request yolladigimizda
    donen Response’in
    status code’unun 200,
    ve content type’inin application/json,
    ve response body’sindeki
    eczane sayısıın sayisinin 6
    ve eczane’lerden birinin “DELİCE ECZANESİ”
    ve eczanele ilçelerinde icinde keskin ,karakeçili ve yahşihan degerlerinin oldugunu test edin.
 */

    @Test
    public void test(){

        String url="https://api.collectapi.com/health/dutyPharmacy?il=Kirikkale";
        //Get olduğu için reqBody yok, soruda verilmediği için expBody yok


        String apikey="apikey 4kI8rTnIIPO3yPcrzStSfI:1Hb4JHbWETWOQNHusEJo1a";

        Response response=given().when().header("authorization",apikey).get(url);
        // response.prettyPrint();

        response.then().assertThat().statusCode(200).contentType("application/json")
                .body("result.dist", hasSize(6),"result.name",hasItem("ENES ECZANESİ"),
                        "result.dist",hasItems("yahşihan","karakeçili","keskin"));
    }


}