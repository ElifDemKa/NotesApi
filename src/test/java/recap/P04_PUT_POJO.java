package recap;

import baseUrl.ReqResBaseUrl;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pojo.ReqResPOJO;

public class P04_PUT_POJO extends ReqResBaseUrl {
    /*

    https://reqres.in/api/users/2 URL'sine
    header değeri "Content-Type","application/json" olan
    bir PUT isteği gönderin.
        Kullanıcıyı şu şekilde güncelleyin:
                 {
                 "name": "John Doe",
                 "job": "Manager"
                  }
        Yanıtın durum kodunun 200 olduğunu doğrulayın ve n

       ame alanının John Doe olduğunu doğrulayın.

 */
    @Test
    public void test() {
        specReqRes.pathParams("pp1","api","pp2","users","pp3","2");
        ReqResPOJO reqBody=new ReqResPOJO("John Doe","Manager");

        Response response= RestAssured
                .given()
                .spec(specReqRes).contentType(ContentType.JSON)
                .header("Content-Type","application/json")
                .when().body(reqBody).put("/{pp1}/{pp2}/{pp3}");


        //response.prettyPrint();

        Assertions.assertEquals(200,response.getStatusCode());
        Assertions.assertEquals("John Doe",response.jsonPath().get("name"));

    }
}