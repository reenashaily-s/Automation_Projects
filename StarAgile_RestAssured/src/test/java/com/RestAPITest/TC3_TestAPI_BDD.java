package com.RestAPITest;

import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;


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

public class TC3_TestAPI_BDD 
{
  @Test
  public void testSingleUser() 
  {
	Response res = given().
						when().get("https://dummyjson.com/users/1");
	System.out.println("Status code is: "+res.getStatusCode());	  
	res.then().log().headers();   
	    
  }
 
  
}
