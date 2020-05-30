package com.ibm.humrahi.dto;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import com.ibm.humrahi.entity.HelpType;

public class MigrantDto {

	private long id;
	
	private String name;
	
	private String mobileNumber;

	private String currentLocation;

	private String currentAddressLine1;

	private String currentAddressLine2;

	private String currentCity;

	private String currentState;

	private String currentZipcode;

	private String emergency;
	
	private String destinationAddressLine1;
	
	private String destinationAddressLine2;
	
	private String destinationCity;

	private String destinationState;

	private String destinationZipcode;

	private int peopleInGroup;

	private boolean covidSymptoms;
	
	private String dateTime;

	private long userId;
	
	private Set<HelpTypeDto> helpProvided;


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getCurrentLocation() {
		return currentLocation;
	}

	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
	}

	public String getCurrentAddressLine1() {
		return currentAddressLine1;
	}

	public void setCurrentAddressLine1(String currentAddressLine1) {
		this.currentAddressLine1 = currentAddressLine1;
	}

	public String getCurrentAddressLine2() {
		return currentAddressLine2;
	}

	public void setCurrentAddressLine2(String currentAddressLine2) {
		this.currentAddressLine2 = currentAddressLine2;
	}

	public String getCurrentCity() {
		return currentCity;
	}

	public void setCurrentCity(String currentCity) {
		this.currentCity = currentCity;
	}

	public String getCurrentState() {
		return currentState;
	}

	public void setCurrentState(String currentState) {
		this.currentState = currentState;
	}

	public String getCurrentZipcode() {
		return currentZipcode;
	}

	public void setCurrentZipcode(String currentZipcode) {
		this.currentZipcode = currentZipcode;
	}

	public String getEmergency() {
		return emergency;
	}

	public void setEmergency(String emergency) {
		this.emergency = emergency;
	}

	public String getDestinationAddressLine1() {
		return destinationAddressLine1;
	}

	public void setDestinationAddressLine1(String destinationAddressLine1) {
		this.destinationAddressLine1 = destinationAddressLine1;
	}

	public String getDestinationAddressLine2() {
		return destinationAddressLine2;
	}

	public void setDestinationAddressLine2(String destinationAddressLine2) {
		this.destinationAddressLine2 = destinationAddressLine2;
	}

	public String getDestinationCity() {
		return destinationCity;
	}

	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}

	public String getDestinationState() {
		return destinationState;
	}

	public void setDestinationState(String destinationState) {
		this.destinationState = destinationState;
	}

	public String getDestinationZipcode() {
		return destinationZipcode;
	}

	public void setDestinationZipcode(String destinationZipcode) {
		this.destinationZipcode = destinationZipcode;
	}

	public int getPeopleInGroup() {
		return peopleInGroup;
	}

	public void setPeopleInGroup(int peopleInGroup) {
		this.peopleInGroup = peopleInGroup;
	}

	public boolean isCovidSymptoms() {
		return covidSymptoms;
	}

	public void setCovidSymptoms(boolean covidSymptoms) {
		this.covidSymptoms = covidSymptoms;
	}


	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
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
