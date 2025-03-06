package recap;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class P01_GET_apiSorgusu {
    /*

       https://reqres.in/api/users/2 URL'sine bir GET isteği gönderin.
           Gelen yanıtın durum kodunun 200 olduğunu doğrulayın.
           Yanıtın JSON body'sinde yer alan data.id değerinin 2 olduğunu doğrulayın.
           Yanıt süresinin 2 saniyeden kısa olduğunu kontrol edin.

 */
    @Test
    public void test(){

        String url="https://reqres.in/api/users/2";


        //Response response=given().when().get(url); //Header değerleri eklenmeyecekse tercih edilmez
        Response response= RestAssured.get(url);
        response.then().assertThat().statusCode(200);


        assertEquals(2,response.jsonPath().getInt("data.id"));
        assertTrue(response.getTime()<2000);

    }
}