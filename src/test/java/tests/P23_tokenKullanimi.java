package tests;

import baseUrl.RestFull_BaseUrl;
//import com.google.gson.annotations.JsonAdapter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;
import testDatas.RestFullDatas;

import static io.restassured.RestAssured.given;

public class P23_tokenKullanimi extends RestFull_BaseUrl {
    /*
    https://restful-booker.herokuapp.com/booking/3170 (id güncellenmeli)
    adresindeki rezervasyon bilgilerini
        -H 'Content-Type: application/json' \
        -H 'Accept: application/json' \
        -H 'Cookie: token=abc123' \ veya -H 'Authorization:Basic YWRtaW46cGFzc3dvcmQxMjM=' \
        header değerleriyle PUT request göndererek update ediniz.


        Token Oluşturma
        Content-Type: application/json header derğeriyle aşağıdaki body ile
        {
                "username" : "admin",
                "password" : "password123"
        }
        Post Request yapınız

 */

    static String token;

    @Test
    public void createToken(){
        specRestFull.pathParam("pp1","auth");

        JSONObject data=new JSONObject();
        data.put("username","admin");
        data.put("password","password123");

        Response response=given().contentType(ContentType.JSON).spec(specRestFull).when().body(data.toString()).post("/{pp1}");

        JsonPath resJP=response.jsonPath();

        token= resJP.getString("token");

        System.out.println("Token :"+token);

    }

    @Test
    public void test01(){
        specRestFull.pathParams("pp1","booking","pp2","61");
        JSONObject reqBody= RestFullDatas.jSONDataOlustur();

        Response response=given().spec(specRestFull).contentType(ContentType.JSON)
                .when().body(reqBody.toString())
                .header("Content-Type","application/json")
                .header("Accept", "application/json")
                .header("Cookie","token="+token).put("/{pp1}/{pp2}");

        /*
        {
    "firstname": "Josh",
    "lastname": "Allen",
    "totalprice": 111,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2018-01-01",
        "checkout": "2019-01-01"
    },
    "additionalneeds": "super bowls"
}
         */


        response.prettyPrint();


    }

    @Test
    public void test02(){
        specRestFull.pathParams("pp1","booking","pp2","1572");
        JSONObject reqBody= RestFullDatas.jSONDataOlustur();

        Response response=given().spec(specRestFull).contentType(ContentType.JSON)
                .when().body(reqBody.toString())
                .header("Content-Type","application/json")
                .header("Accept", "application/json")
                .header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=").put("/{pp1}/{pp2}");
        response.prettyPrint();
    }
}