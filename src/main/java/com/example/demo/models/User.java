package com.example.demo.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class User {
//	@NotNull(message = "first name not be empty")
	String firstName;
	
//	@NotEmpty
//	@Size(min = 2 , max = 10 , message = "size of name between 2 to 10")
	String lastName;
	
//	@Pattern(regexp = "^[a-zA-Z0-9]+@[a-z]\.[a-z] {2,3}$")
	@NotNull
	String email;

//	@Pattern(regexp = "^[9,8,7,6]{1}[0-9]{9}$")
//	@NotNull
//	int mobileNumber;
	

	int id;
	
	String msg;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int i) {
		this.id = i;
	}
//	public int getMobileNumber() {
//		return mobileNumber;
//	}
//	public void setMobileNumber(int mobileNumber) {
//		this.mobileNumber = mobileNumber;
//	}
//	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
