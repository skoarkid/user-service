package com.manipal.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Embeddable
public class Contact {
	private Address address;
	private String email;
	@Column(name="mobile_no")
	private long mobileNo;
	public Contact() {
		super();
	}
	public Contact( Address address, String email, long mobileNo) {
		super();
		this.address = address;
		this.email = email;
		this.mobileNo = mobileNo;
	}

	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	
}
