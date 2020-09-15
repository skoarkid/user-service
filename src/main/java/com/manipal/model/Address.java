package com.manipal.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Embeddable
public class Address {
	private String type;
	@Column(name="address_line")
	private String addressLine;
	@Column(name="zip_code")
	private long zipCode;
	private String city;
	private String state;
	private String country;
	
	public Address() {
		super();
	}

	public Address( String type, String addressLine, long zipCode, String city, String state, String country) {
		super();
		this.type = type;
		this.addressLine = addressLine;
		this.zipCode = zipCode;
		this.city = city;
		this.state = state;
		this.country = country;
	}



	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAddressLine() {
		return addressLine;
	}

	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
	}

	public long getZipCode() {
		return zipCode;
	}

	public void setZipCode(long zipCode) {
		this.zipCode = zipCode;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	
}
