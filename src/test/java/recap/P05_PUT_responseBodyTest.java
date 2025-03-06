package recap;

import baseUrl.ReqResBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class P05_PUT_responseBodyTest extends ReqResBaseUrl {
    /*
        https://reqres.in/api/users/2 URL'ine
        aşağıdaki JSON body ile PUT request gönderildiğinde
            {
                "name": "Murat",
                "job": "Senior QA"
            }

            dönen Response’un:

            Status code’unun 200 olduğunu,
            Content type’ının application/json; charset=utf-8 olduğunu,
            Response Body’sini updatedAt hariç
            aşağıdaki expectedBody ile birebir eşleştiğini test ediniz.

            {
                "name": "Murat",
                "job": "Senior QA",
                "updatedAt": "2025-03-05T12:34:56.789Z"
            }
     */

    @Test
    public void test(){
        specReqRes.pathParams("pp1","api","pp2","users","pp3","2");
        //iç veriler assert edilecekse string olarak veri oluşturulmaz
        // String reqBody="{\"name\": \"Murat\",\"job\": \"Senior QA\"}";
        // String expBody="{\"name\": \"Murat\",\"job\": \"Senior QA\",\"updatedAt\": \"2025-03-05T12:34:56.789Z\"}";

        JSONObject reqBody=new JSONObject();
        reqBody.put("name", "Murat");
        reqBody.put("job","Senior QA");

        JSONObject expBody=new JSONObject();
        expBody.put("name", "Murat");
        expBody.put("job","Senior QA");
        expBody.put("updatedAt", "2025-03-05T12:34:56.789Z");


        Response response=given().spec(specReqRes).contentType(ContentType.JSON)
                .when().body(reqBody.toString()).put("/{pp1}/{pp2}/{pp3}");



        assertEquals(200,response.getStatusCode());
        assertEquals(expBody.get("name"),response.jsonPath().get("name"));
        assertEquals(expBody.get("job"),response.jsonPath().get("job"));

    }
}