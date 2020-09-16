package com.manipal.service;

import com.manipal.model.Booking;
import com.manipal.model.Dashboard;
import com.manipal.model.User;

public interface IUserService {

	User registerUser(User user);

	User loginUser(User user);

	User resetPassword(User user);

	User updateUser(User user);

	boolean bookTickets(Booking booking);

	boolean cancelTickets(long userId);

	Dashboard getDashboard(long userId);

}
