package com.PojoClass;

public class Auth 
{
	/*
	 * POJO: plain old java object
	 * Encapsulation= private data(Keys) and public method
	 * {
    		"username" : "admin",
    		"password" : "password123"
	   }
	 */
	
	private String username;
	
	public String getUsername() 
	{
		return username;
	}
	
	public void setUsername(String username) 
	{
		this.username = username;
	}
	
	private String password;
	
	public String getPassword() 
	{
		return password;
	}
	
	public void setPassword(String password) 
	{
		this.password = password;
	}
	
	

}
 