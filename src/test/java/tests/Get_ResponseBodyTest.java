package tests;

import org.junit.jupiter.api.Test;

public class Get_ResponseBodyTest {
    /*

       https://jsonplaceholder.typicode.com/posts/44 url'ine
       bir GET request yolladigimizda
       donen Response'in
        status code'unun 200,
        ve content type'inin application/json,
        ve response body'sinde bulunan userId'nin 5,
        ve response body'sinde bulunan title'in "optio dolor molestias sit"
       oldugunu test edin.,

 */

    @Test
    public  void  test(){

       // 1-EndPonit hazırlanır(url ve varsa(PUT-POST-PATCH) request Body hazırlanır)
        String url= "https://jsonplaceholder.typicode.com/posts/44";
       // 2-Soruda verilmiş ise Expected Data hazırlanır. Verilmemişse hazırlanmaz

       // 3-Dönen cevap kaydedilir

       // 4-Assertion işlemleri yapılır



    }



}
