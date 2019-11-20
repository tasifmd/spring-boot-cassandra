package com.tasif.springcassandra.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tasif.springcassandra.user.model.User;
import com.tasif.springcassandra.user.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public String createUser(User user) {
		userRepository.save(user);
		return "User created successfully";
	}

	public List<User> getAllUser() {
		List<User> users = userRepository.findAll();
		return users;
	}

	public User getUser(int userId) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new RuntimeException("No user exist with user id " + userId));
		return user;
	}

	public String updateUser(int userId, User userUpdate) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new RuntimeException("No user exist with user id " + userId));
		user.setUserId(userUpdate.getUserId());
		user.setUserName(userUpdate.getUserName());
		user.setUserEmail(userUpdate.getUserEmail());
		user.setUserMobileNumber(userUpdate.getUserMobileNumber());
		userRepository.save(user);
		return "User updated successfully";
	}

	public String deleteUser(int userId) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new RuntimeException("No user exist with user id " + userId));
		userRepository.delete(user);
		return "user deleted successfully";
	}

}
