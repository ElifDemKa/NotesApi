package recap;

import baseUrl.ReqResBaseUrl;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

public class P02_GET_ListKullanimi extends ReqResBaseUrl {
    /*

        https://reqres.in/api/users?page=2 URL'sine bir GET isteği gönderin.
        Gelen yanıtın durum kodunun 200 olduğunu doğrulayın.
        Liste içerisindeki kullanıcı sayısının en az 1 olduğunu doğrulayın.
        İlk kullanıcının email adresinin boş olmadığını kontrol edin.

 */
    @Test
    public void test(){
        specReqRes.pathParams("pp1","api","pp2","users")
                .queryParam("page",2);

        Response response=given().spec(specReqRes).when().get("/{pp1}/{pp2}");

        // response.prettyPrint();
        assertEquals(200,response.getStatusCode());
        assertTrue(response.jsonPath().getList("data").size()>0);
        assertFalse(response.jsonPath().getList("data").isEmpty());
        assertNotNull(response.jsonPath().get("data[0].email"));

        System.out.println("\nAssert Durumu Başarılı!");


    }
}