package tests;

import baseUrl.RestFull_BaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class P14_RestFullPOST extends RestFull_BaseUrl {
       /*
            https://restful-booker.herokuapp.com/booking endpointine
            asagidaki body’ye sahip bir POST request gonderdigimizde donen response’un
            status code’unun 200 oldugunu ve “firstname” degerinin “Elif” oldugunu test edin
{
     "firstname" : “Elif”,
     “lastname” : “Demirci”,
     “totalprice” : 500,
     “depositpaid” : false,
     “bookingdates” : {
              "checkin": "2021-06-01",
              "checkout" : “2021-06-10”
                       },
     “additionalneeds” : “wi-fi”
  }
     */

    @Test
    public void test(){
        specRestFull.pathParam("pp1","booking");
        JSONObject bookingdates=new JSONObject();
        bookingdates.put( "checkin", "2021-06-01");
        bookingdates.put( "checkout", "2021-06-10");

        JSONObject reqBody=new JSONObject();
        reqBody.put("firstname","Elif");
        reqBody.put("lastname","Demirci");
        reqBody.put("totalprice",500);
        reqBody.put("depositpaid",false);
        reqBody.put("bookingdates",bookingdates);
        reqBody.put("additionalneeds","wi-fi");


        Response response=given().contentType(ContentType.JSON)
                .spec(specRestFull).when()
                .body(reqBody.toString()).post("/{pp1}");
 /*
        silme isleminde:  DELETE
        update isleminde: PUT - PATCH(parçalı)
        yeni kayıt ouısturmak istersek: POST
        görüntüleme yapmak istersek: GET
  */

        response.then().assertThat().statusCode(200).body("booking.firstname", equalTo("Elif"),
                "booking.lastname",equalTo("Demirci"),"booking.totalprice",equalTo(500),
                "booking.depositpaid",equalTo(false),"booking.bookingdates.checkin",equalTo("2021-06-01"),
                "booking.bookingdates.checkout",equalTo("2021-06-10"),
                "booking.additionalneeds",equalTo("wi-fi"));

    }


    /*
     https://restful-booker.herokuapp.com/booking endpointine
            asagidaki body’ye sahip bir POST request gonderdigimizde
{
     "firstname" : “Murat”,
     “lastname” : “Yiğit”,
     “totalprice” : 500,
     “depositpaid” : false,
     “bookingdates” : {
              "checkin": "2021-06-01",
              "checkout" : “2021-06-10”
                       },
     “additionalneeds” : “wi-fi”
            {

     donen response’unstatus code’unun 200 oldugunu ve sonucun bookingid hariç
     aşşağıdaki gibi olduğunu test edin

    "bookingid": 1063,
    "booking": {
        "firstname": "Murat",
        "lastname": "Yiğit",
        "totalprice": 500,
        "depositpaid": false,
        "bookingdates": {
            "checkin": "2021-06-01",
            "checkout": "2021-06-10"
        },
        "additionalneeds": "wi-fi"
    }
}

     */

}