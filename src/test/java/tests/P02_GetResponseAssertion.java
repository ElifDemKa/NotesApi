package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class P02_GetResponseAssertion {

    /*
    https://restful-booker.herokuapp.com/booking/10 url’ine
    bir GET request gonderdigimizde donen Response’un,
 	status code’unun 200,
	ve content type’inin application/json; charset=utf-8,
	ve Server isimli Header’in degerinin Cowboy,
	ve status Line’in HTTP/1.1 200 OK
	oldugunu otomasyonla assert ediniz.

     */


@Test
    public  void  test02(){

    //1-EndPonit hazırlanır(url ve varsa(PUT-POST-PATCH) request Body hazırlanır)
    String url="https://restful-booker.herokuapp.com/booking/10";

    //2-Soruda verilmiş ise Expected Data hazırlanır. Verilmemişse hazırlanmaz (verilmemis)

    //3-Dönen cevap kaydedilir (obje olusturulur)
    Response response= RestAssured.get(url);

    //4-Assertion işlemleri yapılır (karsılastırma)
    // eger burada expected ve actual data karsılastırılmıyorsa ;

    response.then().assertThat().statusCode(200)
                                .contentType("application/json; charset=utf-8")
                                .header("Server", "Cowboy")
                                .statusLine("HTTP/1.1 200 OK");
      //NOT: Bize burada sonuc donmeyebilir fakat testim hata vermezse sonuc passed'dir



}

}
