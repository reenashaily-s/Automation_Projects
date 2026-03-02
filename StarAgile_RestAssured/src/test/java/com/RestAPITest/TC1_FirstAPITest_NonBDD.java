package com.RestAPITest;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;


public class TC1_FirstAPITest_NonBDD 
{
  @Test
  public void SingleObjectTest() 
  {
	 /*
	  * RestAssured as class
	  * Response is an interface 
	  */
	  
	  Response res = RestAssured.get("https://api.restful-api.dev/objects/7");
	  System.out.println("status code is: "+res.getStatusCode());
	  System.out.println("Status line: "+res.getStatusLine());
	  System.out.println("Ststus time: "+res.getTimeIn(TimeUnit.MILLISECONDS));
	  System.out.println("Header: "+res.getHeader("Content-Type"));
	  System.out.println("-------JSON Payload------");
	  System.out.println(res.asPrettyString());
  }
}
