package tests;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.BeforeClass;
import static org.hamcrest.CoreMatchers.equalTo;

public class BaseTest {

    private static final String baseUrl = "https://jsonplaceholder.typicode.com/";

    static RequestSpecification requestSpec;

    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = baseUrl;
    }

    @BeforeClass
    public static void setupRequestSpecBuilder()
    {
        RequestSpecBuilder requestBuilder = new RequestSpecBuilder();

        requestBuilder.setContentType("application/json");
        requestBuilder.setBaseUri(baseUrl);

        requestSpec = requestBuilder.build();
    }

    //ToDo move this to a separate class that extends BaseTest.
    ResponseSpecification responseSpecBuilder(Integer userId, Integer id, String title, boolean completed)
    {
        ResponseSpecBuilder responseBuilder = new ResponseSpecBuilder();

        responseBuilder.expectStatusCode(200);
        responseBuilder.expectBody("userId", equalTo(userId));
        responseBuilder.expectBody("id", equalTo(id));
        responseBuilder.expectBody("title", equalTo(title));
        responseBuilder.expectBody("completed", equalTo(completed));

        return responseBuilder.build();
    }
}