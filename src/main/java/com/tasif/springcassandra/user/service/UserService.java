package com.tasif.springcassandra.user.service;

import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tasif.springcassandra.user.dto.UserDto;
import com.tasif.springcassandra.user.model.User;
import com.tasif.springcassandra.user.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private ModelMapper modelmapper;
	
	@Autowired
	private UserRepository userRepository;

	public String createUser(UserDto createUser) {
		User user = modelmapper.map(createUser, User.class);
		String userId = UUID.randomUUID().toString().replaceAll("-", "");
		user.setUserId(userId);
		userRepository.save(user);
		return "User created successfully";
	}

	public List<User> getAllUser() {
		List<User> users = userRepository.findAll();
		return users;
	}

	public User getUser(String userId) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new RuntimeException("No user exist with user id " + userId));
		return user;
	}

	public String updateUser(String userId, UserDto userUpdate) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new RuntimeException("No user exist with user id " + userId));
		user.setUserName(userUpdate.getUserName());
		user.setUserEmail(userUpdate.getUserEmail());
		user.setUserMobileNumber(userUpdate.getUserMobileNumber());
		userRepository.save(user);
		return "User updated successfully";
	}

	public String deleteUser(String userId) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new RuntimeException("No user exist with user id " + userId));
		userRepository.delete(user);
		return "user deleted successfully";
	}

}
