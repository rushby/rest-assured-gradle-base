package tests;


import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRecordTests extends BaseTest {

    private static String endpoint = "todos/";

    @Test
    public void getRecordShouldReturnCorrectRecord(){

        Integer recordId = 1;

        given().
                spec(requestSpec).
        when().
                get(endpoint + recordId).
        then().
                spec(responseSpecBuilder(recordId, recordId,"delectus aut autem",false));
    }
}