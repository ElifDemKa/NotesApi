package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;

public class RestFull_BaseUrl{

    protected RequestSpecification specRestFull;


    @BeforeTest
    public void setUp(){
        specRestFull=new RequestSpecBuilder().
                setBaseUri("https://restful-booker.herokuapp.com").build();
    }
}