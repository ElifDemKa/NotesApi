package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;

public class ReqResBaseUrl {

    protected RequestSpecification specReqRes;

    @BeforeEach
    public void setup(){
        specReqRes=new RequestSpecBuilder().setBaseUri("https://reqres.in").build();
    }
}