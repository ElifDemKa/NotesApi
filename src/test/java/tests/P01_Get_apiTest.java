package tests;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;


public class P01_Get_apiTest {

    /*
    https://restful-booker.herokuapp.com/booking/10 url’ine
    bir GET request gonderdigimizde donen Response’un,
    status code’unun 200,
    ve content type’inin application/json; charset=utf-8,
    ve Server isimli Header’in degerinin Cowboy,
    ve status Line’in HTTP/1.1 200 OK
    ve response suresinin 5 sn’den kisa oldugunu manuel olarak test ediniz.
     */

    /*
   Tüm API sorguları 4 aşamada yapılır
       1-EndPonit hazırlanır(url ve varsa(PUT-POST-PATCH) request Body hazırlanır)
       2-Soruda verilmiş ise Expected Data hazırlanır. Verilmemişse hazırlanmaz
       3-Dönen cevap kaydedilir
       4-Assertion işlemleri yapılır

 */

@Test
    public void test(){
    //1-EndPonit hazırlanır
    String url= "https://restful-booker.herokuapp.com/booking/10";

    //2-Soruda verilmiş ise Expected Data hazırlanır. Verilmemişse hazırlanmaz

    //3-Dönen cevap kaydedilir (obje olusturulur)
    Response response=given().when().get(url); // RestAssured.get(url); // yani buradaki url'ye bir sorgu gönderdiğim zaman donen cevabı responseye ata

    // response.prettyPrint(); //bilgilerini gösterir ama sistemi yorar
    // response.prettyPeek();  // tüm bilgilerini getirir
    // ama bunu manuel degil su sekilde yapmamız daha uygun

    //4-Assertion işlemleri yapılır
    System.out.println("Statüs Degeri:" +response.getStatusCode()); //200
    System.out.println("Content Type Degeri:" +response.getContentType()); //application/json; charset=utf-8
    System.out.println("Server İsimli Header Degeri:" +response.getHeader("server")); //Cowboy
    System.out.println("Statüs Line Degeri:" +response.getStatusLine()); //HTTP/1.1 200 OK
    System.out.println("Response Süresi Degeri:" +response.getTime()); //5 sn’den kisa


}




}
