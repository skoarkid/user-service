package com.manipal.model;

import java.time.LocalDateTime;



public class Booking {
	private long personId;
	private long bookingId;
	private long flightNo;
	private LocalDateTime dateOfTravel;
	private String departureLocation;
	private String arrivalLocation;
	private int nooftickets;
	private String seatType;
	private double totalFare;

	public Booking() {}
	
	public Booking(long personId, long bookingId, long flightNo, LocalDateTime dateOfTravel, String departureLocation,
			String arrivalLocation, int nooftickets,String seatType, double totalFare) {
		super();
		this.personId = personId;
		this.bookingId = bookingId;
		this.flightNo = flightNo;
		this.dateOfTravel = dateOfTravel;
		this.departureLocation = departureLocation;
		this.arrivalLocation = arrivalLocation;
		this.nooftickets = nooftickets;
		this.seatType = seatType;
		this.totalFare=totalFare;
	}

	public long getPersonId() {
		return personId;
	}

	public void setPersonId(long personId) {
		this.personId = personId;
	}

	public long getBookingId() {
		return bookingId;
	}

	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}

	public long getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(long flightNo) {
		this.flightNo = flightNo;
	}

	public LocalDateTime getDateOfTravel() {
		return dateOfTravel;
	}

	public void setDateOfTravel(LocalDateTime dateOfTravel) {
		this.dateOfTravel = dateOfTravel;
	}

	public String getDepartureLocation() {
		return departureLocation;
	}

	public void setDepartureLocation(String departureLocation) {
		this.departureLocation = departureLocation;
	}

	public String getArrivalLocation() {
		return arrivalLocation;
	}

	public void setArrivalLocation(String arrivalLocation) {
		this.arrivalLocation = arrivalLocation;
	}

	public double getNooftickets() {
		return nooftickets;
	}

	public void setNooftickets(int nooftickets) {
		this.nooftickets = nooftickets;
	}

	
	public String getSeatType() {
		return seatType;
	}

	public void setSeatType(String seatType) {
		this.seatType = seatType;
	}
	

	public double getTotalFare() {
		return totalFare;
	}

	public void setTotalFare(double totalFare) {
		this.totalFare = totalFare;
	}

	@Override
	public String toString() {
		return "Booking [personId=" + personId + ", bookingId=" + bookingId + ", flightNo=" + flightNo
				+ ", dateOfTravel=" + dateOfTravel + ", departureLocation=" + departureLocation + ", arrivalLocation="
				+ arrivalLocation + ", nooftickets=" + nooftickets + ", seatType=" + seatType + ", totalFare="
				+ totalFare + "]";
	}
	}