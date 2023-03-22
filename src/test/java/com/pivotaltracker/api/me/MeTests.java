package com.pivotaltracker.api.me;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MeTests {
    @Test
    public void getMeTests(){

        String endpoint = "https://www.pivotaltracker.com/services/v5/me";
        Response response = RestAssured.given()
                .header("X-TrackerToken","bd5061b2aa8bd14e9298a2d20117fa52")
                .when()
                .get(endpoint);
        int actualStatusCode = response.statusCode();
         int expectedStatusCode = 200;

        Assert.assertEquals( expectedStatusCode, actualStatusCode );

        System.out.println(response.getBody().asString());






    }
}
