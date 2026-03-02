package com.RestAPITest;

import static io.restassured.RestAssured.given;
import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.Test;
import com.PojoClass.PostPojoData;
import com.PojoClass.PostPojoOuterRequest;
import io.restassured.response.Response;

public class PostRequestAssignment 
{
    @Test
    public void createObjectWithHashMap() 
    {
        System.out.println("===== Test Started: Create Object using HashMap =====");

        // Nested map for "data"
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("year", 2019);
        dataMap.put("price", 1849.99);
        dataMap.put("CPUmodel", "Intel Core i9");
        dataMap.put("Harddisksize", "1 TB");

        // Main request body
        Map<String, Object> reqBody = new HashMap<>();
        reqBody.put("name", "Apple MacBook Pro 16");
        reqBody.put("data", dataMap);

        // Send POST request
        Response res = given()
                .header("Content-Type", "application/json")
                .body(reqBody)
            .when()
                .post("https://api.restful-api.dev/objects");

        System.out.println("Status Code: " + res.getStatusCode());
        res.then().log().body();

        // Simple validations using jsonPath
        String name = res.jsonPath().getString("name");
        int year = res.jsonPath().getInt("data.year");
        double price = res.jsonPath().getDouble("data.price");
        String CPU = res.jsonPath().getString("data.CPUmodel");
        String disk = res.jsonPath().getString("data.Harddisksize");

        assert name.equals("Apple MacBook Pro 16");
        assert year == 2019;
        assert price == 1849.99;
        assert CPU.equals("Intel Core i9");
        assert disk.equals("1 TB");

        System.out.println("All validations passed!");
    }
    
 
    public class CreateObjectUsingPOJOTest 
    {
    	@Test
        public void createObjectWithPOJO() 
    	{
            System.out.println("===== Test Started: Create Object using POJO =====");

            // 1️⃣ Create the nested data object
            PostPojoData data = new PostPojoData(2019, 1849.99, "Intel Core i9", "1 TB");

            // 2️⃣ Create the main request object
            PostPojoOuterRequest reqBody = new PostPojoOuterRequest("Apple MacBook Pro 16", data);

            // 3️⃣ Send POST request
            Response res = given()
                    .header("Content-Type", "application/json")
                    .body(reqBody)
                .when()
                    .post("https://api.restful-api.dev/objects");

            // 4️⃣ Print status code and response body
            System.out.println("Status Code: " + res.getStatusCode());
            res.then().log().body();

            // 5️⃣ Simple validations using plain Java assertions
            assert res.getStatusCode() == 200 : "Expected status code 200";

            String name = res.jsonPath().getString("name");
            int year = res.jsonPath().getInt("data.year");
            double price = res.jsonPath().getDouble("data.price");
            String CPU = res.jsonPath().getString("data.CPUmodel");
            String disk = res.jsonPath().getString("data.Harddisksize");

            assert name.equals("Apple MacBook Pro 16") : "Name mismatch";
            assert year == 2019 : "Year mismatch";
            assert price == 1849.99 : "Price mismatch";
            assert CPU.equals("Intel Core i9") : "CPU model mismatch";
            assert disk.equals("1 TB") : "Harddisk size mismatch";

            // 6️⃣ Extract ID for future use
            String id = res.jsonPath().getString("id");
            System.out.println("Generated Object ID: " + id);

            System.out.println("===== Test Passed: Object Created Successfully =====");
        }
    }
    
}
