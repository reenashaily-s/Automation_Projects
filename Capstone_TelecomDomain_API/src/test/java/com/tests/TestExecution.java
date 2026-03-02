package com.tests;

import com.base.BaseTest;
import com.pojo.*;
import com.utils.DataGenerator;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class TestExecution extends BaseTest {

    @Test(priority = 1)
    public void tc1_addUser() {
        userEmail = DataGenerator.getUniqueEmail();
        User user = new User("Test", "User", userEmail, "pass123");
        Response res = given().contentType(ContentType.JSON).body(user).post("/users");
        
        token = res.jsonPath().getString("token");
        res.then().statusCode(201);
        test.info("Status Code: 201 | Registered Email: " + userEmail);
    }

    @Test(priority = 2, dependsOnMethods = "tc1_addUser")
    public void tc2_getUserProfile() {
        given().header("Authorization", "Bearer " + token).get("/users/me")
        .then().statusCode(200).body("email", equalTo(userEmail));
        test.info("Status Code: 200 | Profile verified for " + userEmail);
    }

    @Test(priority = 3, dependsOnMethods = "tc2_getUserProfile")
    public void tc3_updateUser() {
        userEmail = "upd_" + DataGenerator.getUniqueEmail();
        User update = new User("Updated", "User", userEmail, "newPass123");
        given().header("Authorization", "Bearer " + token).contentType(ContentType.JSON).body(update)
        .patch("/users/me").then().statusCode(200);
        test.info("Status Code: 200 | User email updated to: " + userEmail);
    }

    @Test(priority = 4, dependsOnMethods = "tc3_updateUser")
    public void tc4_loginUser() {
        String body = "{\"email\":\""+userEmail+"\",\"password\":\"newPass123\"}";
        Response res = given().contentType(ContentType.JSON).body(body).post("/users/login");
        token = res.jsonPath().getString("token");
        res.then().statusCode(200);
        test.info("Status Code: 200 | Login successful. New Token captured.");
    }

    @Test(priority = 5, dependsOnMethods = "tc4_loginUser")
    public void tc5_addContact() {
        Contact contact = new Contact("John", "Doe", "1980-05-05", "jdoe@test.com", "8005550199", "123 Maple", "Anytown", "NY", "10001", "USA");
        Response res = given().header("Authorization", "Bearer " + token).contentType(ContentType.JSON).body(contact).post("/contacts");
        contactId = res.jsonPath().getString("_id");
        res.then().statusCode(201);
        test.info("Status Code: 201 | Contact Created with ID: " + contactId);
    }

    @Test(priority = 6, dependsOnMethods = "tc5_addContact")
    public void tc6_getContactList() {
        given().header("Authorization", "Bearer " + token).get("/contacts")
        .then().statusCode(200).body("size()", greaterThan(0));
        test.info("Status Code: 200 | Contact list retrieved successfully.");
    }

    @Test(priority = 7, dependsOnMethods = "tc6_getContactList")
    public void tc7_getSingleContact() {
        given().header("Authorization", "Bearer " + token).get("/contacts/" + contactId)
        .then().statusCode(200).body("_id", equalTo(contactId));
        test.info("Status Code: 200 | Fetched Contact ID: " + contactId);
    }

    @Test(priority = 8, dependsOnMethods = "tc7_getSingleContact")
    public void tc8_updateContactFull() {
        Contact update = new Contact("Amy", "Miller", "1992-02-02", "amiller@test.com", "8005550199", "123 Maple", "Anytown", "NY", "10001", "USA");
        given().header("Authorization", "Bearer " + token).contentType(ContentType.JSON).body(update)
        .put("/contacts/" + contactId).then().statusCode(200).body("firstName", equalTo("Amy"));
        test.info("Status Code: 200 | Full update successful for Amy Miller.");
    }

    @Test(priority = 9, dependsOnMethods = "tc8_updateContactFull")
    public void tc9_updateContactPartial() {
        given().header("Authorization", "Bearer " + token).contentType(ContentType.JSON).body("{\"firstName\": \"Anna\"}")
        .patch("/contacts/" + contactId).then().statusCode(200).body("firstName", equalTo("Anna"));
        test.info("Status Code: 200 | Partial update successful. Name is now Anna.");
    }

    @Test(priority = 10, dependsOnMethods = "tc9_updateContactPartial")
    public void tc10_logout() {
        given().header("Authorization", "Bearer " + token).post("/users/logout").then().statusCode(200);
        test.info("Status Code: 200 | Session ended. Logout complete.");
    }
}