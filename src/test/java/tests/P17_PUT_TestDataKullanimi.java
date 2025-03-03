package tests;

import baseUrl.JPH_baseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import testDatas.JPHDatas;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class P17_PUT_TestDataKullanimi extends JPH_baseUrl {
    /*
    https://jsonplaceholder.typicode.com/posts/70 url’ine asagidaki body’e sahip
    bir PUT request yolladigimizda donen response’in
    status kodunun 200, content type’inin “application/json; charset=utf-8”,
    Connection header degerinin “keep-alive”
    ve response body’sinin asagida verilen ile ayni oldugunu test ediniz
    Request Body
        {
            “title”: “Ahmet”,
            “body”: “Merhaba”,
            “userId”: 7,
            “id”: 70
        }
   Response Body
              {
            “title”: “Ahmet”,
            “body”: “Merhaba”,
            “userId”: 7,
            “id”: 70
        }
*/

    @Test
    public void test01(){
        specJPH.pathParams("pp1","posts","pp2",70);
        JSONObject reqBody= JPHDatas.jSONDataOlustur();

        JSONObject expBody=JPHDatas.jSONDataOlusturPli(3,70,"Ahmet","Merhaba");

        Response response=given().spec(specJPH).contentType(ContentType.JSON).when().body(reqBody.toString()).put("/{pp1}/{pp2}");

        assertEquals(response.getStatusCode(), JPHDatas.basariliStatusCode);
        assertEquals(response.getContentType(), JPHDatas.ContenType);
        assertEquals(response.getHeader("Connection"), JPHDatas.connectionHeader);

        JsonPath resJP=response.jsonPath();


        assertEquals(resJP.getInt("userId"),expBody.get("userId"));
        // dönen cevap içindeki veriyi veri türüne göre getInt şeklinde çağırmalıyız
        //  Eğer farklı data türü olursa bu data türü farklılığı nedeniyle assertion error verir
        assertEquals(resJP.getInt("id"),expBody.get("id"));
        assertEquals(resJP.getString("title"),expBody.get("title"));
        assertEquals(resJP.getString("body"),expBody.get("body"));


        // Junit Assert'de (expected, actual)
        // TestNg Assert'de (actual,expected) yazılır



    }}