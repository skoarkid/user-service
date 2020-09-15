package com.manipal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manipal.model.User;
import com.manipal.repository.UserRepository;

@Service
public class UserService implements IUserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public User registerUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User loginUser(User user) {
		User toReturn = userRepository.findByUserNameAndPassword(user.getUserName() , user.getPassword());
		return toReturn;
	}

	@Override
	public User resetPassword(User user) {
		User toUpdate = userRepository.findById(user.getId()).orElse(null);
		toUpdate.setPassword(user.getPassword());
		userRepository.save(toUpdate);
		return toUpdate;
	}

	@Override
	public User updateUser(User user) {
		User toUpdate = userRepository.findById(user.getId()).orElse(null);
		toUpdate.setContact(user.getContact());
		toUpdate.setFirstName(user.getFirstName());
		toUpdate.setLastName(user.getLastName());
		toUpdate.setUserName(user.getUserName());
		userRepository.save(toUpdate);
		return toUpdate;
	}

}
