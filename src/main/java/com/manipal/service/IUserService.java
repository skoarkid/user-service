package com.manipal.service;

import com.manipal.model.User;

public interface IUserService {

	User registerUser(User user);

	User loginUser(User user);

	User resetPassword(User user);

	User updateUser(User user);

}
