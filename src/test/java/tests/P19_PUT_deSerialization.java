package tests;

import baseUrl.JPH_baseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import testDatas.JPHDatas;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class P19_PUT_deSerialization extends JPH_baseUrl {
    /*
           https://jsonplaceholder.typicode.com/posts/70 url'ine
           asagidaki body’e sahip bir PUT request yolladigimizda
           donen response’in response body’sinin
           asagida verilen ile ayni oldugunu test ediniz
           Request Body
           {
               "title": "Ahmet",
               "body": "Merhaba",
               "userId": 10,
               "id": 70
           }

           Expected Data :
           {
               "title": "Ahmet",
               "body": "Merhaba",
               "userId": 10,
               "id": 70
           }

    */
    @Test
    public void test02(){
        specJPH.pathParams("pp1","posts","pp2","70");
        Map<String,Object> reqMAPBody= JPHDatas.MAPDataOlustur();

        Map<String,Object> expMAPBody=JPHDatas.MAPDataOlustur();

        Response response=given().contentType(ContentType.JSON).spec(specJPH).when().body(reqMAPBody).put("/{pp1}/{pp2}");

        // response.prettyPrint();

        Map<String,Object> resMAP=response.as(HashMap.class);

        assertEquals(resMAP.get("title"),expMAPBody.get("title"));
        assertEquals(resMAP.get("body"),expMAPBody.get("body"));
        assertEquals(resMAP.get("id"),expMAPBody.get("id"));
        assertEquals(resMAP.get("userId"),expMAPBody.get("userId"));

    }


    @Test
    public void test03(){
        specJPH.pathParams("pp1","posts","pp2","70");
        Map<String,Object> reqMabBody=JPHDatas.MapDataOlustur2("Ahmet","Merhaba",10.0,70.0);

        Map<String, Object> expMapBody=JPHDatas.MapDataOlustur2("Ahmet","Merhaba",10.0,70.0);

        Response response=given().contentType(ContentType.JSON).spec(specJPH).when().body(reqMabBody).put("/{pp1}/{pp2}");


        Map<String,Object> resMAP=response.as(HashMap.class);

        assertEquals(expMapBody.get("title"),resMAP.get("title"));
        assertEquals(expMapBody.get("body"),resMAP.get("body"));
        assertEquals(expMapBody.get("id"),resMAP.get("id"));
        assertEquals(expMapBody.get("userId"),resMAP.get("userId"));



    }
}