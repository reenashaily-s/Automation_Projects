package com.RestAPITest;

import static io.restassured.RestAssured.given;
import org.json.JSONObject;
import org.testng.annotations.Test;
import com.PojoClass.Auth;
import com.PojoClass.Booking;
import com.PojoClass.BookingDates;
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

public class TC5_APIChaining 
{
	int booking_id;
	String tokenValue;
	
	@Test(priority=1)
	public void createNewBooking()
	{
		System.out.println("--------Create new booking------");
		//generate payload via pojo
		BookingDates date = new BookingDates();
		date.setCheckin("2018-01-01");
		date.setCheckout("2019-01-01");
		
		Booking booking_details = new Booking();
		booking_details.setFirstname("Reena"); 
		booking_details.setLastname("Sompalli");
		booking_details.setTotalprice(1199);
		booking_details.setDepositpaid(true);
		booking_details.setBookingdates(date);
		booking_details.setAdditionalneeds("Breakfast");
		
		
		Response res = given().header("Content-Type", "application/json")
							  .body(booking_details)
						.when().post("https://restful-booker.herokuapp.com/booking");
	
		System.out.println("Status code is: "+res.getStatusCode());	  
		res.then().log().body();
		
		//storing booking id from the result
		booking_id = res.jsonPath().getInt("bookingid");
		System.out.println("Booking created with id: "+booking_id);
	}
	
	@Test(priority=2)
	public void getBookingDetails()
	{
		System.out.println("-----Get Booking Details------");
		Response res = given()
						.when().get("https://restful-booker.herokuapp.com/booking/"+booking_id);
		res.then().log().body();
		System.out.println("Booking details for id:" +booking_id);
	}
	
	
	@Test(priority=3)
	public void createToken()
	{
		System.out.println("-------Create Auth Token--------");
		//generate payload
		Auth LoginDetails = new Auth();
		LoginDetails.setUsername("admin");
		LoginDetails.setPassword("password123");
		Response res = given().header("Content-Type", "application/json")		
							  .body(LoginDetails)
						.when().post("https://restful-booker.herokuapp.com/auth");

		res.then().log().body();
		tokenValue = res.jsonPath().getString("token");
		System.out.println("Token generated: "+tokenValue);
	}
	
	
	@Test(priority=4)
	public void fullUpdateBooking()
	{
		System.out.println("------Full update booking------");
		
		//generate payload
		BookingDates date = new BookingDates();
		date.setCheckin("2018-01-01");
		date.setCheckout("2019-01-01");
		
		Booking booking_details = new Booking();
		booking_details.setFirstname("Mahima");
		booking_details.setLastname("Maddala");
		booking_details.setTotalprice(1199);
		booking_details.setDepositpaid(true);
		booking_details.setBookingdates(date);
		booking_details.setAdditionalneeds("Uggu");
		
		
		Response res = given().header("Content-Type", "application/json")	
							  .header("Accept", "application/json")
							  .header("Cookie", "token="+tokenValue)
							  .body(booking_details)
					   .when().put("https://restful-booker.herokuapp.com/booking/"+booking_id);
		res.then().log().body();
		System.out.println("Booking updated with id: "+booking_id);
	}
	
	@Test(priority=5)
	public void partialUpdate()
	{
		System.out.println("------Partial update booking(Fname, Lname)------");
		JSONObject jo = new JSONObject();
		jo.put("firstname", "Teja");
		jo.put("lastname", "Maddala");
		jo.put("additionalneeds", "mutton");
		
		Response res = given().header("Content-Type", "application/json")	
							  .header("Accept", "application/json")
							  .header("Cookie", "token="+tokenValue)
	  			  			  .body(jo.toString())
	  			  		.when().patch("https://restful-booker.herokuapp.com/booking/"+booking_id);
		res.then().log().body();
	}
}























