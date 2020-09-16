package com.manipal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manipal.model.Booking;
import com.manipal.model.Dashboard;
import com.manipal.model.User;
import com.manipal.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	IUserService userService;
	
	@PostMapping("register")
	public User registerUser(@RequestBody User user)
	{
		return userService.registerUser(user);
	}
	
	@PostMapping("login")
	public User userLogin(@RequestBody User user)
	{
		return userService.loginUser(user);
	}
	
	@PutMapping("passwordReset")
	public User resetPassword(@RequestBody User user)
	{
		return userService.resetPassword(user);
	}
	
	@PutMapping("updateUser")
	public User updateUser(@RequestBody User user)
	{
		return userService.updateUser(user);
	}
	
	@PutMapping("bookTickets")
	public boolean bookTickets(@RequestBody Booking booking)
	{
		return userService.bookTickets(booking);
	}
	
	@DeleteMapping("cancelTickets/{userId}")
	public boolean cancelTickets(@PathVariable long userId)
	{
		return userService.cancelTickets(userId);
	}
	
	@GetMapping("myDashboard/{userId}")
	public Dashboard getDashboard(@PathVariable long userId)
	{
		return userService.getDashboard(userId);
	}
}
