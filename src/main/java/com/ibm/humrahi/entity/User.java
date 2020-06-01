package com.ibm.humrahi.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ibm.humrahi.dto.HelpTypeDto;

@Entity
@Table(name="USER")
public class User {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	
	@Column(name="user_name")
	private String userName;
	
	
	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	@Column(name="role")
	private String role;

	@Column(name="password")
	private String password;
	
	@Column(name="aadhar_number")
	private String aadharNumber;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="address_line1")
	private String addressLine1;
	
	@Column(name="address_lin22")
	private String addressLine2;
	
	@Column(name="city")
	private String city;
	
	@Column(name="state")
	private String state;
	
	@Column(name="zip")
	private String zip;
	
	@Column(name="email ")
	private String email;
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade=CascadeType.ALL)
	private Set<UserHelp> helpProvided;

	
	
	public User(long id, String userName, String firstName, String lastName,String role, String password) {
		this.id = id;
		this.userName= userName;
		this.firstName = firstName;
		this.lastName=lastName;
		this.password=password;
		this.role = role;
	}
	
	public User() {
		
	}



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


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public Set<UserHelp> getHelpProvided() {
		if(helpProvided == null) {
			helpProvided = new HashSet<UserHelp>();
		}
		return helpProvided;
	}

	public void setHelpProvided(Set<UserHelp> helpProvided) {
		this.helpProvided = helpProvided;
	}

}
