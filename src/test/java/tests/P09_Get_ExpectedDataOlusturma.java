package tests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class P09_Get_ExpectedDataOlusturma {
    /*
    https://jsonplaceholder.typicode.com/posts/22 url'ine bir GET request yolladigimizda
     donen response body’sinin asagida verilen ile ayni oldugunu test ediniz
          Response body :
        {
            "userId": 3,
            "id": 22,
            "title": "dolor sint quo a velit explicabo quia nam",
            "body": "eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita ear
                    um mollitia molestiae aut atque rem suscipit\nnam impedit esse"
        }

     */



   @Test
   public void test(){
        // 1. Asama
       String url="https://jsonplaceholder.typicode.com/posts/22";

       // 2. Expected data olusturma
       JSONObject expData=new JSONObject();
       expData.put("userId",3);
       expData.put("id",22);
       expData.put("title","dolor sint quo a velit explicabo quia nam");
       expData.put("body","eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita ear" +
               "um mollitia molestiae aut atque rem suscipit\nnam impedit esse");


       //3. Asama Response Olusturma
       Response response=given().when().get(url);

       //expected data hazırlanmıssa bu verilerle donen cevabı karsılastırmak istersek
       //donen cevabinda JsonPath seklınde ulasılabilir olması lazım

       JsonPath resJP=response.jsonPath(); //Burada dönen cevap JSON Path formatında kaydedilmek için yapıldı.
            //biz response body bilgilerini bir objeye kaydederiz ve o obje uzerinden cagırırız

       assertEquals(expData.get("userId"),resJP.get("userId"));
       assertEquals(expData.get("id"),resJP.get("id"));
       assertEquals(expData.get("title"),resJP.get("title"));
       assertEquals(expData.get("body"),resJP.get("body"));



   }




   }


