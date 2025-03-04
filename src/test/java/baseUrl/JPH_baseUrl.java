package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;

public class JPH_baseUrl {
    protected RequestSpecification specJPH;
        //JPH JasonPlaceHolder
    @BeforeTest  // her bir testten önce calısması için beforetest
    public void setUp()

    {specJPH=new RequestSpecBuilder()
            .setBaseUri("https://jsonplaceholder.typicode.com")
            .build();  //bu kod sabittir sadece adresi degistirerek istedigimiz islemi yaparız




    }




}
