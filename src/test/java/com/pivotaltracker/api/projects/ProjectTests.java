package com.pivotaltracker.api.projects;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProjectTests {
    @Test
    public void postProjectTests(){
        String endpoint = "https://www.pivotaltracker.com/services/v5/projects";
        String bodyContent = """
                {
                    "name": "Automation"
                }
                """;

        Response response = RestAssured.given()
                .header("X-TrackerToken","bd5061b2aa8bd14e9298a2d20117fa52")
                .header("Content-Type","application/json")
                .body(bodyContent)
                .when()
                .post(endpoint);
        int actualStatusCode = response.statusCode();
        int expectedStatusCode = 200;

        Assert.assertEquals( expectedStatusCode, actualStatusCode );

        String actualProjectName = response.jsonPath().getString("name");
        String expectedProjectName = "Automation";

        Assert.assertEquals(actualProjectName, expectedProjectName);



    }
}
