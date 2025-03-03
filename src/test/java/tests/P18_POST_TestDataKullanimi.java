package tests;

import baseUrl.RestFull_BaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import testDatas.JPHDatas;
import testsDatas.RestFullDatas;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class P18_POST_TestDataKullanimi extends RestFull_BaseUrl {

    /*
       https://restful-booker.herokuapp.com/booking url’ine asagidaki body’ye sahip
        bir POST request gonderdigimizde donen response’un
        id haric asagidaki gibi oldugunu test edin.

        Request body
               {
                   “firstname” : “Ahmet”,
                   “lastname” : “Bulut”,
                   “totalprice” : 500,
                   “depositpaid” : false,
                   “bookingdates” : {
                       "checkin" : "2021-06-01",
                       “checkout” : “2021-06-10”
                   },
                   “additionalneeds” : “wi-fi”
               }
        Response Body
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

    //  @Test
    //  public void test(){
    //      specRestFull.pathParam("pp1","booking");
    //
    //      JSONObject reqBody= RestFullDatas.jSONDataOlustur();
    //
    //      JSONObject expBody=new JSONObject();
    //      expBody.put("bookingid",24);
    //      expBody.put("booking",RestFullDatas.jSONDataOlustur());
    //
    //
    //      Response response=given().contentType(ContentType.JSON).spec(specRestFull).when().body(reqBody.toString()).post("/{pp1}");
    //      response.prettyPrint();
    // JsonPath resJP=response.jsonPath();

    //  assertEquals(expBody.getJSONObject("booking").getString("firstname"),resJP.get("booking.firstname"));
    //  assertEquals(expBody.getJSONObject("booking").getString("lastname"),resJP.get("booking.lastname"));
    //  assertEquals(expBody.getJSONObject("booking").getString("totalprice"),resJP.get("booking.totalprice"));
    //  assertEquals(expBody.getJSONObject("booking").getString("depositpaid"),resJP.get("booking.depositpaid"));
    //  assertEquals(expBody.getJSONObject("booking").getJSONObject("bookingdates").getString("checkin"),
    //              resJP.get("booking.checkin"));
    //  assertEquals(expBody.getJSONObject("booking").getJSONObject("bookingdates").getString("checkout"),
    //              resJP.get("booking.checkout"));

    //   assertEquals(expBody.getJSONObject("booking").get("additionalneeds"), resJP.get("booking.additionalneeds"));

    //}

    @Test
    public void test02(){

        specRestFull.pathParam("pp1","booking");

        JSONObject bookingdates= RestFullDatas.bookingDatesOlustur2("2021-06-01","2021-06-10");
        JSONObject reqBody=RestFullDatas.reqBodyOlustur2("Murat","BABAYİĞİT",500,true,bookingdates,"wi-fi");


        JSONObject expData=new JSONObject();
        expData.put("bookingid",24);
        expData.put("booking",reqBody);


        Response response=given().contentType(ContentType.JSON).spec(specRestFull).when().body(reqBody.toString()).post("/{pp1}");


        response.then().assertThat().statusCode(500);
    }}