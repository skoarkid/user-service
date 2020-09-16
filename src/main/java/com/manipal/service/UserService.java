package com.manipal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manipal.exception.BookingNotFoundException;
import com.manipal.exception.IncorrectPasswordException;
import com.manipal.exception.IncorrectUsernameException;
import com.manipal.exception.UserNotFoundException;
import com.manipal.exception.UsernameExistsException;
import com.manipal.model.Booking;
import com.manipal.model.Dashboard;
import com.manipal.model.User;
import com.manipal.proxy.FlightProxy;
import com.manipal.repository.UserRepository;
import com.manipal.service.security.SecurityUtils;

@Service
public class UserService implements IUserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	FlightProxy flightProxy;
	
	@Override
	public User registerUser(User user) {
		if(userRepository.existsByUserName(user.getUserName()))
		{
			throw new UsernameExistsException("Username already exists. Please try another username");
		}
		user.setPassword(SecurityUtils.hashPassword(user.getPassword()));
		User toReturn=userRepository.save(user);
		toReturn.setPassword("");
		return toReturn;
	}

	@Override
	public User loginUser(User user) {
		if(!userRepository.existsByUserName(user.getUserName()))
		{
			throw new IncorrectUsernameException("Username is incorrect");
		}
		User toReturn = userRepository.findByUserName(user.getUserName());
		if(SecurityUtils.checkPass(user.getPassword(), toReturn.getPassword()))
		{
			toReturn.setPassword("");
			return toReturn;
		}
		throw new IncorrectPasswordException("Password is incorrect");
	}

	@Override
	public User resetPassword(User user) {
		User toUpdate = userRepository.findById(user.getId()).orElse(null);
		if(toUpdate==null)
		{
			throw new UserNotFoundException("User not found.Please provide correct Id");
		}
		toUpdate.setPassword(SecurityUtils.hashPassword(user.getPassword()));
		userRepository.save(toUpdate);
		toUpdate.setPassword("");
		return toUpdate;
	}

	@Override
	public User updateUser(User user) {
		User toUpdate = userRepository.findById(user.getId()).orElse(null);
		if(toUpdate==null)
		{
			throw new UserNotFoundException("User not found.Please provide correct Id");
		}
		toUpdate.setContact(user.getContact());
		toUpdate.setFirstName(user.getFirstName());
		toUpdate.setLastName(user.getLastName());
		userRepository.save(toUpdate);
		toUpdate.setPassword("");
		return toUpdate;
	}

	@Override
	public boolean bookTickets(Booking booking) {
		User person = userRepository.findById(booking.getPersonId()).orElse(null);
		if(person==null)
		{
			throw new UserNotFoundException("User not found.Please provide correct Id");
		}
		return flightProxy.addBookingDetails(booking);
	}

	@Override
	public boolean cancelTickets(long userId) {
		Booking booking = flightProxy.getBookingDetails(userId);
		if(booking==null)
		{
			throw new BookingNotFoundException("No bookings for this user");
		}
		return flightProxy.deleteBooking(booking.getBookingId());
	}

	@Override
	public Dashboard getDashboard(long userId) {
		User user = userRepository.findById(userId).orElse(null);
		if(user==null)
		{
			throw new UserNotFoundException("User not found.Please provide correct Id");
		}
		user.setPassword("");
		Booking booking = flightProxy.getBookingDetails(userId);
		if(booking==null)
		{
			throw new BookingNotFoundException("No bookings for this user");
		}
		return new Dashboard(user,booking);
	}

	
}
