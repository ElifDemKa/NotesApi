package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;

public class OpenWeatherBaseUrl {

    protected  RequestSpecification specOpenWeather;

    @BeforeEach
    public void setup(){
        specOpenWeather=new RequestSpecBuilder().setBaseUri("https://api.openweathermap.org").build();


    }
}