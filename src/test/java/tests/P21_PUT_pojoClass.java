package tests;

import baseUrl.JPH_baseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.POJOJPH;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class P21_PUT_pojoClass extends JPH_baseUrl {
    /**

     https://jsonplaceholder.typicode.com/posts/70 url’ine
     asagidaki body’e sahip bir PUT request yolladigimizda
     donen response’in response body’sinin
     asagida verilen ile ayni oldugunu test ediniz

     Request Body
     {
     “title”: “Ahmet”,
     “body”: “Merhaba”,
     “userId”: 10,
     “id”: 70
     }

     Expected Data :
     {
     “title”: “Ahmet”,
     “body”: “Merhaba”,
     “userId”: 10,
     “id”: 70
     }

     */

    @Test
    public void POJOClassTest(){
        specJPH.pathParams("pp1","posts","pp2","70");
        POJOJPH reqPOJO = new POJOJPH("Murat","Merhaba",10,70);

        POJOJPH expPOJO = new POJOJPH("Murat","Merhaba",10,70);

        Response response=given().spec(specJPH).contentType(ContentType.JSON)
                .when().body(reqPOJO).put("/{pp1}/{pp2}");

        //  response.prettyPrint();

        POJOJPH resPOJO=response.as(POJOJPH.class);

        assertEquals(expPOJO.getTitle(),resPOJO.getTitle());
        assertEquals(expPOJO.getBody(),resPOJO.getBody());
        assertEquals(expPOJO.getUserId(),resPOJO.getUserId());
        assertEquals(expPOJO.getId(),resPOJO.getId());

    }
}