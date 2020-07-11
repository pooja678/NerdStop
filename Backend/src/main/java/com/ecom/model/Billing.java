package com.ecom.model;
import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Entity
@Component
public class Billing implements Serializable{
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)	
	private int billing_Id;  
/*	@NotEmpty(message=" Please enter your house number")*/
	private String houseNumber;
	
/*	@NotEmpty(message=" Please enter your street")*/
	private String street;
     
	
/*	@NotEmpty(message=" City Can not be left empty")*/
	private String city;
/*	@NotEmpty(message="Please enter your landmark")*/
	private String landMark;
/*	@NotEmpty(message="Please enter your state")*/
	private String state;
	
	
/*
	@NotNull(message="Please enter your pincoode")
	@Size(min=6, max=6)*/
	private int pinCode;

	public int getBilling_Id() {
		return billing_Id;
	}

	public void setBilling_Id(int billing_Id) {
		this.billing_Id = billing_Id;
	}



	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLandMark() {
		return landMark;
	}

	public void setLandMark(String landMark) {
		this.landMark = landMark;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	@OneToOne(cascade=CascadeType.ALL)
	private User user;

}

