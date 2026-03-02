package com.pojo;
public class User {
    private String firstName, lastName, email, password;
    public User(String fn, String ln, String em, String pw) {
        this.firstName = fn; this.lastName = ln; this.email = em; this.password = pw;
    }
    // Getters/Setters are required for Jackson to read the object
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
    
    
}