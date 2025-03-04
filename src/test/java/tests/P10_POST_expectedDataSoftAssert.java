package tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class P10_POST_expectedDataSoftAssert {
/*

https://restful-booker.herokuapp.com/booking url’ine
asagidaki body’ye sahip bir POST request gonderdigimizde

Request body
      {
        "firstname": "Ahmet",
        "lastname": "Bulut",
        "totalprice": 500,
        "depositpaid": false,
        "bookingdates": {
            "checkin": "2021-06-01",
            "checkout": "2021-06-10"
        },
        "additionalneeds": "wi-fi"
    }

donen response’un id haric asagidaki gibi oldugunu test edin.

Response Body - Expected Data
 {
    “bookingid”: 24,
    “booking”: {
        "firstname": "Ahmet",
        "lastname": "Bulut",
        "totalprice": 500,
        "depositpaid": false,
        "bookingdates": {
            "checkin": "2021-06-01",
            "checkout": "2021-06-10"
        },
        additionalneeds": "wi-fi"
    }
}
*****NOT:bana yukarıdaki soruda response body içerisinde
iki tane obje verilmiş *BookingID ve *Booking.
dolayısıyla benim 2 tane obje olusturmam gerekir
 */



    @Test
    public void test() {
        //1-Endpoint ve reqBody hazırlama
        String url = "https://restful-booker.herokuapp.com/booking";
        JSONObject reqBody = new JSONObject();
        JSONObject bookingdates = new JSONObject();
        bookingdates.put("checkin", "2021-06-01"); // OBJE İÇİNDEKİ VERİLER YANİ KUTU İÇİNDE KUTU
        bookingdates.put("checkout", "2021-06-10");

        reqBody.put("firstname", "Elif");
        reqBody.put("lastname", "Demirci");
        reqBody.put("totalprice", 500);
        reqBody.put("depositpaid", false);
        reqBody.put("bookingdates", bookingdates);
        reqBody.put("additionalneeds", "wi-fi");


        //2-Expected Data hazırlanır
        JSONObject expData = new JSONObject();
        expData.put("bookingid",712);
        expData.put("booking",reqBody); // burada yukarıda olusturduğumuz request bodyleri tek tek de yazabiliriz
        // ama reqbody objesini direkt alacrak da bu sekilde de yazabiliriz

        //3-Response kaydı yapılır
        Response response=given().contentType(ContentType.JSON)
                .when().body(reqBody.toString()).post(url);
        //given burda responseyi kat-ydeden temel işlem
        //post methodu ile sorgu yaptığımız için post ekleriz
        //veri gönderdiğim için contenttyp ve contenttype turunu de yazarız

        //4-Assertion işlemi

        JsonPath resJP=response.jsonPath(); // response body gönderdiysel jasonpath olusturulur
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(resJP.get("booking.firstname"),expData.getJSONObject("booking").get("firstname"));
        softAssert.assertEquals(resJP.get("booking.lastname"),expData.getJSONObject("booking").get("lastname"));
        softAssert.assertEquals(resJP.get("booking.totalprice"),expData.getJSONObject("booking").get("totalprice"));
        softAssert.assertEquals(resJP.get("booking.depositpaid"),expData.getJSONObject("booking").get("depositpaid"));
        softAssert.assertEquals(resJP.get("booking.additionalneeds"),expData.getJSONObject("booking").get("additionalneeds"));
        softAssert.assertEquals(resJP.get("booking.bookingdates.checkin"),
                expData.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"));
        softAssert.assertEquals(resJP.get("booking.bookingdates.checkout"),
                expData.getJSONObject("booking").getJSONObject("bookingdates").get("checkout"));

        softAssert.assertAll();

        //HATIRLATMA:Hard assert de önce expected sonra actual yazılır
        //soft asertte ise önce actual sonra expected yazılır
        /*
         JsonPath respJP = response.jsonPath();

        assertEquals(expData.getJSONObject("booking").get("firstname"), respJP.get("booking.firstname") );
        assertEquals(expData.getJSONObject("booking").get("lastname"), respJP.get("booking.lastname") );
        assertEquals(expData.getJSONObject("booking").get("totalprice"), respJP.get("booking.totalprice"));
        assertEquals(expData.getJSONObject("booking").get("depositpaid"), respJP.get("booking.depositpaid"));
        assertEquals(expData.getJSONObject("booking").get("additionalneeds"), respJP.get("booking.additionalneeds"));
        assertEquals(expData.getJSONObject("booking").getJSONObject("bookingdates").get("checkin") ,
                     respJP.get("booking.bookingdates.checkin") );
        assertEquals(expData.getJSONObject("booking").getJSONObject("bookingdates").get("checkout") ,
                respJP.get("booking.bookingdates.checkout") );
         */



    }

}
