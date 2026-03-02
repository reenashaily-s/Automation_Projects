package com.RestAPITest;

import static io.restassured.RestAssured.given;
import java.io.File;
import java.io.FileReader;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;
import io.restassured.response.Response;

public class UpdatePet 
{
    @Test
    public void updateExistingPet() throws Exception 
    {
        System.out.println("===== Test Started: Update Existing Pet =====");

        // ---------------- PUT: Update Pet ----------------
        File f1 = new File("updatePet.json");
        FileReader fr = new FileReader(f1);
        JSONTokener token = new JSONTokener(fr);
        JSONObject jsonObj = new JSONObject(token);

        Response putRes = given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .body(jsonObj.toString())
            .when()
                .put("https://petstore.swagger.io/v2/pet");

        System.out.println("PUT Status Code: " + putRes.getStatusCode());
        putRes.then().log().body();

        // Extract ID
        int petId = putRes.jsonPath().getInt("id");
        System.out.println("Updated Pet ID is: " + petId);

        // ---------------- GET: Verify Updated Pet ----------------
        Response getRes = given()
                .header("accept", "application/json")
            .when()
                .get("https://petstore.swagger.io/v2/pet/" + petId);

        System.out.println("GET Status Code: " + getRes.getStatusCode());
        getRes.then().log().body();

        // Validation
        if (getRes.getStatusCode() == 200)
            System.out.println("===== TEST PASSED : Pet updated successfully =====");
        else
            System.out.println("===== TEST FAILED =====");
    }
}
