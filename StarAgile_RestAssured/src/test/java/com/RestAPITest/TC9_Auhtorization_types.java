package com.RestAPITest;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class TC9_Auhtorization_types 
{
  @Test
  public void test_basicAuth() 
  {
	  Response res = given()
			  		.auth().basic("postman","password")			  
			  		.when().get("https://postman-echo.com/basic-auth");
	  res.then().log().body();
  }
  
  @Test
  public void digestAuth()
  {	  
	  Response res=given()
			  		.auth().digest("postman","password")
			  		.when().get("https://postman-echo.com/digest-auth");	  
	  res.then().log().body();
	  
  }
}
