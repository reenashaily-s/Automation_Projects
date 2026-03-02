package com.RestAPITest;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import org.json.JSONObject;
import org.json.JSONTokener;

import org.testng.annotations.Test;
import com.PojoClass.Auth;
import io.restassured.response.Response;


/*
 * given() : pre-requisite
 * header, path parameter, query parameter, request payload, authorization
 * ---------------------------------------------------------------------------
 *  
 * when()  : Action(type of request)
 * GET, POST, PUT, DELETE, PATCH
 * ---------------------------------------------------------------------------
 * 
 * then()  : Validate Response
 * status code, status message, response time, response payload, headers, cookies
 */

public class TC4_JsonPayload 
{
	@Test(priority=1)
    public void copyPaste()
    {
		System.out.println("-----Test Request Payload using Copy Paste-----");
		
    	Response res = given().header("Content-Type", "application/json")
    						  .body("{\n"
    								  + "    \"username\" : \"admin\",\n"
    								  + "    \"password\" : \"password123\"\n"
    								  + "}")
    				   .when().post("https://restful-booker.herokuapp.com/auth");
    	System.out.println("Status code: "+res.getStatusCode());
    	res.then().log().body();
    }	
	
	@Test(priority=2)
	public void HashMap()
	{
		System.out.println("-----Test Request Payload using HashMap-----");
		
		HashMap <String, Object> data = new HashMap<String, Object>();
		data.put("username", "admin");
		data.put("password", "password123");
		
    	Response res = given().header("Content-Type", "application/json")
    						  .body(data)
    				   .when().post("https://restful-booker.herokuapp.com/auth");
    	res.then().log().body();
    	
    	//print token
    	String actToken = res.jsonPath().getString("token");
  	    System.out.println(actToken);
	}
	
	@Test(priority=3)
	public void Pojo()
	{
		System.out.println("-----Test Request Payload using Pojo-----");
		
		//generate payload
		Auth LoginDetails = new Auth();
		LoginDetails.setUsername("admin");
		LoginDetails.setPassword("password123");
		Response res = given().header("Content-Type", "application/json")
				  			  .body(LoginDetails)
						.when().post("https://restful-booker.herokuapp.com/auth");
		res.then().log().body();
	}
	
	@Test(priority=4)
	public void JSONObjectClass()
	{
		System.out.println("-----Test Request Payload using JSON Object Class-----");
		
		JSONObject jo = new JSONObject();
		jo.put("username", "admin");
		jo.put("password", "password123");
		
		Response res = given().header("Content-Type", "application/json")
	  			  			  .body(jo.toString())
			.when().post("https://restful-booker.herokuapp.com/auth");
		res.then().log().body();
	}
	
	@Test(priority=5)
	public void byJsonFile() throws FileNotFoundException
	{
		System.out.println("-----Test Request Payload using JSON File-----");
		
		//read the data from the file - fileReader, JSONTokener, JSONObject
		File f1 = new File("AuthenticationData.json");
		FileReader fr = new FileReader(f1);
		JSONTokener token = new JSONTokener(fr);
		JSONObject j_obj = new JSONObject(token);
		
		Response res = given().header("Content-Type", "application/json")
							  .body(j_obj.toString())
					   .when().post("https://restful-booker.herokuapp.com/auth");
		res.then().log().body();
	}
		
}























