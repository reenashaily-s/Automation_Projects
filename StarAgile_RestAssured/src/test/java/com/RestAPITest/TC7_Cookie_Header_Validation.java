package com.RestAPITest;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

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

public class TC7_Cookie_Header_Validation 
{
	@Test(priority=1)
	public void testCookies()
	{
		Response res =	given()
						.when().get("https://www.google.com/");
		res.then().log().cookies();
	}
	
	@Test
	public void testHeader()
	{
		Response res =	given()
				.when().get("https://www.google.com/");
		res.then().log().headers();
	}
	
}























