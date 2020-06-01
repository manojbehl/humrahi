package com.ibm.humrahi.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class UserDto {

	
	private long id;

	private String userName;
	
	private String firstName;
	
	private String lastName;

	private String role;
	
	private String accessToken;
	
	private String aadharNumber;
	
	private String gender;
	
	private String addressLine1;
	
	private String addressLine2;
	
	private String city;
	
	private String state;
	
	private String zip;
	
	private String email;
	
	private Set<HelpTypeDto> helpProvided;


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

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

	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<HelpTypeDto> getHelpProvided() {
		if(helpProvided == null) {
			helpProvided = new HashSet<HelpTypeDto>();
		}
		return helpProvided;
	}

	public void setHelpProvided(Set<HelpTypeDto> helpProvided) {
		this.helpProvided = helpProvided;
	}

}
