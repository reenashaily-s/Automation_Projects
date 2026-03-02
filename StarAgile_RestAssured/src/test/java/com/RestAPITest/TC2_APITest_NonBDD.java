package com.RestAPITest;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;


public class TC2_APITest_NonBDD 
{
  @Test(priority=1)
  public void testSingleUser() 
  {
	  Response res=RestAssured.given().get("https://dummyjson.com/users/1");
	  	  
	  //get response payload
	  System.out.println(res.asPrettyString());
	  res.then().log().body();
	  
	  //validation for JSON Paylod
	  /*
	   * manual : let res = pm.response.json();
	   * automation : res.jsonPath();  
	   */
	  
	  //validate postal code
	  int postalC = res.jsonPath().getInt("company.address.postalCode");
	  Assert.assertEquals(postalC, 37657);
	  System.out.println("Postal code matched ! " +postalC);
	  
	  //validate country
	  String countryName= res.jsonPath().get("address.country");
	  Assert.assertEquals(countryName, "United States");
	  System.out.println("Country Name matched! " +countryName);	  
  }
  @Test(priority=2)  
  
  public void testAllUsers() 
  {
	  Response res=RestAssured.given().get("https://dummyjson.com/users");
	  System.out.println(res.asPrettyString());
	  res.then().log().body();
	  int userid = res.jsonPath().getInt("users[1].id");
	  Assert.assertEquals(userid, 2);
	  System.out.println("user id is: " +userid);
	  String Exp_Fname = res.jsonPath().getString("users[1].firstName");
	  String Act_Fname = "Michael";
	  Assert.assertTrue(Exp_Fname.contains(Act_Fname));
	  System.out.println("Name Matched to: "+Act_Fname);
	  
	  //to get all email id's
	  List<String> allEmails = res.jsonPath().getList("users.email");
	  System.out.println("All emails count is:" +allEmails.size());
	  
	  for(String i: allEmails)
	  {
		  System.out.println(i);
	  }
  }
  
}
