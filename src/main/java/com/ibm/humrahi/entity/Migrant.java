package com.ibm.humrahi.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "MIGRANT")
public class Migrant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "mobile_number")
	private String mobileNumber;

	@Column(name = "current_location")
	private String currentLocation;

	@Column(name = "current_address_line1")
	private String currentAddressLine1;

	@Column(name = "current_address_line2")
	private String currentAddressLine2;

	@Column(name = "current_city")
	private String currentCity;

	@Column(name = "current_state")
	private String currentState;

	@Column(name = "current_zipcode")
	private String currentZipcode;

	@Column(name = "emergency")
	private String emergency;

	@Column(name = "destination_address_line1")
	private String destinationAddressLine1;

	@Column(name = "destination_address_line2")
	private String destinationAddressLine2;

	@Column(name = "destination_city")
	private String destinationCity;

	@Column(name = "destination_state")
	private String destinationState;

	@Column(name = "destination_zipcode")
	private String destinationZipcode;

	@Column(name = "people_in_grp")
	private int peopleInGroup;

	@Column(name = "covid_sypmptoms")
	private boolean covidSymptoms;

	@Column(name = "date_time")
	private Timestamp dateTime;

	@Column(name = "user_id")
	private long userId;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "migrant", cascade=CascadeType.ALL)
	private Set<MigrantHelp> helpProvided;

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

	public Timestamp getDateTime() {
		return dateTime;
	}

	public void setDateTime(Timestamp dateTime) {
		this.dateTime = dateTime;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public Set<MigrantHelp> getHelpProvided() {
		if (helpProvided == null) {
			helpProvided = new HashSet<MigrantHelp>();
		}
		return helpProvided;
	}

	public void setHelpProvided(Set<MigrantHelp> helpProvided) {
		this.helpProvided = helpProvided;
	}

}
