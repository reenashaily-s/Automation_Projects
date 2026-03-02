package com.RestAPITest;

import org.testng.annotations.Test;

import com.PojoClass.Auth;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


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

public class TC8_Serialization_Deserialization 
{
	@Test(priority=1)
	public void testSerialization() throws JsonProcessingException
	{
		Auth LoginDetails = new Auth();
		LoginDetails.setUsername("admin");
		LoginDetails.setPassword("password123");
		
		ObjectMapper objM =new ObjectMapper();
		String jsonData = objM.writerWithDefaultPrettyPrinter().writeValueAsString(LoginDetails);
		
		System.out.println(jsonData);
	}
	
	@Test(priority=2)
	public void testDeSerialization() throws JsonMappingException, JsonProcessingException
	{
		String jsonData="{\n"
		  		+ "  \"username\" : \"Jayesh\",\n"
		  		+ "  \"password\" : \"test1234\"\n"
		  		+ "}";
		  
		  ObjectMapper objm=new ObjectMapper();
		  Auth LoginDetails = objm.readValue(jsonData, Auth.class);
		  
		  System.out.println(LoginDetails.getUsername());
		  System.out.println(LoginDetails.getPassword());
	}
	
}