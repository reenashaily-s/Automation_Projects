package com.RestAPITest;

import static io.restassured.RestAssured.*;
import java.io.File;
import java.io.FileReader;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;
import io.restassured.response.Response;

public class PetAssignment 
{
    static int petId;

    // -------------------------------
    // 1. Find Pet By Status
    // -------------------------------
    @Test(priority = 1)
    public void findPetByStatus() 
    {
        System.out.println("===== Find Pet By Status =====");

        Response res = given()
                .queryParam("status", "available")
                .header("accept", "application/json")
            .when()
                .get("https://petstore.swagger.io/v2/pet/findByStatus");

        res.then().statusCode(200);
        res.then().body("[0].status", Matchers.equalTo("available"));
    }

    // -------------------------------
    // 2. Add New Pet
    // -------------------------------
    @Test(priority = 2)
    public void addPet() throws Exception 
    {
        System.out.println("===== Add Pet =====");

        File f = new File("addPet.json");
        FileReader fr = new FileReader(f);
        JSONTokener jt = new JSONTokener(fr);
        JSONObject jsonObj = new JSONObject(jt);

        Response res = given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .body(jsonObj.toString())
            .when()
                .post("https://petstore.swagger.io/v2/pet");

        res.then().statusCode(200);

        petId = res.jsonPath().getInt("id");
        System.out.println("Generated Pet ID: " + petId);
    }

    // -------------------------------
    // 3. Get Pet By ID
    // -------------------------------
    @Test(priority = 3)
    public void getPetById() 
    {
        System.out.println("===== Get Pet By ID =====");

        Response res = given()
                .header("accept", "application/json")
            .when()
                .get("https://petstore.swagger.io/v2/pet/" + petId);

       
        System.out.println("Pet ID Used: " + petId);
        res.then().log().body();
        res.then().statusCode(200);
    }

    // -------------------------------
    // 4. Update Pet
    // -------------------------------
    @Test(priority = 4)
    public void updatePet() throws Exception 
    {
        System.out.println("===== Update Pet =====");

        File f = new File("updatePet.json");
        FileReader fr = new FileReader(f);
        JSONTokener jt = new JSONTokener(fr);
        JSONObject jsonObj = new JSONObject(jt);

        jsonObj.put("id", petId);

        Response res = given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .body(jsonObj.toString())
            .when()
                .put("https://petstore.swagger.io/v2/pet");

        res.then().statusCode(200);
    }

    // -------------------------------
    // 5. Delete Pet
    // -------------------------------
    @Test(priority = 5)
    public void deletePet() 
    {
        System.out.println("===== Delete Pet =====");

        Response res = given()
                .header("accept", "application/json")
            .when()
                .delete("https://petstore.swagger.io/v2/pet/" + petId);

        res.then().statusCode(200);
    }
}
