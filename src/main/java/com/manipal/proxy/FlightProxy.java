package com.manipal.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.manipal.model.Booking;


@FeignClient(name="flight-service")
@RibbonClient(name="flight-service")
public interface FlightProxy {
	
	@PostMapping("booking/addBooking")
	public boolean addBookingDetails(@RequestBody Booking booking);
	
	@DeleteMapping("booking/cancelbooking/{bookingId}")
	public boolean deleteBooking(@PathVariable long bookingId);
	
	@GetMapping("booking/getdetailsbyid/{personId}")
	public Booking getBookingDetails(@PathVariable long personId);
}
