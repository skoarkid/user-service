package com.manipal.model;

public class Dashboard {
	User user;
	Booking booking;
	public Dashboard() {
		super();
	}
	public Dashboard(User user, Booking booking) {
		super();
		this.user = user;
		this.booking = booking;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Booking getBooking() {
		return booking;
	}
	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	
}
