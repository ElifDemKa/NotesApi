package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class P08_JsonPathileBodyTesti {
    /*
    https://restful-booker.herokuapp.com/booking url’ine
    asagidaki body’ye sahip bir POST request gonderdigimizde
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
    donen Response’un,
    status code’unun 200,
    ve content type’inin application/json,
    ve response body’sindeki
       “firstname”in,“Ahmet”,
    ve “lastname”in, “Bulut”,
    ve “totalprice”in,500,
    ve “depositpaid”in,false,
    ve “checkin” tarihinin 2021-06-01
    ve “checkout” tarihinin 2021-06-10
    ve “additionalneeds”in,“wi-fi”
    oldugunu test edin
  */
    @Test
    public void jsonPathileBodyTesti(){
        //1-EndPoint ve reqBody hazırlama
        String url="https://restful-booker.herokuapp.com/booking";

        JSONObject bookingDates=new JSONObject();
        bookingDates.put("checkin" , "2021-06-01");
        bookingDates.put("checkout" , "2021-06-10");

        JSONObject reqBody=new JSONObject();
        reqBody.put("firstname","Murat");
        reqBody.put("lastname","Babayiğit");
        reqBody.put("totalprice",500);
        reqBody.put("depositpaid",true);
        reqBody.put("bookingdates",bookingDates);
        reqBody.put("additionalneeds","wi-fi");

        //2- Expected data hazırla (verilmemiş)

        //3-Response Kaydetme
        Response response=given().contentType(ContentType.JSON).when().body(reqBody.toString()).post(url);

        //Not: given dan sonra bir veri gönderiyorsan contentType ifade etmen gereklidir
        // when'den sonra body i gönderirken reqBody i direkt degil bir obje olduğu için Tostring ile gondeririz

        response.prettyPrint();

        //4-Assertion
        response.then().assertThat().statusCode(200).contentType("application/json")
                .body("booking.firstname", equalTo("Murat"),
                        "booking.lastname",equalTo("Babayiğit"),
                        "booking.totalprice",equalTo(500),"booking.depositpaid",equalTo(true),
                        "booking.bookingdates.checkin",equalTo("2021-06-01"),
                        "booking.bookingdates.checkout",equalTo("2021-06-10"),
                        "booking.additionalneeds",equalTo("wi-fi"));
//
    }
}
