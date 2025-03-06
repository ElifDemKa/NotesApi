package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;

public class CollectApiBaseUrl {
    protected RequestSpecification specCollectApi;

    @BeforeTest
    public void setUp(){
        specCollectApi=new RequestSpecBuilder().setBaseUri("https://api.collectapi.com").build();
    }
}